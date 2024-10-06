package model;

public class Community {
    // attributes
    private String name;
    private int population;
    // enums
    private TypeCommunity type;
    private Problem problem;
    // associations
    private Representative representative;

    /**
     * Creates a new community in the system.
     * 
     * @param name           The name of the community.
     * @param type           The type of the community.
     * @param representative The representative of the community.
     * @param population     The population of the community.
     * @param problem        The problem the community is facing.
     */
    public Community(String name, String type, Representative representative, int population, String problem) {
        this.name = name;
        setTypeCommunity(type);
        this.representative = representative;
        this.population = population;
        setProblem(problem);
    }
    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = Problem.valueOf(problem.toUpperCase());
    }

    public Representative getRepresentative() {
        return representative;
    }

    public TypeCommunity getTypeCommunity() {
        return type;
    }

    public void setTypeCommunity(String type) {
        this.type = TypeCommunity.valueOf(type.toUpperCase());
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    /************* ✨ Codeium Command ⭐ *************/
    /**
     * Returns a string representation of the community.
     * 
     * @return A string representation of the community.
     */
    /****** 61a8cacf-3c12-4337-8361-c9df9689ab6e *******/
    @Override
    public String toString() {
        return "Comunidad: " + name + ", Tipo: " + type + ", Población: " + population + ", Problema: " + problem;
    }
}
