import java.util.ArrayList;

class ShoppingCart extends ItemOrder {
//    creates an array list from itemorder class
    private final ArrayList<ItemOrder> orders;

//    makes shoppingcart a super constructor and initializes arraylist
    public ShoppingCart() {
        super();
        this.orders = new ArrayList<>();
    }
//    adds additem order
    public void addItemOrder(ItemOrder itemOrder) {
        orders.add(itemOrder);
    }
//    adds removeitem order
    public void removeItemOrder(ItemOrder itemOrder) {
        orders.remove(itemOrder);
    }
//    instead of creating a set list of items I wanted to make it, so you can "search" for an item, so there is more
//    freedom with the items chosen
    public ItemOrder searchItemOrder(String itemName) {
        for (ItemOrder order : orders) {
            if (order.getItem().getItemName().equals(itemName)) {
                return order;
            }
        }
        return null;
    }
//    gives default value that after the order is made, it sets a value from calcTotal
    public double calcTotalPrice() {
        double totalPrice = 0.0;
        for (ItemOrder order : orders) {
            totalPrice += order.calcTotal();
        }
        return totalPrice;
    }
    public ArrayList<ItemOrder> getOrders() {
        return orders;
    }
//    originally I had run main through here but created a GUI class to display GUI
}