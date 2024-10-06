package ui;

import java.util.Scanner;

import model.Controller;

public class COP16 {
    // Attributes
    Scanner reader;
    // Aso
    Controller controller;

    public COP16() {
        reader = new Scanner(System.in);
        controller = new Controller();
    }

    /**
     * Main
     * main method for COP16
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Código para inicializar el sistema
        COP16 cop16 = new COP16();
        int opt = 0;
        while (opt != 11) {
            System.out.println("¿Que desea hacer?");
            System.out.println("1. Registrar voluntario");
            System.out.println("2. Para registrar una caminata");
            System.out.println("3. Para registrar un lugar con diversidad biológica");
            System.out.println("4. Para consultar los lugares ordenados de menor a mayor con respecto al área");
            System.out.println(
                    "5. Para consultar el departamento que tiene más lugares con diversidad biológica registrados hasta el momento.");
            System.out.println("6. Para ingresar una comunidad");
            System.out.println("7. Para ingresar una especie a un lugar");
            System.out.println("8. Modificar los datos de la especie en un lugar.");
            System.out.println("9. Para consultar la información de las comunidades con problemas");
            System.out.println("10. Para consultar el nombre del lugar con mayor cantidad de especies.");
            System.out.println("11. Salir");
            opt = cop16.reader.nextInt();
            cop16.reader.nextLine(); // Consume el salto de línea
            switch (opt) {
                case 1:
                    cop16.registerVolunteer();
                    break;
                case 2:
                    cop16.registerWalk();
                    break;
                case 3:
                    cop16.registerBiodiversePlace();
                    break;
                case 4:
                    cop16.showPlacesByArea();
                    break;
                case 5:
                    cop16.departmentWithMorePlaces();
                    break;
                case 6:
                    cop16.registerCommunity();
                    break;
                case 7:
                    cop16.registerSpecie();
                    break;
                case 8:
                    cop16.changeSpecie();
                    break;
                case 9:
                    cop16.consultCommunitiesByProblem();
                    break;
                case 10:
                    cop16.showPlaceNameWithMoreSpecies();
                    break;
                case 11:
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
        cop16.reader.close(); // Cierra el escáner al final
    }

    /**
     * Allows a volunteer to register in the system.
     * 
     * This method asks the user for his/her name and ID, then calls the
     * createVolunteer method in the controller to store the information.
     * 
     * After the volunteer is registered, a welcome message is displayed.
     */
    public void registerVolunteer() {
        // Código para registrar un voluntario
        System.out.println(
                "Bienvenido voluntario a la aplicación de Interacción de Rutas Ecológicas COP 16 Cali, Colombia");
        System.out.println("¿Cuál es tu nombre?");
        String name = reader.nextLine();
        System.out.println("Por favor, digita tu cédula");
        String id = reader.nextLine();
        controller.createVolunteer(name, id);
        System.out.println("¡Bienvenido, " + name + "!");
    }

    /**
     * Allows a volunteer to register a walk in the system.
     * 
     * This method asks the user for the number of participants and guides in the
     * walk, the type of route, temperature, and humidity.
     * Then it calls the asociateWalkToVolunteer method in the controller to store
     * the information.
     * 
     * After the walk is registered, a message is displayed indicating if the
     * weather is good for the walk or not.
     */
    public void registerWalk() {
        // Código para registrar una caminata
        System.out.println("¿Cuantos participantes acudirán a la caminata el día de hoy?");
        int participants = reader.nextInt();
        System.out.println("¿Cuántos guías acudirán a la caminata el día de hoy?");
        int guides = reader.nextInt();
        reader.nextLine();
        System.out.println("Ingresa el tipo de ruta (LADERA, FARALLONES, ORIENTE)");
        String routeType = reader.nextLine();
        System.out.println("Ingresa la temperatura");
        double temperature = reader.nextDouble();
        reader.nextLine();
        System.out.println("Ingresa la humedad");
        double humidity = reader.nextDouble();
        reader.nextLine();

        System.out.println(controller.asociateWalkToVolunteer(routeType, participants, guides, temperature, humidity));

    }

    /**
     * Allows a volunteer to register a biodiverse place in the system.
     * 
     * This method asks the user for the name, department, area, photo, inauguration
     * date, and budget of the place.
     * Then it calls the registerPlace method in the controller to store the
     * information.
     * 
     * After the place is registered, a message is displayed indicating if the place
     * was successfully registered or not.
     */
    public void registerBiodiversePlace() {
        // Código para registrar un lugar biodiverso
        System.out.println("Ingresa el nombre del lugar biodiverso");
        String name = reader.nextLine();
        System.out.println("Ingresa el departamento en el cual está el lugar");
        String department = reader.nextLine();
        System.out.println("Ingresa la cantidad de kilómetros cuadrados que abarca el lugar");
        double area = reader.nextDouble();

        reader.nextLine();

        System.out.println("Ingresa la foto del lugar");
        String photo = reader.nextLine();
        System.out.println("Ingresa la fecha de inauguración del lugar (AAAA-MM-DD)");
        String inauguration = reader.nextLine();
        System.out.println("Ingresa los recursos económicos necesarios para un buen cuidado del hábitat");
        double budget = reader.nextDouble();
        reader.nextLine();
        System.out.println(
                controller.registerPlace(name, department, area, photo, inauguration, budget));
    }

