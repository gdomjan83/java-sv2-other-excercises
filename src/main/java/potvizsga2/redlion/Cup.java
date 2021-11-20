package potvizsga2.redlion;

public class Cup {
    private String name;
    private int price;
    private Sort sort;

    public Cup(String name, int price, Sort sort) {
        this.name = name;
        this.price = price;
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Sort getSort() {
        return sort;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%d Ft)", name, sort.getAdditionalInfo(), price);
    }
}
