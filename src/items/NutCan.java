package items;

import actions.ActionCapable;
import actions.*;
import core.*;

import java.util.ArrayList;
import java.util.List;

public class NutCan extends Item implements Consumable{
    private final int INCREASED_ENERGY_VALUE = 2;

    public NutCan(String brand) {
        this.brand = brand;
        this.weight = 0.5; //kg
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
