import javax.swing.*;
import java.awt.*;

public class ShoppingCartGUI extends JFrame {
//    creates a cart, and Jfields
    private final ShoppingCart cart;
    private final JTextField itemNameJ;
    private final JTextField quantityJ;
    private final JTextArea cartDisplayJ;
    private final JLabel totalPriceJ;

//    in this function I create the JFrame and all of its aspects
    public ShoppingCartGUI() {
        super("Shopping Cart GUI");
        cart = new ShoppingCart();

        itemNameJ = new JTextField(20);
        quantityJ = new JTextField(5);
        cartDisplayJ = new JTextArea(10, 30);
        totalPriceJ = new JLabel("Total Price: $0.0");
        JButton addItemButton = new JButton("Add Item to Cart");
        JButton removeItemButton = new JButton("Remove Item from Cart");
        JButton calculateTotalButton = new JButton("Calculate Total");
//        went for a customized layout, using setbounds
        setLayout(null);
        JLabel titleLabel = new JLabel("Your Shopping Cart");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(200, 10, 200, 30);
        add(titleLabel);

        JLabel itemNameLabel = new JLabel("Item Name:");
        itemNameLabel.setBounds(50, 50, 80, 20);
        add(itemNameLabel);
        itemNameJ.setBounds(150, 50, 150, 20);
        add(itemNameJ);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(50, 80, 80, 20);
        add(quantityLabel);
        quantityJ.setBounds(150, 80, 50, 20);
        add(quantityJ);

        addItemButton.setBounds(50, 120, 150, 30);
        add(addItemButton);
        removeItemButton.setBounds(50, 160, 150, 30);
        add(removeItemButton);
        calculateTotalButton.setBounds(50, 200, 150, 30);
        add(calculateTotalButton);
//        implemented a scroll pane in case any items had long names
        JScrollPane scrollPane = new JScrollPane(cartDisplayJ);
        scrollPane.setBounds(350, 50, 200, 300);
        add(scrollPane);
//        implemented a total price label above and specify its bounds here
        totalPriceJ.setBounds(50, 250, 150, 30);
        add(totalPriceJ);

//        action listeners for the jbuttons
        addItemButton.addActionListener(e -> addToCart());
        removeItemButton.addActionListener(e -> removeFromCart());
        calculateTotalButton.addActionListener(e -> displayTotalPrice());
//        set size and position of jframe, as well as close window action
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

//     add item to cart jbutton field with an exception that catches non integer entries
    private void addToCart() {
        String itemName = itemNameJ.getText();
        int quantity = Integer.parseInt(quantityJ.getText());

        try {
            double itemPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter the price for item " + itemName));

            Item newItem = new Item(itemName, itemPrice);
            ItemOrder newItemOrder = new ItemOrder(newItem, quantity);
            cart.addItemOrder(newItemOrder);

            displayCart();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price entered", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//    remove item from cart jbutton field that handles display of items when it is removed from scrollpane
    private void removeFromCart() {
        String itemName = itemNameJ.getText();
        ItemOrder itemOrder = cart.searchItemOrder(itemName);

        if (itemOrder != null) {
            cart.removeItemOrder(itemOrder);
            displayCart();
        } else {
            JOptionPane.showMessageDialog(this, "Item not found in the cart", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//    total price is displayed on joption pane calling to item order boundaries
//    as well is displayed as a label in the frame
    private void displayTotalPrice() {
        double totalPrice = cart.calcTotalPrice();
        JOptionPane.showMessageDialog(this, "Total Price: $" + totalPrice, "Total Price", JOptionPane.INFORMATION_MESSAGE);
        totalPriceJ.setText("Total Price: $" + totalPrice);
    }

//    format of cart scrollpane
    private void displayCart() {
        StringBuilder cartContent = new StringBuilder("Shopping Cart:\n");

        for (ItemOrder order : cart.getOrders()) {
            cartContent.append(order.getItem().getItemName()).append(" - Quantity: ").append(order.getQuantity()).append("\n");
        }
        cartDisplayJ.setText(cartContent.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShoppingCartGUI::new);
    }
}