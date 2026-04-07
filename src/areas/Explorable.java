package areas;

import actions.ActionCapable;
import core.CrewMember;

/**
 * Represents the area that are explorable
 * Classes implementing this interface must have exploredBy() method
 */
public interface Explorable extends ActionCapable {

    /**
     * Returns a description of exploring the area
     * @param crewMember - crew member in the simulation
     * @return a String representing the results of the action
     */
    public String exploredBy(CrewMember crewMember);
}
