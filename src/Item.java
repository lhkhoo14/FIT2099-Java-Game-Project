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

    @Override
    public String toString() {
        //Print out the item  brand and weight
        return this.getSimpleName() + ", Brand : " + this.brand + ", weight : " + this.weight + "g";
    }
}

class Bottle extends Item {
    double capacity; //Litres stored

    public Bottle(String brand,int weight, double capacity) {
        super(brand, weight);
        this.capacity = capacity;
    }


    @Override
    public String toString() {
        return super.toString() + " , capacity: " + capacity + " L";
    }
}

class FlashLight extends Item {
    public FlashLight(String brand,int weight) {
        super(brand, weight);
    }
}

class Lockpick extends Item {
    public Lockpick(String brand,int weight) {
        super(brand, weight);
    }
}

class SterilisationBox extends Item {
    public SterilisationBox(String brand,int weight) {
        super(brand, weight);
    }
}