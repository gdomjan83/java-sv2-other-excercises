package potvizsga8.bistros;

public class Bar extends Bistro {

    public Bar(String name, Address address) {
        super(name, address);
    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        if (menuItem.getType() == MenuItemType.DRINK) {
            super.addMenuItem(menuItem);
        } else {
            throw new IllegalArgumentException("Only drink can be added to menu!");
        }
    }

    @Override
    public String getName() {
        return super.getName() + " (Only Drinks)";
    }
}
