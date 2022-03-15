package kepesitovizsga1.army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    public List<MilitaryUnit> army = new ArrayList<>();

    public void addUnit(MilitaryUnit militaryUnit) {
        army.add(militaryUnit);
    }

    public void damageAll(int damage) {
        army.forEach(m -> m.sufferDamage(damage));
        List<MilitaryUnit> unitsToRemove = army.stream().filter(m -> m.getHitPoints() < 25).toList();
        army.removeAll(unitsToRemove);
    }

    public int getArmyDamage() {
        return army.stream()
                .mapToInt(MilitaryUnit::doDamage)
                .sum();
    }

    public int getArmySize() {
        return army.size();
    }
}
