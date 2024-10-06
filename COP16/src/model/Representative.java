package model;

public class Representative {

    // attributes
    private String name;
    private String cellphone;

    /**
     * Creates a new representative in the system.
     * 
     * @param name      The name of the representative.
     * @param cellphone The cellphone of the representative.
     */

    public Representative(String name, String cellphone) {
        this.name = name;
        this.cellphone = cellphone;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public String getCellphone() {
        return cellphone;
    }

    /**
     * Returns a string representation of the representative.
     * 
     * @return A string representation of the representative.
     */
    @Override
    public String toString() {
        return "Representante: " + name + ", Celular: " + cellphone;
    }
}
