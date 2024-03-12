class Item {
//    creating name and price for items
    private final String itemName;
    private final double itemPrice;

//    creates constructor, and default values for name and price
    public Item() {
        this.itemName = "";
        this.itemPrice = 0.0;
    }

//    allows for different values to be used than default
    public Item(String name, double price) {
        this.itemName = name;
        this.itemPrice = price;
    }

//    retrieves name and price
    public String getItemName() {
        return itemName;
    }
    public double getItemPrice() {
        return itemPrice;
    }
}