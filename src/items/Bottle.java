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


    public Bottle(String brand,double weight) {
        super(brand, weight);
        this.capacity = 1;
    }

    @Override
    public String toString() {
        return super.toString() + " , capacity: " + capacity + " L";
    }

    @Override
    public List<Action> allowableActions(CrewMember crewMember) {
        List<Action> actions = new ArrayList<>();

        actions.add(new ConsumeAction(this)); //doesn't need sterilise to drink
        return actions;
    }

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