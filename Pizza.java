import javax.swing.*;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;

// Here is calling the Pizza class and all the components on the window that are later specified in the code
public class Pizza extends JFrame {
    String pizzaSize;
    String selectedToppings;
    JRadioButton smallRadio;
    JRadioButton mediumRadio;
    JRadioButton largeRadio;
    JRadioButton superRadio;
    JCheckBox pepCheckbox;
    JCheckBox mushCheckbox;
    JCheckBox meatCheckbox;
    JCheckBox sausCheckbox;
    JCheckBox cheeCheckbox;
    float totalPrice;
    JLabel sizePLabelSmall;
    JLabel sizePLabelMed;
    JLabel sizePLabelLarge;
    JLabel sizePLabelSuper;
    JLabel toppingPLabelPep;
    JLabel toppingPLabelMush;
    JLabel toppingPLabelMeat;
    JLabel toppingPLabelSaus;
    JLabel toppingPLabelChee;
    JLabel totalPLabel;

// This handles the called JLabels, Buttons, and Checkboxes and orients them on the window
    public Pizza() {
        setTitle("Pizza Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton orderButton = new JButton("Place Order");
        orderButton.setBounds(160, 300, 120, 30);
        JButton cancelButton = new JButton("Cancel Order");
        cancelButton.setBounds(300, 300, 120, 30);
        JLabel titleLabel = new JLabel("BigY Pizza Order System");
        titleLabel.setBounds(220, 10, 200, 20);
        JLabel sizeLabel = new JLabel("Select Pizza Size:");
        sizeLabel.setBounds(110, 40, 150, 20);
        JLabel toppingLabel = new JLabel("Select Toppings:");
        toppingLabel.setBounds(350, 40, 150, 20);

        totalPLabel = new JLabel("Total: $0.00");
        totalPLabel.setBounds(160, 250, 300, 20);

        smallRadio = new JRadioButton("Small");
        mediumRadio = new JRadioButton("Medium");
        largeRadio = new JRadioButton("Large");
        superRadio = new JRadioButton("Super");
        smallRadio.setBounds(110, 70, 100, 20);
        mediumRadio.setBounds(110, 90, 100, 20);
        largeRadio.setBounds(110, 110, 100, 20);
        superRadio.setBounds(110, 130, 100, 20);

// This groups the radio buttons so the user won't be able to select mutiple sizes, as this order form only handles one order at a time
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(smallRadio);
        sizeGroup.add(mediumRadio);
        sizeGroup.add(largeRadio);
        sizeGroup.add(superRadio);

        sizePLabelSmall = new JLabel("$5.00");
        sizePLabelMed = new JLabel("$10.00");
        sizePLabelLarge = new JLabel("$15.00");
        sizePLabelSuper = new JLabel("$20.00");
        sizePLabelSmall.setBounds(220, 70, 150, 20);
        sizePLabelMed.setBounds(220, 90, 150, 20);
        sizePLabelLarge.setBounds(220, 110, 150, 20);
        sizePLabelSuper.setBounds(220, 130, 150, 20);

        pepCheckbox = new JCheckBox("Pepperoni");
        mushCheckbox = new JCheckBox("Mushroom");
        meatCheckbox = new JCheckBox("Meatballs");
        sausCheckbox = new JCheckBox("Sausage");
        cheeCheckbox = new JCheckBox("Extra Cheese");
        pepCheckbox.setBounds(350, 70, 100, 20);
        mushCheckbox.setBounds(350, 90, 100, 20);
        meatCheckbox.setBounds(350, 110, 100, 20);
        sausCheckbox.setBounds(350, 130, 100, 20);
        cheeCheckbox.setBounds(350, 150, 100, 20);

        toppingPLabelPep = new JLabel("+ $0.50");
        toppingPLabelMush = new JLabel("+ $0.50");
        toppingPLabelMeat = new JLabel("+ $0.50");
        toppingPLabelSaus = new JLabel("+ $0.50");
        toppingPLabelChee = new JLabel("+ $0.00");
        toppingPLabelPep.setBounds(480, 70, 100, 20);
        toppingPLabelMush.setBounds(480, 90, 100, 20);
        toppingPLabelMeat.setBounds(480, 110, 100, 20);
        toppingPLabelSaus.setBounds(480, 130, 100, 20);
        toppingPLabelChee.setBounds(480, 150, 100, 20);

        setLayout(null);
// Here is just adding all the features above into the window
        add(titleLabel);
        add(sizeLabel);
        add(toppingLabel);
        add(totalPLabel);
        add(smallRadio);
        add(mediumRadio);
        add(largeRadio);
        add(superRadio);
        add(sizePLabelSmall);
        add(sizePLabelMed);
        add(sizePLabelLarge);
        add(sizePLabelSuper);
        add(pepCheckbox);
        add(mushCheckbox);
        add(meatCheckbox);
        add(sausCheckbox);
        add(cheeCheckbox);
        add(toppingPLabelPep);
        add(toppingPLabelMush);
        add(toppingPLabelMeat);
        add(toppingPLabelSaus);
        add(toppingPLabelChee);
        add(orderButton);
        add(cancelButton);
// This is where the action of clicking the button, will link to the functions place and cancel order
        orderButton.addActionListener(e -> placeOrder());
        cancelButton.addActionListener(e -> cancelOrder());
// This takes into account the buttons pressed and links them to the updateTotal function
        ItemListener itemListener = e -> updateTotal();
        smallRadio.addItemListener(itemListener);
        mediumRadio.addItemListener(itemListener);
        largeRadio.addItemListener(itemListener);
        superRadio.addItemListener(itemListener);
        pepCheckbox.addItemListener(itemListener);
        mushCheckbox.addItemListener(itemListener);
        meatCheckbox.addItemListener(itemListener);
        sausCheckbox.addItemListener(itemListener);
        cheeCheckbox.addItemListener(itemListener);
// this centers the window and specifies the size
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

// This is what handles the calculation when someone clicks either the radio buttons or checkboxes for their pizza size and toppings
// when the place order button is pressed, the calculations from this code will handle the JOptionPane message that is displayed with the total price
    public void placeOrder() {
        int toppings = 0;
        StringBuilder selectedToppingsBuilder = new StringBuilder();
// If either the pizza size or the toppings or both are not selected this will display a JOptionPane message telling the user to select the buttons to complete the order process
        if (!smallRadio.isSelected() && !mediumRadio.isSelected() && !largeRadio.isSelected() && !superRadio.isSelected() ||
                !pepCheckbox.isSelected() && !mushCheckbox.isSelected() && !meatCheckbox.isSelected() && !sausCheckbox.isSelected() && !cheeCheckbox.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a pizza size and toppings", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
// This handles the price calculation for clicking each radio for pizza size and checkbox for pizza toppings
        if (smallRadio.isSelected()) {
            pizzaSize = "Small";
            totalPrice += 5.00;
        } else if (mediumRadio.isSelected()) {
            pizzaSize = "Medium";
            totalPrice += 10.00;
        } else if (largeRadio.isSelected()) {
            pizzaSize = "Large";
            totalPrice += 15.00;
        } else if (superRadio.isSelected()) {
            pizzaSize = "Super";
            totalPrice += 20.00;
        }
        if (pepCheckbox.isSelected()) {
            selectedToppingsBuilder.append("Pepperoni, ");
            toppings++;
            totalPrice += 0.50;
        }
        if (mushCheckbox.isSelected()) {
            selectedToppingsBuilder.append("Mushroom, ");
            toppings++;
            totalPrice += 0.50;
        }
        if (meatCheckbox.isSelected()) {
            selectedToppingsBuilder.append("Meatballs, ");
            toppings++;
            totalPrice += 0.50;
        }
        if (sausCheckbox.isSelected()) {
            selectedToppingsBuilder.append("Sausage, ");
            toppings++;
            totalPrice += 0.50;
        }
        if (cheeCheckbox.isSelected()) {
            selectedToppingsBuilder.append("Extra Cheese, ");
            toppings++;
            totalPrice += 0.00;
        }
// This handles if more than 2 toppings are selected, then the price will be 1.25 instead of 1.50 as a deal for the user
        if (pepCheckbox.isSelected() && mushCheckbox.isSelected() && meatCheckbox.isSelected() && sausCheckbox.isSelected() && !cheeCheckbox.isSelected()) {
            totalPrice -= 0.25;
        }
// If more than 3 toppings are selected regardless if its extracheese that is selected extra, the JOptionPane message will display telling the user to only select 3 toppings
        if (toppings > 3) {
            JOptionPane.showMessageDialog(this, "You can only select 3 toppings", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
// This removes the last two characters of the toppings string when the JOptionPane shows up cuz im lazy and don't want to do it manually
        if (selectedToppingsBuilder.length() > 0) {
            selectedToppingsBuilder.delete(selectedToppingsBuilder.length() - 2, selectedToppingsBuilder.length());
        }
// This handles the tax component and displays the total price with tax in the JOptionPane message when the place order button is clicked after following the correct procedure of the checkout
        double totalWithTax = totalPrice * 1.15;
        selectedToppings = selectedToppingsBuilder.toString();
        String orderSummary = "Order placed! Size: " + pizzaSize + ", Toppings: " + selectedToppings + ", Cost: $" + String.format("%.2f", totalWithTax);
        JOptionPane.showMessageDialog(this, orderSummary, "Order Placed", JOptionPane.INFORMATION_MESSAGE);
    }

// This is the JOptionPane that will display when someone hits the cancel order button on the order screen
    public void cancelOrder() {
        JOptionPane.showMessageDialog(this, "Order canceled!", "Order Canceled", JOptionPane.INFORMATION_MESSAGE);
    }

// Here the code handles the total price w/ tax JLabel that is displayed on the order screen
    public void updateTotal() {
        double totalPrice = 0.0;
// This is just reiterating the prices similar to above on how all the prices of objects are calculated
        if (smallRadio.isSelected()) {
            totalPrice += 5.00;
        } else if (mediumRadio.isSelected()) {
            totalPrice += 10.00;
        } else if (largeRadio.isSelected()) {
            totalPrice += 15.00;
        } else if (superRadio.isSelected()) {
            totalPrice += 20.00;
        }
        if (pepCheckbox.isSelected()) {
            totalPrice += 0.50;
        }
        if (mushCheckbox.isSelected()) {
            totalPrice += 0.50;
        }
        if (meatCheckbox.isSelected()) {
            totalPrice += 0.50;
        }
        if (sausCheckbox.isSelected()) {
            totalPrice += 0.50;
        }
        if (cheeCheckbox.isSelected()) {
            totalPrice += 0.00;
        }
        if (pepCheckbox.isSelected() && mushCheckbox.isSelected() && meatCheckbox.isSelected() && sausCheckbox.isSelected() && !cheeCheckbox.isSelected()) {
            totalPrice -= 0.25;
        }
        double totalWithTax = totalPrice * 1.15;
// Here's the JLabel that is created from the calculation and is called to
        totalPLabel.setText(String.format("Total: $%.2f (Including 15%% Tax)", totalWithTax));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Pizza());
    }
}