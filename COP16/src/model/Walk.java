package model;

public class Walk {
    // Attributes
    private int participants;
    private int guides;
    private double temperature;
    private double humidity;
    // associations
    private Route route;
    private Volunteer volunteer;

    // Constructor
    /**
     * Creates a new walk with the given route, participants, guides, volunteer,
     * temperature, and humidity.
     * 
     * @param route        The route of the walk.
     * @param participants The number of participants in the walk.
     * @param guides       The number of guides for the walk.
     * @param volunteer    The volunteer assigned to the walk.
     * @param temperature  The temperature during the walk.
     * @param humidity     The humidity during the walk.
     */
    public Walk(Route route, int participants, int guides, Volunteer volunteer, double temperature, double humidity) {
        this.route = route;
        this.guides = guides;
        this.participants = participants;
        this.volunteer = volunteer;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    // getters and setters
    public int getGuides() {
        return guides;
    }

    public int getParticipants() {
        return participants;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public void setGuides(int guides) {
        this.guides = guides;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    /**
     * Calculates the total number of people in the walk.
     * 
     * @return The total number of people in the walk.
     */
    public int calculateTotalPeople() {
        return participants + guides;
    }

    /**
     * Calculates the number of buses needed for the walk.
     * 
     * @param totalPeople The total number of people in the walk.
     * @return The number of buses needed for the walk.
     */

    public int calculateBusesNeeded(int totalPeople) {
        return (int) Math.ceil(totalPeople / 25.0); // Cada bus tiene capacidad para 40 personas
    }

    /**
     * Determines if the weather is good for the walk.
     * 
     * @return True if the weather is good for the walk, false otherwise.
     */
    public boolean goodWeather() {
        return temperature >= 20 && temperature <= 25 && humidity >= 40 && humidity <= 60;
    }

    /**
     * Returns a string representation of the walk.
     * 
     * @return A string representation of the walk.
     */
    @Override
    public String toString() {
        return "Caminata: " + route.getType() + ", Guías: " + guides + ", Participantes: " + participants;
    }
}
