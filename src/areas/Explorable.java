package areas;

import actions.ActionCapable;
import core.CrewMember;

public interface Explorable extends ActionCapable {

    public String exploredBy(CrewMember crewMember);
}
