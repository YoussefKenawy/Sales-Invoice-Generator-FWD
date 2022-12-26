package sig.controller;
import sig.model.InvoiceHeader_mdl;
import sig.model.InvoiceItems_mdl;
import sig.model.Table_Of_items;
import sig.view.Insert_An_Invoice;
import sig.view.Main_Landing_Screen;
import sig.view.Add_ToTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class ButtonActionHandler implements ActionListener{
    private Main_Landing_Screen main_Screen;
    private Insert_An_Invoice add_Invoice;
    private Add_ToTable add_Item;


    public ButtonActionHandler(Main_Landing_Screen main_Screen) {
        this.main_Screen = main_Screen;
    }



    public void actionPerformed(ActionEvent e) {
        String do_act = e.getActionCommand();
        if(do_act == "Create New Invoice")
        {
            createNewInvoice();
            System.out.println("Action Done " + do_act);
        }
        else if(do_act == "Delete Invoice")
        {
            deleteInvoices();
            System.out.println("Action Done" + do_act);
        }

        else if(do_act == "Add Item")
        {
            createNewItem();
            System.out.println("Action Done" + do_act);
        }
        else if(do_act == "Delete Item")
        {
            deleteItem();
            System.out.println("Action Done" + do_act);
        }
        else if(do_act == "createInvoiceOK")
        {
            createInvoiceOK();
            System.out.println("Action Done" + do_act);
        }
        else if(do_act == "createInvoiceCancel")
        {
            createInvoiceCancel();
            System.out.println("Action Done" + do_act);
        }
        else if(do_act == "createLineOK")
        {
            createOKLine();
            System.out.println("Action Done" + do_act);
        }
        else if(do_act == "createLineCancel")
        {
            createLineCancel();
            System.out.println("Action Done" + do_act);
        }
        else {
            System.out.println("Please use a valid action");

        }

    }

    private void deleteInvoices() {
        int SelectedRow = main_Screen.getHeaderTable().getSelectedRow();
        if(SelectedRow != -1){
            JOptionPane.showMessageDialog(main_Screen, "Successfully Deleted");
            main_Screen.getInvoices().remove(SelectedRow);
            main_Screen.getHeaderTableModel().fireTableDataChanged();
        }else{
            JOptionPane.showMessageDialog(main_Screen, "Please Select One Row", "Alert", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteItem() {
        int selectedInvoice = main_Screen.getHeaderTable().getSelectedRow();
        int selectedRow = main_Screen.getLineTable().getSelectedRow();

        if(selectedInvoice != -1 && selectedRow != -1){
            JOptionPane.showMessageDialog(main_Screen, "Successfully Deleted");
            Table_Of_items lineTableModel = (Table_Of_items) main_Screen.getLineTable().getModel();
            lineTableModel.getItems().remove(selectedRow);
            lineTableModel.fireTableDataChanged();

        }


    }

    private void createInvoiceOK() {
        JOptionPane.showMessageDialog(main_Screen, "You Successfully Created New Invoice ");
        String createdDate = add_Invoice.getInvDateField().getText();
        String createdCustomer = add_Invoice.getCustNameField().getText();
        int createdNumber = main_Screen.getNextInvoiceNum();

        InvoiceHeader_mdl header = new InvoiceHeader_mdl(createdNumber, createdDate, createdCustomer);
        main_Screen.getInvoices().add(header);
        main_Screen.getHeaderTableModel().fireTableDataChanged();
        add_Invoice.setVisible(false);
        add_Invoice.dispose();
        add_Invoice = null;
    }

    private void createInvoiceCancel() {
        JOptionPane.showMessageDialog(main_Screen, "You Cancelled Creating New Invoice ");
        add_Invoice.setVisible(false);
        add_Invoice.dispose();
        add_Invoice = null;

    }

    private void createOKLine() {
        JOptionPane.showMessageDialog(main_Screen, "New Item Successfully Added ");
        String itemName = add_Item.getItemNameField().getText();
        String countStr = add_Item.getItemCountSpinner().getValue().toString();
        String priceStr = add_Item.getItemPriceField().getText();
        int itemCount = Integer.parseInt(countStr);
        double itemPrice = Double.parseDouble(priceStr);
        int selectedInvoice = main_Screen.getHeaderTable().getSelectedRow();
        if(selectedInvoice != -1)
        {
            InvoiceHeader_mdl header = main_Screen.getInvoices().get(selectedInvoice);
            InvoiceItems_mdl item = new InvoiceItems_mdl(itemName, itemPrice, itemCount, header);
            header.getItems().add(item);
            Table_Of_items ItemsTableModel = (Table_Of_items) main_Screen.getLineTable().getModel();
            ItemsTableModel.fireTableDataChanged();
            main_Screen.getHeaderTableModel().fireTableDataChanged();

        }

        add_Item.setVisible(false);
        add_Item.dispose();
        add_Item = null;
    }

    private void createLineCancel() {
        JOptionPane.showMessageDialog(main_Screen, "You Cancel Adding New Item ");
        add_Item.setVisible(false);
        add_Item.dispose();
        add_Item = null;

    }

    private void createNewInvoice() {
        add_Invoice = new Insert_An_Invoice(main_Screen);
        add_Invoice.setVisible(true);
    }

    private void createNewItem() {
        add_Item = new Add_ToTable(main_Screen);
        add_Item.setVisible(true);
    }

}
