package core;

/**
 * Represent an item that can be consumed by the crew member
 * Classes implementing this has to contain the consumedBy method
 */
public interface Consumable {

    /**
     * Returns the effect when a consumable is being consumed by
     * @param crewMember - CrewMember object that is consuming the item
     * @return a String representing the results of consumption
     */
    public String consumedBy(CrewMember crewMember);
}
