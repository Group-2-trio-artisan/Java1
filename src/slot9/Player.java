package slot9;

abstract class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    abstract void displayDetails();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
