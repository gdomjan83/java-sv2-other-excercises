package kepesitovizsga1.army;

public class HeavyCavalry extends MilitaryUnit {
    public static final int HP = 150;
    public static final int DMG = 20;
    public static final boolean ARMOR = true;
    public boolean firstAttack;

    public HeavyCavalry() {
        setHitPoints(HP);
        setDamage(DMG);
        setArmor(ARMOR);
        this.firstAttack = true;
    }

    @Override
    public int doDamage() {
        if (firstAttack) {
            firstAttack = false;
            return super.doDamage() * 3;
        } else {
            return super.doDamage();
        }
    }
}
