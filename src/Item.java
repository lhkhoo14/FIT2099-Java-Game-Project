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

    @Override
    public String toString() {
        return super.toString() + " , capacity: " + capacity + " L";
    }
}

class FlashLight extends Item {}

class Lockpick extends Item {}

class SterilisationBox extends Item {}