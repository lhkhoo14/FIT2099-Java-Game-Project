package items;
import actions.*;
import core.Ability;
import core.CrewMember;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implements Item class
 * creates Item object with brand and weight attributes
 * Parent class for FlashLight, Lockpick, Bottle, SterilisationBox
 */
public class Item implements ActionCapable {
    String brand;  //
    double weight; //item weight in grams
    private Set<Ability> statuses = new HashSet<>();

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
     * Adds capability into item's status attribute
     * @param capability - the enum constant to be added
     */
    public void addCapability(Ability capability) { this.statuses.add(capability) ;}

    /**
     * Removes capability into item's status attribute
     * @param capability - the enum constant to be removed
     */
    public void removeCapability(Ability capability) { this.statuses.remove(capability) ;}

    /**
     * Checks whether this item has a specific capability
     * @param capability - enum constant to check for
     * @return true if it contains the capability, false otherwise
     */
    public boolean hasCapability(Ability capability) { return this.statuses.contains(capability); }

    /**
     * Returns a string representing the item's name, brand and weight
     * @return a formatted String showing item's information
     */
    @Override
    public String toString() {
        //Print out the item  brand and weight
        return String.format("%s (%s) has weight of %.2f kg",
                this.getSimpleName(),
                this.brand,
                this.weight);
    }

    /**
     * Returns a list of allowable actions that a crew member can perform on this item.
     * @param crewMember - Crew Member object interacting with this item
     * @return actions - an ArrayList containing allowable actions on this item
     */
    @Override
    public List<Action> allowableActions(CrewMember crewMember){
        List<Action> actions = new ArrayList<>();
        return actions;
    }
}