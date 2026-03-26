package core;
import actions.Action;

import java.util.List;

/**
 *
 */
public interface ActionCapable {
    List<Action> allowableActions(CrewMember crewMember);
}
