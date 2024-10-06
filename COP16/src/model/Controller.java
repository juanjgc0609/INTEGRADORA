package model;

public class Controller {
    // Asociations
    private BiodiversePlace[] places;
    private Route[] routes;
    private Volunteer volunteer;
    private Community[] communities;

    /**
     * Creates a new controller.
     * 
     */
    public Controller() {
        this.routes = new Route[3];
        this.places = new BiodiversePlace[30];
        this.communities = new Community[30];
        // Inicializando la lista de rutas
        routes[0] = new Route(7, 0, 13, 30, "Bulevar del Río", "LADERA");
        routes[1] = new Route(7, 0, 13, 0, "Bulevar del Río", "ORIENTE");
        routes[2] = new Route(6, 40, 14, 30, "Calle 16 - Universidad del Valle", "FARALLONES");
    }

    /**
     * Creates a new volunteer in the system.
     * 
     * @param name The name of the volunteer.
     * @param id   The ID of the volunteer.
     * @return The created volunteer.
     */
    public Volunteer createVolunteer(String name, String id) {
        volunteer = new Volunteer(name, id);
        return volunteer;
    }

    /**
     * Creates a new walk based on the given route type.
     * 
     * @param routeType    The type of the route for the walk.
     * @param participants The number of participants in the walk.
     * @param guides       The number of guides for the walk.
     * @param volunteer    The volunteer assigned to the walk.
     * @param temperature  The temperature during the walk.
     * @param humidity     The humidity during the walk.
     * @return The created walk.
     */
    public Walk createWalk(String routeType, int participants, int guides, Volunteer volunteer, double temperature,
            double humidity) {
        Route route = searchRouteByType(routeType);
        return new Walk(route, participants, guides, volunteer, temperature, humidity);
    }

    /**
     * Registers a new biodiverse place in the system.
     * 
     * @param name         The name of the biodiverse place.
     * @param department   The department where the place is located.
     * @param area         The area of the place in square kilometers.
     * @param photo        A URL of the photo of the place.
     * @param inauguration The inauguration date of the place.
     * @param budget       The budget allocated to the place.
     * @return A message indicating if the place was successfully registered or not.
     */
    public String registerPlace(String name, String department, double area, String photo, String inauguration,
            double budget) {
        BiodiversePlace biodiversePlace = createBiodiversePlace(name, department, area, photo, inauguration, budget);
        String message = "";
        boolean added = false;
        for (int i = 0; i < places.length && !added; i++) {
            if (places[i] == null) {
                places[i] = biodiversePlace;
                added = true;
            }
        }
        if (added) {
            message = "Lugar ingresado con éxito.";
        } else {
            message = "Lugar no pudo ser ingresado, el sistema se encuentra lleno.";
        }
        return message;
    }

    /**
     * Creates a new biodiverse place without any species or community assigned.
     * 
     * @param name         The name of the biodiverse place.
     * @param department   The department where the place is located.
     * @param area         The area of the place in square kilometers.
     * @param photo        A URL of the photo of the place.
     * @param inauguration The inauguration date of the place.
     * @param budget       The budget allocated to the place.
     * @return The created biodiverse place.
     */
    public BiodiversePlace createBiodiversePlace(String name, String department, double area, String photo,
            String inauguration, double budget) {
        return new BiodiversePlace(name, department, area, photo, inauguration, budget);
    }

    /**
     * Creates a new community in the system.
     * 
     * @param name                The name of the community.
     * @param type                The type of the community.
     * @param representativeName  The name of the community representative.
     * @param representativePhone The phone number of the representative.
     * @param population          The population of the community.
     * @param problem             The problem the community is facing.
     * @return The created community.
     */
    public String registerCommunity(String name, String type, String representativeName, String representativePhone,
            int population, String problem, String bioPlaceName) {
        Community community = createCommunity(name, type, representativeName, representativePhone, population, problem);
        BiodiversePlace biodiversePlace = searchPlaceByName(bioPlaceName);
        String message = "";
        if (biodiversePlace != null) {
            boolean added = false;
            for (int i = 0; i < communities.length && !added; i++) {
                if (communities[i] == null) {
                    communities[i] = community;
                    added = true;
                }
            }
            if (added) {
                biodiversePlace.setCommunity(community);
                message = "Comunidad ingresada con electrónico.";
            } else {
                message = "Comunidad no pudo ser ingresada, el sistema se encuentra lleno.";
            }
        } else {
            message = "Comunidad no pudo ser ingresada, el lugar no existe.";
        }
        return message;
    }

