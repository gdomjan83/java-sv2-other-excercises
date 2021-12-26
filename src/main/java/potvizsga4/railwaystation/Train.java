package potvizsga4.railwaystation;

public abstract class Train {
    private String name;
    private int numberOfWagons;
    public static final int LENGTH_OF_WAGON = 15;

    public Train(int numberOfWagons) {
        this.numberOfWagons = numberOfWagons;
    }

    public int getNumberOfWagons() {
        return numberOfWagons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalLength() {
        return numberOfWagons * LENGTH_OF_WAGON;
    }

    public abstract int calculateTravellingPeople();
}
