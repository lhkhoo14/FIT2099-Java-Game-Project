package items;

import actions.Action;
import actions.ConsumeAction;
import core.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the bottle subclass
 * create Bottle object with super class attributes with addition of capacity
 * Override toString method to output capacity as well
 */
public class Bottle extends Item implements Consumable {
    double capacity; //Litres stored
    private final int INCREASED_ENERGY_VALUE = 2;
    private final double DRINK_AMOUNT = 0.15;

    /**
     * Represents a bottle in the simulation
     * @param brand - Bottle attribute
     * @param weight - Bottle attribute
     */
    public Bottle(String brand,double weight) {
        super(brand, weight);
        this.capacity = 1;
    }

    /**
     * Override toString method to show capacity of bottle as well
     * @return a String that shows the capacity of the bottle
     */
    @Override
    public String toString() {
        return super.toString() + " , capacity: " + capacity + " L";
    }

    /**
     * Represents the allowable actions of the bottle
     * @param crewMember - CrewMember object
     * @return actions - an ArrayList containing the allowable actions
     */
    @Override
    public List<Action> allowableActions(CrewMember crewMember) {
        List<Action> actions = new ArrayList<>();

        actions.add(new ConsumeAction(this)); //doesn't need sterilise to drink
        return actions;
    }

    /**
     * Allows the crew member to consume the contents of the bottle
     * @param crewMember - the crew member consuming the bottle
     * @return a String showing the results of the action
     */
    @Override
    public String consumedBy(CrewMember crewMember) {
        if (this.capacity - DRINK_AMOUNT > 0) {
            crewMember.increaseEnergyLevelBy(INCREASED_ENERGY_VALUE);
            this.capacity -= DRINK_AMOUNT;
            return this.getSimpleName() + " is consumed by " + crewMember.getName()
                    + " and it increased the energy level by " + INCREASED_ENERGY_VALUE;
        }
        crewMember.unpack(this);
        return this.getSimpleName() + " is empty.";
    }
}