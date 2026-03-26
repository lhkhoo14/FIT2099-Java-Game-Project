package items;

import actions.Action;
import actions.ConsumeAction;
import core.Ability;
import core.Consumable;
import core.CrewMember;

import java.util.ArrayList;
import java.util.List;

public class TortillaPack extends Item implements Consumable{
    private final int INCREASED_ENERGY_VALUE = 4;

    public TortillaPack(String brand) {
        this.brand = brand;
        this.weight = 1; //kg
    }

    @Override
    public List<Action> allowableActions(CrewMember crewMember) {
        List<Action> actions = new ArrayList<>();

        if (crewMember.hasCapability(Ability.STERILISE)) {
            actions.add(new ConsumeAction(this));
        }
        return actions;
    }


    @Override
    public String consumedBy(CrewMember crewMember) {
        crewMember.increaseEnergyLevelBy(INCREASED_ENERGY_VALUE);
        crewMember.unpack(this);
        return this.getSimpleName() + "is consumed by " + crewMember
                + " and it increases the energy level by " + INCREASED_ENERGY_VALUE;
    }
}