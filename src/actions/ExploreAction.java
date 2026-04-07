package actions;

import areas.Explorable;
import core.CrewMember;
import core.Moon;

/**
 * Implements an ExploreAction class that allows crew member to explore areas
 */
public class ExploreAction extends Action {
    private Explorable explorable;

    /**
     * Constructs an ExplorerAction object with a specific explorable area
     * @param explorable - the explorable area
     */
    public ExploreAction(Explorable explorable) {
        this.explorable = explorable;
    }

    /**
     * Execute the ExploreAction object by calling the exploredBy() method
     * @param crewMember - crewMember object in the simulation
     * @param moon - Moon object in the simulation
     * @return a description of the result after exploring the area
     */
    @Override
    public String execute(CrewMember crewMember, Moon moon) {
        return explorable.exploredBy(crewMember);
    }

    /**
     * Represents an option to explore the specific area
     * @param crewMember - CrewMember Object in the simulation
     * @return a String showing the option of  allowableActions
     */
    @Override
    public String menuDescription(CrewMember crewMember) {
        return crewMember.getName() + " will explore the " + explorable.getClass().getSimpleName() ;
    }

}
