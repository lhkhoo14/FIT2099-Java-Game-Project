package items;

import actions.Action;
import actions.ConsumeAction;
import core.Ability;
import core.Consumable;
import core.CrewMember;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a pack of Tortilla pack that can be consumed by a crew member
 * Can only be consumed when the crew member posses the STERILISE capability
 */
public class TortillaPack extends Item implements Consumable{
    private final int INCREASED_ENERGY_VALUE = 4;

    /**
     * Constructs a TortillaPack Object with specified brand attributes and initial weight
     * @param brand - the brand of the tortilla pack
     */
    public TortillaPack(String brand) {
        this.brand = brand;
        this.weight = 1; //kg
    }

    /**
     * Returns a list of allowable actions that a crew member can perform with this item
     * @param crewMember - Crew Member object interacting with this item
     * @return actions - an ArrayList of allowable actions with this item
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
     * Defines the effect of  the item being consumed by the crew member
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