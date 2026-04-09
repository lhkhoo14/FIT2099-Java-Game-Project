package items;

import actions.ActionCapable;
import actions.*;
import core.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a canned nut item that can be consumed by a crew member
 * This item increases the crew member's energy when consumed
 */
public class NutCan extends Item implements Consumable{
    private final int INCREASED_ENERGY_VALUE = 2;

    public NutCan(String brand) {
        this.brand = brand;
        this.weight = 0.5; //kg
    }

    /**
     * Represents the allowable actions of the item
     * @param crewMember - Crew Member object interacting with this item
     * @return actions - an ArrayList containing the allowable actions as an object
     */
    @Override
    public List<Action> allowableActions(CrewMember crewMember) {
        List<Action> actions = new ArrayList<>();

        if (crewMember.hasCapability(Ability.STERILISE)) {
            actions.add(new ConsumeAction(this));
        }
        return actions;
    }

    /**
     * Defines the effect of the item being consumed by the crew member
     * @param crewMember - CrewMember object that is consuming the item
     * @return a String showing the results of consuming the item
     */
    @Override
    public String consumedBy(CrewMember crewMember) {
        crewMember.increaseEnergyLevelBy(INCREASED_ENERGY_VALUE);
        crewMember.unpack(this);
        return this.getSimpleName() + " is consumed by " + crewMember.getName()
                + " and it increases the energy level by " + INCREASED_ENERGY_VALUE;
    }
}
