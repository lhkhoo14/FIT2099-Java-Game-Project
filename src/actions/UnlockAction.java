package actions;

import core.Consumable;
import core.CrewMember;
import core.Moon;
import items.Item;
import items.TreasureBox;

/**
 * Implements a UnlockAction class that allows crew member to unlock an unlockable item
 */
public class UnlockAction extends Action {
    private TreasureBox unlockable;

    /**
     * Constructs an UnlockAction object with a specific unlockable item
     * @param unlockable - unlockable item
     */
    public UnlockAction(TreasureBox unlockable) {
        this.unlockable = unlockable; }

    /**
     * Executes the consume object by calling the consumedBy() method
     * @param crewMember -  crewMember object in the simulation
     * @param moon - Moon object in the simulation
     * @return a description of the result after consuming the item
     */
    @Override
    public String execute(CrewMember crewMember, Moon moon) {
        return unlockable.unlockedBy(crewMember);
    }

    /**
     * Returns a description of this action to be displayed in the menu
     * @param crewMember - CrewMember Object who's performing the action
     * @return a String showing the description of the result of the action
     */
    @Override
    public String menuDescription(CrewMember crewMember) {
        return crewMember.getName() + " will unlock " + unlockable.getClass().getSimpleName();
    }
}
