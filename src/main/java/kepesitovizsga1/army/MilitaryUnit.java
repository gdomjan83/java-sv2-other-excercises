package kepesitovizsga1.army;

public abstract class MilitaryUnit {
    private int hitPoints;
    private int damage;
    private boolean armor;

    public int getHitPoints() {
        return hitPoints;
    }

    public boolean isArmor() {
        return armor;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setArmor(boolean armor) {
        this.armor = armor;
    }

    public int doDamage() {
        return damage;
    }

    public void sufferDamage(int damage) {
        hitPoints -= armor ? (damage / 2) : damage;
    }
}
