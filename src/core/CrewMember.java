package core;
import java.util.List;
import java.util.ArrayList;
import actions.*;
import items.*;

/**
 * Implement CrewMember class
 * Represents a crew member in the simulation with a name, backpack, and initial energy
 */
public class CrewMember implements ActionCapable {
    private String name;
    private Backpack backpack;
    private int energy;

    /**
     * Creates a CrewMember object with the name "Steve", a Backpack and its initial energy at 30
     */
    public CrewMember() {
        this.name = "Steve";
        this.backpack = new Backpack();
        this.energy = 30;
    }

    /**
     * prints all items inside the backpack to the console
     */
    public void checkAllItems() {
        //gets array of items from backpack
        List<Item> items = backpack.getItems();
        System.out.println("Crew Member " + name + "'s Backpack contains :");

        for (int i = 0;i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }

    /**
     * Returns a list of allowable actions from Backpack by calling backpack.allowableActions()
     * @return actions - ArrayList containing the actions called from backpack
     */
    @Override
    public List<Action> allowableActions(CrewMember crewMember){
        List<Action> actions = new ArrayList<>();
        actions = backpack.allowableActions(crewMember); //call the backpack's allowable actions
        return actions;
    }

    /**
     * Return the CrewMember's Backpack
     * @return backpack - CrewMember Backpack attribute
     */
    public Backpack getBackpack() {
        return backpack;
    }

    /**
     * Return the name of the CrewMember
     * @return name - CrewMember String attribute
     */
    public String getName(){
        return name;
    }

    /**
     * Return the current energy of the CrewMember
     * @return energy - CrewMember energy attribute
     */
    public int getEnergy(){
        return energy;
    }
}