package items;

import core.Ability;

/**
 * Implement SterilisationBox subclass
 */
public class SterilisationBox extends Item {
    public SterilisationBox(String brand,double weight) {
        super(brand, weight);
        this.addCapability(Ability.STERILISE);
    }
}