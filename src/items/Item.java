package items;
import actions.*;
import core.ActionCapable;
import core.CrewMember;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements Item class
 * creates Item object with brand and weight attributes
 * Parent class for FlashLight, Lockpick, Bottle, SterilisationBox
 */
public class Item implements ActionCapable {
    String brand;  //
    double weight; //item weight in grams

    /**
     * default constructor for item object
     */
    public Item() {
        this.brand = "Unknown";
        this.weight = 0;
    }

    /**
     * constructor of item object with initial values
     * @param brand brand of item
     * @param weight weight of item
     */
    public Item(String brand, double weight) {
        this.brand = brand;
        this.weight = weight;
    }

    /**
     * @return name of class
     */
    public String getSimpleName() {return this.getClass().getSimpleName(); }

    /**
     * Getter to get weight
     * @return weight
     */
    public double getWeight(){
        return weight;
    }

    /**
     * return the action to pack this item
     * @return PackAction object for this item
     */
    public Action getPackAction() {return new PackAction(this);}

    /**
     * return the action to unpack this item
     * @return PackAction object for this item
     */
    public Action getUnpackAction() {return new UnpackAction(this);}

    /**
     * @return String of item information
     */
    @Override
    public String toString() {
        //Print out the item  brand and weight
        return String.format("%s (%s) has weight of %.2f kg",
                this.getSimpleName(),
                this.brand,
                this.weight);
    }

    @Override
    public List<Action> allowableActions(CrewMember crewMember){
        List<Action> actions = new ArrayList<>();
        return actions;
    }
}