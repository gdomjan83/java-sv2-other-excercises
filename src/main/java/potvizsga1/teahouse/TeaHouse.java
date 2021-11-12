package potvizsga1.teahouse;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeaHouse {
    private String name;
    private List<Tea> teas = new ArrayList<>(Arrays.asList(new Tea("Kamillavirágzat", 1256,Sort.HERBAL_TEA),
            new Tea("Cseresznyés álom", 1745,Sort.FRUIT_TEA)));
    private LocalTime opening;
    private LocalTime closing;

    public TeaHouse(String name, LocalTime opening, LocalTime closing) {
        this.name = name;
        this.opening = opening;
        this.closing = closing;
    }

    public String getName() {
        return name;
    }

    public List<Tea> getTeas() {
        return teas;
    }

    public LocalTime getOpenTime() {
        return opening;
    }

    public LocalTime getCloseTime() {
        return closing;
    }

    public void addTea(Tea tea) {
        teas.add(tea);
    }

    public void setActionPrices(Sort sort, int percent) {
        for (Tea actual : teas) {
            if (actual.getSort() == sort) {
                int newPrice = actual.getPrice() * (100 - percent) / 100;
                actual.setPrice(newPrice);
            }
        }
    }

    public double getAveragePrice() {
        double total = 0;
        for (Tea actual : teas) {
            total += actual.getPrice();
        }
        return total / teas.size();
    }
}
