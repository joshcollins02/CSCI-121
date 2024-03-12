class ItemOrder extends Item {
//    creates item and quantity
    private final Item item;
    private final int itemQuantity;

//    constructor that sets default for quantity and  item relating to item order
    public ItemOrder() {
        this.item = new Item();
        this.itemQuantity = 0;
    }

//    takes item and quantity and lets values be used for them
    public ItemOrder(Item item, int itemQuantity) {
        this.itemQuantity = itemQuantity;
        this.item = item;
    }

//    retrieves item quantity and a new field that mults price and quantity
    public Item getItem() {
        return item;
    }
    public double getQuantity() {
        return itemQuantity;
    }
//    calculates price for individual and bulk orders
//    if item quantity is 2 then there is a 5% discount
//    if item quantity is 3 then there is a 15% discount
//    only handles if the inout is made once, if there are double inputs, it disregards it, so it punishes indecisiveness
    public double calcTotal() {
        double totalPrice = item.getItemPrice() * itemQuantity;

        if (itemQuantity == 2) {
            // 5% discount for quantity over 2
            totalPrice *= 0.95;
        } else if (itemQuantity > 2) {
            // 15% discount for quantity over 3
            totalPrice *= 0.85;
        }

        return totalPrice;
    }
}
