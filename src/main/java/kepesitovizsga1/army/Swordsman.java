package kepesitovizsga1.army;

public class Swordsman extends MilitaryUnit{
    public static final int HP = 100;
    public static final int DMG = 10;
    public boolean hasShield;

    public Swordsman(boolean armor) {
        setHitPoints(HP);
        setDamage(DMG);
        setArmor(armor);
        this.hasShield = true;
    }

    @Override
    public void sufferDamage(int damage) {
        if (hasShield) {
            super.sufferDamage(0);
            hasShield = false;
        } else {
            super.sufferDamage(damage);
        }
    }
}
