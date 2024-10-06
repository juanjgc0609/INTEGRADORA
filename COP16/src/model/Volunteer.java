package model;

public class Volunteer {
    // Attributes
    private String name;
    private String id;
    private int walkCount;

    // Associations
    private Walk[] walks;

    /**
     * Constructor
     * 
     * Creates a new volunteer with the given name and ID.
     * 
     * @param name - Volunteer name
     * @param id   - Volunteer ID
     */
    public Volunteer(String name, String id) {
        this.name = name;
        this.id = id;
        this.walks = new Walk[10];
        this.walkCount = 0;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Walk[] getWalks() {
        Walk[] actualWalks = new Walk[walkCount];
        for (int i = 0; i < walkCount; i++) {
            actualWalks[i] = walks[i];
        }
        return actualWalks; // Retorna solo las caminatas almacenadas hasta el momento
    }

    public void addWalk(Walk walk) {
        if (walkCount < walks.length) {
            walks[walkCount] = walk;
            walkCount++;
        } else {
            System.out.println("No se pueden agregar más caminatas. Espacio insuficiente.");
        }
    }
}
