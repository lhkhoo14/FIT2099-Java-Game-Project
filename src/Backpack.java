public class Backpack {
    private Item[] items;

    public Backpack() {
        items = new Item[4];

        //Setting up values for each item
        Bottle bottle = new Bottle();
        bottle.brand = "Aquafin";
        bottle.weight = 200;
        bottle.capacity = 1.5;

        FlashLight flashlight = new FlashLight();
        flashlight.brand = "Sony";
        flashlight.weight = 500;

        Lockpick lockpick = new Lockpick();
        lockpick.brand = "lock";
        lockpick.weight = 100;

        SterilisationBox sterilisationBox = new SterilisationBox();
        sterilisationBox.brand = "pharmaeng";
        sterilisationBox.weight = 1000;

        //Storing items into items array
        items[0] = bottle;
        items[1] = flashlight;
        items[2] = lockpick;
        items[3] = sterilisationBox;
    }

    //Getter for CrewMember to access items
    public Item[] getItems() {
        return items;
    }
}