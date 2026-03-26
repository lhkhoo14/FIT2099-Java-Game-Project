package actions;
import core.*;

import java.util.List;

/**
 * Interface for any class that uses the method allowableActions
 */
public interface ActionCapable {
    List<Action> allowableActions(CrewMember crewMember);
}
