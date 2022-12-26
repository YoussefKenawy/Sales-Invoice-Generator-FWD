package sig.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;


public class Add_ToTable extends JDialog{
    private JTextField itemNameInput,itemPriceInput;
    private JSpinner itemCountSpinner;
    private JLabel itemNameLabel,itemCountLabel,itemPriceLabel;
     private JButton okBtn,cancelBtn;
        public Add_ToTable(Main_Landing_Screen frame) {
        itemNameInput = new JTextField(20);
            itemNameLabel = new JLabel("Item Name");

        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 1000 , 1);
        itemCountSpinner = new JSpinner(spinnerModel);
        itemCountLabel = new JLabel("Item Count");

            itemPriceInput = new JTextField(20);
        itemPriceLabel = new JLabel("Item Price");

        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");

        okBtn.setActionCommand("createLineOK");
        cancelBtn.setActionCommand("createLineCancel");

        okBtn.addActionListener(frame.getBcontroller());
        cancelBtn.addActionListener(frame.getBcontroller());
        setLayout(new GridLayout(4, 2));

        add(itemNameLabel);
        add(itemNameInput);
        add(itemCountLabel);
        add(itemCountSpinner);
        add(itemPriceLabel);
        add(itemPriceInput);
        add(okBtn);
        add(cancelBtn);

        pack();
    }

    public JTextField getItemNameField() {
        return itemNameInput;
    }

    public JSpinner getItemCountSpinner() {
        return itemCountSpinner;
    }

    public JTextField getItemPriceField() {
        return itemPriceInput;
    }
}
