import java.util.List;
import java.util.ArrayList;

public class Backpack {
    private List<Item> items;
    private int weightLimit = 10; //in kg
    private int currentWeight; //Current weight of backpack

    public Backpack() {
        this.currentWeight = 0;
        items = new ArrayList<>();

        //Setting up values for each item
        Bottle bottle = new Bottle("Aquafin",0.5, 1.5);

        FlashLight flashlight = new FlashLight("Sony", 1);

        Lockpick lockpick = new Lockpick("lock", 0.2);

        SterilisationBox sterilisationBox = new SterilisationBox("pharmaeng", 5);

        //Storing items into items array
        add(bottle);
        add(flashlight);
        add(lockpick);
        add(sterilisationBox);
    }
    public boolean add(Item item){
        double estimatedweight = this.currentWeight + item.getWeight();
        if (estimatedweight > weightLimit){ //check if backpack will exceed limit after adding item
            return false;
        }
        this.items.add(item);
        this.currentWeight += item.getWeight();
        return true;
    }

    public boolean removeItem(Item item){
        if (items.remove(item)) {
            currentWeight -= item.getWeight();
            return true;
        }
        return false;
    }

    public List<Action> allowableActions(){
        List<Action> actions = new ArrayList<>();
        for (Item item: this.getItems()) {
            actions.add(item.getUnpackAction());
        }
        return actions;
    }

    //Getter for CrewMember to access items
    public List<Item> getItems() {
        return items;
    }
    //Getter to get backpack current weight
    public int getCurrentWeight() {
        return currentWeight;
    }
}