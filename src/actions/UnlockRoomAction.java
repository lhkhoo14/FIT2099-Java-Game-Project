package actions;

import areas.Mansion;
import core.Ability;
import core.CrewMember;
import core.Moon;
import items.TreasureBox;

/**
 * Represents the action where the crew member unlocks a room in the Mansion
 */
public class UnlockRoomAction extends Action {
    private Mansion mansion;

    /**
     * Constructs an UnlockRoomAction for a specific Mansion
     * @param mansion - the Mansion to be unlocked
     */
    public UnlockRoomAction(Mansion mansion) {
        this.mansion = mansion;
    }

    /**
     * Executes the unlock action
     * @param crewMember - crewMember object in the simulation
     * @param moon - Moon object in the simulation
     * @return a String showing the results of the action
     */
    @Override
    public String execute(CrewMember crewMember, Moon moon) {
        crewMember.removeCapability(Ability.UNLOCK);

        for (int i = 0 ; i< 3; i++) {
            TreasureBox treasureBox = new TreasureBox("Mansion");
            crewMember.pack(treasureBox);
        }
        return crewMember.getName() + " unlocked the room and found 3 Treasure Boxes!";
    }

    /**
     * Returns the option of the allowable Action in the menu
     * @param crewMember - CrewMember Object in the simulation
     * @return a String describing the action
     */
    @Override
    public String menuDescription(CrewMember crewMember) {
        return crewMember.getName() + " will unlock a room in the Mansion";
    }
}
