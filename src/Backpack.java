import java.util.List;
import java.util.ArrayList;

public class Backpack {
    private List<Item> items;

    public Backpack() {
        items = new ArrayList<>();

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
        items.add(bottle);
        items.add(flashlight);
        items.add(lockpick);
        items.add(sterilisationBox);
    }

    //Getter for CrewMember to access items
    public List<Item> getItems() {
        return items;
    }
}