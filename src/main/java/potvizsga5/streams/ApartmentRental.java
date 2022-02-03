package potvizsga5.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApartmentRental {
    private List<Apartment> apartments = new ArrayList<>();

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public List<Apartment> findApartmentByLocation(String location) {
        return apartments.stream()
                .filter(a -> location.equals(a.getLocation()))
                .toList();
    }

    public List<Apartment> findApartmentByExtras(String... extras) {
        return apartments.stream()
                .filter(a -> a.getExtras().containsAll(Arrays.asList(extras)))
                .toList();
    }

    public boolean isThereApartmentWithBathroomType(BathRoomType type) {
        return apartments.stream()
                .anyMatch(a -> a.getBathRoomType() == type);
    }

    public List<Integer> findApartmentsSize() {
        return apartments.stream()
                .map(a -> a.getSize())
                .toList();
    }
}
