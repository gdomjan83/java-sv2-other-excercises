package potvizsga2.redlion;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedLion {
    private String name;
    private List<Cup> teas = new ArrayList<>(Arrays.asList(new Cup("Kamillavirágzat", 1256,Sort.HERBAL_TEA), new Cup ("Cseresznyés álom", 1745,Sort.FRUIT_TEA)));
    private LocalTime openTime;
    private LocalTime closeTime;

    public RedLion(String name, LocalTime openTime, LocalTime closeTime) {
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public String getName() {
        return name;
    }

    public List<Cup> getTeas() {
        return teas;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void addCup(Cup cup) {
        teas.add(cup);
    }

    public void setActionPrices(Sort sort, int percent) {
        for (Cup actual : teas) {
            if (actual.getSort() == sort) {
                actual.setPrice(actual.getPrice() * (100 - percent) / 100);
            }
        }
    }

    public double getAveragePrice() {
        double total = 0;
        for (Cup actual : teas) {
            total += actual.getPrice();
        }
        return total / teas.size();
    }
}
