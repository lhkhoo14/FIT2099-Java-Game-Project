package areas;

import actions.Action;
import core.CrewMember;
import core.Moon;

public class ExploreAction extends Action {
    private Explorable explorable;

    public ExploreAction(Explorable explorable) {
        this.explorable = explorable;
    }

    @Override
    public String execute(CrewMember crewMember, Moon moon) {
        return "";
    }

    @Override
    public String menuDescription(CrewMember crewMember) {
        return "";
    }

}
