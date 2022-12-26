
package sig.view;

import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Insert_An_Invoice extends JDialog {
    private JTextField CustomerName_Input;
    private JTextField invDateField;
    private JLabel CustomerName_Label;
    private JLabel invDateLabel;
    private JButton btn_Ok;
    private JButton cancel_Btn;

    public Insert_An_Invoice(Main_Landing_Screen frame) {
        CustomerName_Label = new JLabel("Customer Name:");
        CustomerName_Input = new JTextField(20);

        invDateLabel = new JLabel("Invoice Date:");
        invDateField = new JTextField(20);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime currentDate = LocalDateTime.now();  //Will be  the current day
        try
        {
            invDateField = new JTextField(dateTimeFormatter.format(currentDate));
        }
        catch(Exception e){e.printStackTrace();}

        btn_Ok = new JButton("OK");
        cancel_Btn = new JButton("Cancel");

        btn_Ok.setActionCommand("createInvoiceOK");
        cancel_Btn.setActionCommand("createInvoiceCancel");

        btn_Ok.addActionListener(frame.getBcontroller());
        cancel_Btn.addActionListener(frame.getBcontroller());
        setLayout(new GridLayout(3, 2));

        add(invDateLabel);
        add(invDateField);
        add(CustomerName_Label);
        add(CustomerName_Input);
        add(btn_Ok);
        add(cancel_Btn);

        pack();

    }

    public JTextField getCustNameField() {
        return CustomerName_Input;
    }

    public JTextField getInvDateField() {
        return invDateField;
    }

}