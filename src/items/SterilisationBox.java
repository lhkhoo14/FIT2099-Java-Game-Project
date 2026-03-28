package items;

import core.Ability;

/**
 * Implement SterilisationBox subclass
 */
public class SterilisationBox extends Item {

    /**
     * Constructs a Sterilisation box with its specific brand and weight
     * @param brand - brand of the Sterilisation box
     * @param weight - weight of the Sterilisation box
     */
    public SterilisationBox(String brand,double weight) {
        super(brand, weight);
        this.addCapability(Ability.STERILISE);
    }
}