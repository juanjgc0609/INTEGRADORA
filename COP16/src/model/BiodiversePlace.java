package model;

import java.time.LocalDate;

public class BiodiversePlace {
    // Attributes
    private String name;
    private String department;
    private double area;
    private String photo;
    private LocalDate inaugurationDate;
    private double budget;
    // associations
    private Specie[] species;
    private Community community;

    /**
     * Creates a new biodiverse place with the given attributes.
     * 
     * @param name             The name of the biodiverse place.
     * @param department       The department where the place is located.
     * @param area             The area of the biodiverse place.
     * @param photo            The URL of the photo of the biodiverse place.
     * @param inaugurationDate The inauguration date of the biodiverse place.
     * @param budget           The budget allocated to the biodiverse place.
     */
    public BiodiversePlace(String name, String department, double area, String photo, String inaugurationDate,
            double budget) {
        this.name = name;
        this.area = area;
        this.department = department;
        this.photo = photo;
        this.inaugurationDate = LocalDate.parse(inaugurationDate);
        this.budget = budget;
        this.species = new Specie[50];
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public LocalDate getInaugurationDate() {
        return inaugurationDate;
    }

    public void setInaugurationDate(LocalDate inaugurationDate) {
        this.inaugurationDate = inaugurationDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Specie[] getSpecies() {
        return species;
    }

    public void setSpecies(Specie[] species) {
        this.species = species;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    /**
     * Searches for a specie by its name.
     * 
     * @param name The name of the specie.
     * @return The found specie or null if not found.
     */
    public Specie searchSpecieByName(String name) {
        Specie specie = null;
        for (int i = 0; i < species.length; i++) {
            if (species[i] != null && species[i].getName().equals(name)) {
                specie = species[i];
                break;
            }
        }
        return specie;
    }

    /**
     * Adds a specie to the place if there is available space.
     * 
     * @param specie The specie to add.
     * @return True if the specie was added, false otherwise.
     */
    public boolean addSpecie(Specie specie) {
        boolean added = false;
        for (int i = 0; i < species.length && !added; i++) {
            if (species[i] == null) {
                species[i] = specie;
                added = true;
            }
        }
        return added;
    }

    /**
     * Returns a string representation of the BiodiversePlace object.
     * 
     * @return A string representation of the BiodiversePlace object.
     */
    @Override
    public String toString() {
        return "Lugar: " + name + ", Área: " + area + ", Departamento: " + department;
    }
}
