package zarovizsga2.cleaning;

import java.util.ArrayList;
import java.util.List;

public class CleaningService {
    private List<Cleanable> service = new ArrayList<>();

    public void add(Cleanable cleanable) {
        if (cleanable == null) {
            throw new IllegalArgumentException("Parameter is null.");
        }
        service.add(cleanable);
    }

    public int cleanAll() {
        int fullPrice = 0;
        for (Cleanable actual : service) {
            fullPrice += actual.clean();
        }
        service.clear();
        return fullPrice;
    }

    public int cleanOnlyOffices() {
        List<Cleanable> cleanedOffices = new ArrayList<>();
        int fullPrice = cleanOffices(cleanedOffices);
        service.removeAll(cleanedOffices);
        return fullPrice;
    }

    public List<Cleanable> findByAddressPart(String address) {
        return service.stream()
                .filter(s -> s.getAddress().contains(address))
                .toList();
    }

    public String getAddresses() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < service.size(); i++) {
            sb.append(service.get(i).getAddress());
            if (i < service.size() - 1) {
                sb.append(", ");
            }
        }
        return new String(sb);
    }

    public List<Cleanable> getCleanables() {
        return new ArrayList<>(service);
    }

    private int cleanOffices(List<Cleanable> cleanedOffices) {
        int fullPrice = 0;
        for (Cleanable actual : service) {
            if (actual instanceof Office) {
                fullPrice += actual.clean();
                cleanedOffices.add(actual);
            }
        }
        return fullPrice;
    }
}
