package actions;

import core.Consumable;
import core.CrewMember;
import core.Moon;

public class ConsumeAction extends Action {
    private Consumable consumable;

    public ConsumeAction(Consumable consumable) {
        this.consumable = consumable; }

    @Override
    public String execute(CrewMember crewMember, Moon moon) {
        return consumable.consumedBy(crewMember);
    }

    @Override
    public String menuDescription(CrewMember crewMember) {
        return crewMember.getName() + " will consume " + consumable.getClass().getSimpleName();
    }
}
