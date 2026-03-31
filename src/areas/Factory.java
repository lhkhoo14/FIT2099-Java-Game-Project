package areas;

import actions.Action;
import actions.ConsumeAction;
import core.CrewMember;

import java.util.ArrayList;
import java.util.List;

public class Factory implements Explorable{

    @Override
    public String exploredBy(CrewMember crewMember) {
        return "";
    }

    @Override
    public List<Action> allowableActions(CrewMember crewMember) {
        List<Action> actions = new ArrayList<>();

        actions.add(new ExploreAction(this)); //doesn't need sterilise to drink
        return actions;
    }
}
