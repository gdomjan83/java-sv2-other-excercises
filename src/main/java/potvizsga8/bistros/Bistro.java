package potvizsga8.bistros;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bistro {
    private String name;
    private Address address;
    private List<MenuItem> menu = new ArrayList<>();

    public Bistro(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<MenuItem> getMenu() {
        return new ArrayList<>(menu);
    }

    public void addMenuItem(MenuItem menuItem) {
        if (menuItem != null) {
            menu.add(menuItem);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bistro bistro = (Bistro) o;
        return name.equals(bistro.name) && address.getStreet().equals(bistro.getAddress().getStreet()) && address.getNumber() == bistro.getAddress().getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address.getStreet(), address.getNumber());
    }
}
