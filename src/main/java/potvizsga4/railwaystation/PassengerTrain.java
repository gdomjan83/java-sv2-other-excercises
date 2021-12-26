package potvizsga4.railwaystation;

public class PassengerTrain extends Train {
    private boolean hasDiningCar;
    public static final int PASSANGERS = 70;

    public PassengerTrain(int numberOfWagons) {
        super(numberOfWagons);
        hasDiningCar = false;
    }

    public PassengerTrain(String name, int numberOfWagons) {
        super(numberOfWagons);
        setName(name);
        hasDiningCar = true;
    }

    public boolean hasDiningCar() {
        return hasDiningCar;
    }

    @Override
    public int calculateTravellingPeople() {
        if (hasDiningCar) {
            return (getNumberOfWagons() - 1) * PASSANGERS;
        } else {
            return getNumberOfWagons() * PASSANGERS;
        }
    }
}

