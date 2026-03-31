package actions;

import areas.Mansion;
import core.Ability;
import core.CrewMember;
import core.Moon;
import items.TreasureBox;

public class UnlockRoomAction extends Action {
    private Mansion mansion;

    public UnlockRoomAction(Mansion mansion) {
        this.mansion = mansion;
    }

    @Override
    public String execute(CrewMember crewMember, Moon moon) {
        crewMember.removeCapability(Ability.UNLOCK);

        for (int i = 0 ; i< 3; i++) {
            TreasureBox treasureBox = new TreasureBox("Mainsion");
            crewMember.pack(treasureBox);
        }
        return crewMember.getName() + " unlocked the room and found 3 Treasure Boxes!";
    }

    @Override
    public String menuDescription(CrewMember crewMember) {
        return crewMember.getName() + " will unlock a room in the Mansion";
    }
}
