package items;

import core.Ability;

/**
 * Implement Lockpick subclass
 */
public class Lockpick extends Item {

    /**
     * Constructs a lockpick with its brand and weight
     *
     * @param brand  - brand of the lockpick
     * @param weight - weight of the lockpick
     */
    public Lockpick(String brand, double weight) {

        super(brand, weight);
        this.addCapability(Ability.UNLOCK);
    }

    /**
     * Override original method to show if the lockpick is broken or usable
     * @return a String description the lockpick
     */
    @Override
    public String toString() {
        //Print out the item  brand and weight
        if (this.hasCapability(Ability.UNLOCK)) {

            return String.format("%s (%s) has weight of %.2f kg, usable",
                    this.getSimpleName(),
                    this.brand,
                    this.weight);
        } else {
            return String.format("%s (%s) has weight of %.2f kg, broken",
                    this.getSimpleName(),
                    this.brand,
                    this.weight);
        }
    }
}