    /**
     * Allows a volunteer to register a community in the system.
     * 
     * This method asks the user for the name of the place where the community is
     * located, the name of the community, the type of the community, the name of
     * the community representative, the phone number of the representative, the
     * population of the community, and the problem the community is facing.
     * Then it calls the registerCommunity method in the controller to store the
     * information.
     * 
     * After the community is registered, a message is displayed indicating if the
     * community was successfully registered or not.
     */
    public void registerCommunity() {
        // Código para registrar una comunidad
        System.out.println("Ingresa el nombre del lugar donde se encuentra la comunidad");
        String bioPlaceName = reader.nextLine();
        System.out.println("Ingresa el nombre de la comunidad");
        String name = reader.nextLine();

        System.out.println("Ingresa el tipo de comunidad (AFROCOLOMBIANA, INDIGENA, RAIZAL)");
        String type = reader.nextLine();

        System.out.println("Ingresa el nombre del representante de la comunidad");
        String representativeName = reader.nextLine();

        System.out.println("Ingresa el número de teléfono del representante de la comunidad");
        String representativePhone = reader.nextLine();

        System.out.println("Ingresa la población de la comunidad");
        int population = reader.nextInt();
        reader.nextLine();
        System.out
                .println(
                        "Ingresa el problema de la comunidad (FALTA_AGUA, FALTA_HOSPITAL, FALTA_ESCUELA, FALTA_COMIDA)");
        String problem = reader.nextLine();
        controller.registerCommunity(name, type, representativeName, representativePhone, population, problem,
                bioPlaceName);
    }

    /**
     * Allows a volunteer to register a specie in the system.
     * 
     * This method asks the user for the name of the place where the specie is
     * located, the name of the specie, the type of the specie, the photo of the
     * specie, and the number of specimens of the specie.
     * Then it calls the asociateSpecieToPlace method in the controller to store the
     * information.
     * 
     * After the specie is registered, a message is displayed indicating if the
     * specie was successfully registered or not.
     */
    public void registerSpecie() {
        // Código para registrar una especie
        System.out.println("Ingresa el nombre del lugar a donde se le registrará la especie");
        String bioPlaceName = reader.nextLine();
        System.out.println("Ingresa el nombre de la especie");
        String name = reader.nextLine();
        System.out.println("Ingresa el tipo de la especie (flora/fauna)");
        String type = reader.nextLine();
        System.out.println("Ingresa la foto de la especie");
        String photo = reader.nextLine();
        System.out.println("Ingresa la cantidad de ejemplares de la especie");
        int numberOfSpecimens = reader.nextInt();
        reader.nextLine();
        System.out.println(
                controller.asociateSpecieToPlace(bioPlaceName, name, type, photo, numberOfSpecimens));
    }

    /**
     * Modifies a specie in a place.
     * 
     * This method asks the user for the name of the place, the name of the specie,
     * the new name of the specie, the new type of the specie, the new photo of the
     * specie, and the new number of specimens of the specie.
     * Then it calls the changeSpecie method in the controller to store the
     * information.
     * 
     * After the specie is modified, a message is displayed indicating if the specie
     * was successfully modified or not.
     */
    public void changeSpecie() {
        // Código para modificar una especie en un lugar
        System.out.println("Ingresa el nombre del lugar");
        String bioPlaceName = reader.nextLine();
        System.out.println("Ingresa el nombre de la especie");
        String specieName = reader.nextLine();
        System.out.println("Ingresa el nuevo nombre de la especie");
        String newSpecieName = reader.nextLine();
        System.out.println("Ingresa el nuevo tipo de la especie (flora/fauna)");
        String newSpecieType = reader.nextLine();
        System.out.println("Ingresa la nueva foto de la especie");
        String newSpeciePhoto = reader.nextLine();
        System.out.println("Ingresa la nueva cantidad de ejemplares de la especie");
        int newNumberOfSpecimens = reader.nextInt();
        reader.nextLine();
        System.out.println(controller.changeSpecie(bioPlaceName, specieName, newSpecieName, newSpecieType,
                newSpeciePhoto, newNumberOfSpecimens));
    }

    /**
     * Shows the places sorted by area.
     * 
     * This method calls the showPlacesByArea method in the controller to get a
     * string with the places sorted by area.
     * Then it prints the string to the console.
     */
    public void showPlacesByArea() {
        // Código para mostrar los lugares según su área
        System.out.println(controller.showPlacesByArea());
    }

    /**
     * Shows the department with more places.
     * 
     * This method calls the departmentWithMorePlaces method in the controller to
     * get the department with more places.
     * Then it prints the department to the console.
     */
    public void departmentWithMorePlaces() {
        // Código para mostrar el departamento con más lugares registrados
        System.out.println(controller.departmentWithMorePlaces());
    }

    /**
     * Consults the communities with a specific problem.
     * 
     * This method asks the user to input the problem to consult, and then it calls
     * the
     * consultCommunitiesByProblem method in the controller to get a string with the
     * information of the communities with the specified problem. Then it prints the
     * string to the console.
     */
    public void consultCommunitiesByProblem() {
        // Código para consultar la información de las comunidades con problemas
        System.out.println("Ingresa el problema a consultar");
        String problem = reader.nextLine();
        System.out.println(controller.consultCommunitiesByProblem(problem));
    }

    /**
     * Shows the place with the most species.
     * 
     * This method calls the showPlaceNameWithMoreSpecies method in the controller
     * to get a string with the name of the place with the most species.
     * Then it prints the string to the console.
     */
    public void showPlaceNameWithMoreSpecies() {
        // Código para consultar el lugar con más especies
        System.out.println(controller.showPlaceNameWithMoreSpecies());
    }
}
