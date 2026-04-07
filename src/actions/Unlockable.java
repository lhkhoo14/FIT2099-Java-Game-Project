package actions;

import core.CrewMember;

/**
 * Represents items that are unlockable
 * Classes implementing this method must have unlockedBy() method
 */
public interface Unlockable {

    /**
     * Returns a description of unlocking the item
     * @param crewMember - crew member in the simulation
     * @return a String representing the results of the action
     */
    public String unlockedBy(CrewMember crewMember);
}
