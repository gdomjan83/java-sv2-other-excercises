package kepesitovizsga1.army;

public class Archer extends MilitaryUnit {
    public static final int HP = 50;
    public static final int DMG = 20;
    public static final boolean ARMOR = false;

    public Archer() {
        setHitPoints(HP);
        setDamage(DMG);
        setArmor(ARMOR);
    }
}