    /**
     * Creates a new community in the system.
     * 
     * @param name                The name of the community.
     * @param type                The type of the community.
     * @param representativeName  The name of the community representative.
     * @param representativePhone The phone number of the representative.
     * @param population          The population of the community.
     * @param problem             The problem the community is facing.
     * @return The created community.
     */
    public Community createCommunity(String name, String type, String representativeName, String representativePhone,
            int population,
            String problem) {
        Representative representative = createRepresentative(representativeName, representativePhone);
        return new Community(name, type, representative, population, problem);
    }

    /**
     * Creates a new specie in the system.
     * 
     * @param name              The name of the specie.
     * @param type              The type of the specie (flora/fauna).
     * @param photo             A URL of the photo of the specie.
     * @param numberOfSpecimens The number of specimens of the specie.
     * @return The created specie.
     */

    public Specie createSpecie(String name, String type, String photo, int numberOfSpecimens) {
        return new Specie(name, type, photo, numberOfSpecimens);
    }

    /**
     * Creates a new representative in the system.
     * 
     * @param name  The name of the representative.
     * @param phone The phone number of the representative.
     * @return The created representative.
     */
    public Representative createRepresentative(String name, String phone) {
        return new Representative(name, phone);
    }

    /**
     * Shows the places sorted by area.
     * 
     * @return A message with the places sorted by area.
     */
    public String showPlacesByArea() {
        BiodiversePlace[] sortedPlaces = sortPlacesByArea();
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < sortedPlaces.length; i++) {
            if (sortedPlaces[i] != null) { // Asegurarse de que el lugar no sea nulo
                message.append(sortedPlaces[i].toString()).append("\n");
            }
        }
        return message.toString();
    }

    /**
     * Sorts the places by area.
     * 
     * @return The sorted places.
     */
    public BiodiversePlace[] sortPlacesByArea() {
        // Implementación del algoritmo para ordenar los lugares por área
        for (int i = 0; i < places.length - 1; i++) {
            for (int j = 0; j < places.length - i - 1; j++) {
                if (places[j].getArea() > places[j + 1].getArea()) {
                    // Intercambiar lugares si es necesario
                    BiodiversePlace temp = places[j];
                    places[j] = places[j + 1];
                    places[j + 1] = temp;
                }
            }
        }
        return places;
    }

    /**
     * Shows the department with more places.
     * 
     * @return A message with the department with more places.
     */
    public String departmentWithMorePlaces() {
        String departmentWithMorePlaces = "";
        int maxCount = 0;

        for (int i = 0; i < places.length; i++) {
            if (places[i] != null) {
                int count = 0;
                for (int j = 0; j < places.length; j++) {
                    if (places[j] != null && places[i].getDepartment().equals(places[j].getDepartment())) {
                        count++;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    departmentWithMorePlaces = places[i].getDepartment();
                }
            }
        }
        return departmentWithMorePlaces;
    }

    /**
     * Changes the specie of a place.
     * 
     * @param bioPlaceName         The name of the place.
     * @param specieName           The name of the specie to change.
     * @param newSpecieName        The new name of the specie.
     * @param newSpecieType        The new type of the specie.
     * @param newSpeciePhoto       The new photo of the specie.
     * @param newNumberOfSpecimens The new number of specimens of the specie.
     * @return A message with the result of the change.
     */
    public String changeSpecie(String bioPlaceName, String specieName, String newSpecieName, String newSpecieType,
            String newSpeciePhoto, int newNumberOfSpecimens) {
        // Lógica para cambiar la especie en el lugar seleccionado
        String message = "";
        BiodiversePlace bioPlace = searchPlaceByName(bioPlaceName);
        if (bioPlace == null) {
            message = "Lugar no encontrado";
        } else {
            Specie specie = bioPlace.searchSpecieByName(specieName);
            if (specie == null) {
                message = "Especie no encontrada";
            } else {
                specie.setName(newSpecieName);
                specie.setType(newSpecieType);
                specie.setPhoto(newSpeciePhoto);
                specie.setNumberSpecimens(newNumberOfSpecimens);
                message = "Especie cambiada";
            }
        }
        return message;
    }

    /**
     * Searches a walk by route type.
     * 
     * @param routeType The type of the route for the walk.
     * @return The found walk or null if not found.
     */
    public Walk searchWalkByRouteType(String routeType) {
        // Lógica para buscar una caminata por su tipo de ruta
        Walk walk = null;
        Walk[] walks = volunteer.getWalks();

        for (int i = 0; i < walks.length; i++) {
            if (walks[i] != null) {
                // Compara el nombre del enum con la ruta pasada
                if (walks[i].getRoute().getType().name().equalsIgnoreCase(routeType)) {
                    walk = walks[i];
                    break; // Sale del bucle una vez que se encuentra la caminata
                }
            }
        }

        return walk; // Retorna la caminata encontrada o null si no se encontró
    }

    /**
     * Asociates a walk to a volunteer.
     * 
     * @param routeType    The type of the route for the walk.
     * @param participants The number of participants in the walk.
     * @param guides       The number of guides for the walk.
     * @param temperature  The temperature during the walk.
     */
    public String asociateWalkToVolunteer(String routeType, int participants, int guides, double temperature,
            double humidity) {
        String message = "";
        if (volunteer == null) {
            message = "Voluntario no encontrado";
        } else {
            Walk walk = createWalk(routeType, participants, guides, volunteer, temperature, humidity);
            if (walk == null) {
                message = "La caminata no pudo ser creada";
            } else {
                message = walk.goodWeather() ? "¡Hace un buen día para caminar por Cali!"
                        : "¡No hace un buen día para caminar por Cali!";
                message += "\n Al ser un total de" + walk.calculateTotalPeople()
                        + "personas que harán parte de la actividad, se necesitarán un total de " +
                        walk.calculateBusesNeeded(walk.calculateTotalPeople())
                        + "buses para llevarla a cabo de manera exitosa. ¡Nos vemos en la COP16!";

            }
        }
        // Lógica para asociar una caminata a un voluntario

        return message;
    }

    /**
     * Asociates a species to a place.
     * 
     * @param placeName         The name of the place.
     * @param specieName        The name of the species.
     * @param specieType        The type of the species.
     * @param speciePhoto       The photo of the species.
     * @param numberOfSpecimens The number of specimens.
     */
    public String asociateSpecieToPlace(String placeName, String specieName, String specieType, String speciePhoto,
            int numberOfSpecimens) {
        // Lógica para asociar una especie a un lugar
        BiodiversePlace place = searchPlaceByName(placeName);
        String message = "";
        if (place == null) {
            message = "Lugar no encontrado";
        } else {
            Specie specie = createSpecie(specieName, specieType, speciePhoto, numberOfSpecimens);
            place.addSpecie(specie);
            message = "Especie asociada correctamente";
        }
        return message;
    }

    /**
     * Searches for a place by its name.
     * 
     * @param name The name of the place.
     * @return The place with the given name.
     */

    public BiodiversePlace searchPlaceByName(String name) {
        BiodiversePlace place = null;
        for (int i = 0; i < places.length; i++) {
            if (place != null && places[i].getName().equals(name)) {
                place = places[i];
                break;
            }
        }
        return null;
    }

    /**
     * Searches for a community by its name.
     * 
     * @param name The name of the community.
     * @return The community with the given name.
     */
    public Community searchCommunityByName(String name) {
        // Lógica para buscar una comunidad por su nombre
        Community community = null;
        for (int i = 0; i < places.length; i++) {
            if (community != null && places[i].getCommunity().getName().equals(name)) {
                community = places[i].getCommunity();
                break;
            }
        }
        return community;

    }

    /**
     * Searches for a route by its type.
     * 
     * @param type The type of the route.
     * @return The route with the given type.
     */
    public Route searchRouteByType(String type) {
        // Lógica para buscar una ruta por su tipo
        Route route = null;
        for (int i = 0; i < routes.length; i++) {
            if (routes[i].getType().equals(type.toUpperCase())) {
                route = routes[i];
                break;
            }
        }
        return route;
    }

    /**
     * Consults the communities with a specific problem.
     * 
     * @param problem The problem to consult.
     * @return A message listing the communities that have the specified problem.
     */
    public String consultCommunitiesByProblem(String problem) {
        // Logic to return the communities with the specified problem
        Community[] communitiesWithProblem = new Community[places.length];
        for (int i = 0; i < places.length; i++) {
            if (places[i].getCommunity().getProblem().equals(problem.toUpperCase())) {
                communitiesWithProblem[i] = places[i].getCommunity();
            }
        }
        String message = "";
        if (communitiesWithProblem.length == 0) {
            message = "No communities with problems.";
        } else {
            message = "The communities with problems are: \n";
            for (int i = 0; i < communitiesWithProblem.length; i++) {
                message += communitiesWithProblem[i].toString() + "\n";
            }
        }
        return message;
    }

    /**
     * Shows the place with the most species.
     * 
     * @return A message with the name of the place that has the most species.
     */
    public String showPlaceNameWithMoreSpecies() {
        String message = "";
        BiodiversePlace placeWithMoreSpecies = null;
        int maxCount = 0;

        for (int i = 0; i < places.length; i++) {
            if (places[i] != null && places[i].getSpecies() != null) {
                int count = 0;
                for (int j = 0; j < places[i].getSpecies().length; j++) {
                    if (places[i].getSpecies()[j] != null) {
                        count++;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    placeWithMoreSpecies = places[i];
                }
            }
        }

        if (placeWithMoreSpecies != null) {
            message = "El lugar con más especies es: " + placeWithMoreSpecies.getName();
        } else {
            message = "No hay lugares con especies registradas.";
        }

        return message;
    }

}
