public class Item {
    String brand;  //
    double weight; //item weight in grams

    public Item() {
        this.brand = "Unknown";
        this.weight = 0;
    }

    public Item(String brand, double weight) {
        this.brand = brand;
        this.weight = weight;
    }

    public String getSimpleName() {return this.getClass().getSimpleName(); }

    public double getWeight(){
        return weight;
    }

    public Action getPackAction() {return new PackAction(this);}

    public Action getUnpackAction() {return new UnpackAction(this);}

    @Override
    public String toString() {
        //Print out the item  brand and weight
        return String.format("%s (%s) has weight of %.2f kg",
                this.getSimpleName(),
                this.brand,
                this.weight);
    }
}

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

class FlashLight extends Item {
    public FlashLight(String brand,double weight) {
        super(brand, weight);
    }
}

class Lockpick extends Item {
    public Lockpick(String brand,double weight) {
        super(brand, weight);
    }
}

class SterilisationBox extends Item {
    public SterilisationBox(String brand,double weight) {
        super(brand, weight);
    }
}