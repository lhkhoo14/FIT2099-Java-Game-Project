/**
 * Implements Item class
 * creates Item object with brand and weight attributes
 * Parent class for FlashLight, Lockpick, Bottle, SterilisationBox
 */
public class Item {
    String brand;  //
    double weight; //item weight in grams

    /**
     * default constructor for item object
     */
    public Item() {
        this.brand = "Unknown";
        this.weight = 0;
    }

    /**
     * constructor of item object with initial values
     * @param brand brand of item
     * @param weight weight of item
     */
    public Item(String brand, double weight) {
        this.brand = brand;
        this.weight = weight;
    }

    /**
     * @return name of class
     */
    public String getSimpleName() {return this.getClass().getSimpleName(); }

    /**
     * Getter to get weight
     * @return weight
     */
    public double getWeight(){
        return weight;
    }

    /**
     * return the action to pack this item
     * @return PackAction object for this item
     */
    public Action getPackAction() {return new PackAction(this);}

    /**
     * return the action to unpack this item
     * @return PackAction object for this item
     */
    public Action getUnpackAction() {return new UnpackAction(this);}

    /**
     * @return String of item information
     */
    @Override
    public String toString() {
        //Print out the item  brand and weight
        return String.format("%s (%s) has weight of %.2f kg",
                this.getSimpleName(),
                this.brand,
                this.weight);
    }
}

/**
 * Implements the bottle subclass
 * create Bottle object with super class attributes with addition of capacity
 * Override toString method to output capacity as well
 */
class Bottle extends Item {
    double capacity; //Litres stored

    public Bottle(String brand,double weight, double capacity) {
        super(brand, weight);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() + " , capacity: " + capacity + " L";
    }
}

/**
 * Implement FlashLight subclass
 */
class FlashLight extends Item {
    public FlashLight(String brand,double weight) {
        super(brand, weight);
    }
}

/**
 * Implement Lockpick subclass
 */
class Lockpick extends Item {
    public Lockpick(String brand,double weight) {
        super(brand, weight);
    }
}

/**
 * Implement SterilisationBox subclass
 */
class SterilisationBox extends Item {
    public SterilisationBox(String brand,double weight) {
        super(brand, weight);
    }
}