package kepesitovizsga3.zoo;

public class ZooAnimal {
    private String name;
    private int length;
    private long weight;
    private AnimalType type;

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public long getWeight() {
        return weight;
    }

    public AnimalType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }
}
