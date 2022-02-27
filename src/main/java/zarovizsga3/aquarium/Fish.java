package zarovizsga3.aquarium;

public abstract class Fish {
    private String name;
    private int weight;
    private String color;
    protected boolean memoryLoss;

    public Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public boolean hasMemoryLoss() {
        return memoryLoss;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String status() {
        return String.format("%s, weight: %d, color: %s, short term memory loss: %s", name, weight, color, memoryLoss);
    }

    public abstract void feed();
}
