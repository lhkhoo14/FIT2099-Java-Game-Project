import java.util.List;
import java.util.ArrayList;

public class Backpack {
    private List<Item> items;

    public Backpack() {
        items = new ArrayList<>();

        //Setting up values for each item
        Bottle bottle = new Bottle("Aquafin",200, 1.5);

        FlashLight flashlight = new FlashLight("Sony", 500);

        Lockpick lockpick = new Lockpick("lock", 100);

        SterilisationBox sterilisationBox = new SterilisationBox("pharmaeng", 1000);

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