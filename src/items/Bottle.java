package items;
/**
 * Implements the bottle subclass
 * create Bottle object with super class attributes with addition of capacity
 * Override toString method to output capacity as well
 */
public class Bottle extends Item {
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