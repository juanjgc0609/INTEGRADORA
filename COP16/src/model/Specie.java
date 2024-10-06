package model;

public class Specie {
    // Attributes
    private String name;
    private String photo;
    private int numberOfSpecimens;
    // enums
    private TypeSpecies type;

    /**
     * Constructs a new Specie object with the given attributes.
     *
     * @param name              The name of the species.
     * @param type              The type of the species (FLORA or FAUNA).
     * @param photo             (Optional) A photo of the species.
     * @param numberOfSpecimens The number of specimens in the population.
     */
    public Specie(String name, String type, String photo, int numberOfSpecimens) {
        this.name = name;
        setType(type);
        this.photo = photo;
        this.numberOfSpecimens = numberOfSpecimens;
    }

    // Getters and setters
    public int getNumberSpecimens() {
        return numberOfSpecimens;
    }

    public String getName() {
        return name;
    }

    public TypeSpecies getTypeSpecie() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = TypeSpecies.valueOf(type.toUpperCase());
    }

    public void setNumberSpecimens(int number) {
        this.numberOfSpecimens = number;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * Returns a string representation of the Specie object.
     * 
     * @return A string representation of the Specie object.
     */
    @Override
    public String toString() {
        return "Especie: " + name + ", Tipo: " + type + ", Número de especímenes: " + numberOfSpecimens;
    }
}
