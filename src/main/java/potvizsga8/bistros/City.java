package potvizsga8.bistros;

import java.util.*;

public class City {
    private Set<Bistro> bistros = new HashSet<>();

    public void addBistro(Bistro bistro) {
        if (bistro != null) {
            bistros.add(bistro);
        }
    }

    public Set<Bistro> getBistros() {
        return new HashSet<>(bistros);
    }

    public Bistro findBistroByAddress(Address address) {
        return bistros.stream()
                .filter(b -> address.getStreet().equals(b.getAddress().getStreet()) && address.getNumber() == b.getAddress().getNumber())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No bistro at that address."));
    }

    public Bistro findLongestMenu() {
        return bistros.stream()
                .max(Comparator.comparing(b -> b.getMenu().size()))
                .orElseThrow(() -> new IllegalArgumentException("Can not find longest menu."));
    }

    public List<Bistro> findBistroWithMenuItem(String menuItemName) {
        List<Bistro> result = new ArrayList<>();
        for (Bistro actual : bistros) {
            if (actual.getMenu().stream().anyMatch(m -> menuItemName.equals(m.getName()))) {
                result.add(actual);
            }
        }
        return result;
    }
}
