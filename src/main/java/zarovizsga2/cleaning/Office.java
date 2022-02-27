package zarovizsga2.cleaning;

public class Office implements Cleanable {
    private String address;
    private int area;
    private int floors;
    public static final int CLEANING_COST = 100;

    public Office(String address, int area, int floors) {
        this.address = address;
        this.area = area;
        this.floors = floors;
    }

    @Override
    public int clean() {
        return getFullArea() * CLEANING_COST;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public int getArea() {
        return area;
    }

    public int getFloors() {
        return floors;
    }

    private int getFullArea() {
        return area * floors;
    }
}
