package core;
import java.util.List;
import java.util.ArrayList;
import items.*;
import actions.*;

/**
 * Implements Backpack class
 * Represents a Backpack that stores Items for CrewMember
 * The Backpack has a weight limit and items can be added or removed
 */
public class Backpack implements ActionCapable {
    private List<Item> items;
    private int weightLimit = 10; //in kg
    private int currentWeight; //Current weight of backpack

    /**
     * public constructor for Backpack object
     * Set current weight at 0 and initializes it with default items
     */
    public Backpack() {
        this.currentWeight = 0;
        items = new ArrayList<>();

        //Setting up values for each item
        Bottle bottle = new Bottle("Aquafin", 0.5);

        FlashLight flashlight = new FlashLight("Sony", 1);

        Lockpick lockpick = new Lockpick("lock", 0.2);

        SterilisationBox sterilisationBox = new SterilisationBox("pharmaeng", 5);

        //Storing items into items array
        add(bottle);
        add(flashlight);
        add(lockpick);
        add(sterilisationBox);
    }

    /**
     * Adds item to Backpack if it doesn't exceed the weight limit
     *
     * @param item Item object being added
     * @return a boolean regarding whether the action is successful or not
     */
    public boolean add(Item item) {
        double estimatedweight = this.currentWeight + item.getWeight();
        if (estimatedweight > weightLimit) { //check if backpack will exceed limit after adding item
            return false;
        }
        this.items.add(item);
        this.currentWeight += item.getWeight();
        return true;
    }

    /**
     * Removes item from Backpack onto the Moon if it exists
     *
     * @param item Item object being removed
     * @return a boolean regarding whether it is successful or not
     */
    public boolean removeItem(Item item) {
        if (items.remove(item)) {
            currentWeight -= item.getWeight();
            return true;
        }
        return false;
    }

    /**
     * returns a list of allowable unpack actions for each item in the Backpack
     *
     * @return actions - ArrayList of UnpackAction of each item
     */
    @Override
    public List<Action> allowableActions(CrewMember crewMember) {
        List<Action> actions = new ArrayList<>();
        for (Item item : this.getItems()) {
            actions.add(item.getUnpackAction());
            actions.addAll(item.allowableActions(crewMember));
        }
        return actions;
    }

    /**
     * Getter for CrewMember to access items
     * Returns a copy of the list of items currently in Backpack
     * Uses defensive copying
     * @return items - the Backpack items attribute
     */
    public List<Item> getItems() {

        return new ArrayList<>(items);
    }

    /**
     * Getter to get Backpack current weight
     * Returns the current weight of Backpack
     *
     * @return currentWeight - the Backpack currentWeight attribute
     */
    public int getCurrentWeight() {

        return currentWeight;
    }
}