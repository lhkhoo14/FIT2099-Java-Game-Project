package actions;

import core.Consumable;
import core.CrewMember;
import core.Moon;

/**
 * Implements a ConsumeAction class that allows crew member to consume a consumable item
 */
public class ConsumeAction extends Action {
    private Consumable consumable;

    /**
     * Construct a ConsumeAction object with the specific consumable item
     * @param consumable - the item to be consumed
     */
    public ConsumeAction(Consumable consumable) {
        this.consumable = consumable; }

    /**
     * Executes the consume object by calling the consumedBy() method
     * @param crewMember -  crewMember object in the simulation
     * @param moon - Moon object in the simulation
     * @return a description of the result after consuming the item
     */
    @Override
    public String execute(CrewMember crewMember, Moon moon) {
        return consumable.consumedBy(crewMember);
    }

    /**
     * Returns a description of this action to be displayed in the menu
     * @param crewMember - CrewMember Object who's performing the action
     * @return a String showing the description of the result of the action
     */
    @Override
    public String menuDescription(CrewMember crewMember) {
        return crewMember.getName() + " will consume " + consumable.getClass().getSimpleName();
    }
}
