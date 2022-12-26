
package sig.controller;
import sig.model.InvoiceHeader_mdl;
import sig.model.Table_Of_items;
import sig.view.Main_Landing_Screen;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableSelectionActionHandler implements ListSelectionListener{
    private Main_Landing_Screen main_screen;



    public TableSelectionActionHandler (Main_Landing_Screen main_screen) {
        this.main_screen = main_screen;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedIndex = main_screen.getHeaderTable().getSelectedRow();
        if(selectedIndex != -1){
            System.out.println("you have selected row :"+ selectedIndex);
            InvoiceHeader_mdl currentInvoice = main_screen.getInvoices().get(selectedIndex);
            main_screen.getNumberLabel().setText(""+currentInvoice.getInvoiceNumber());
            main_screen.getDatelabel().setText(currentInvoice.getInvoiceDate());
            main_screen.getNamelabel().setText(currentInvoice.getCustomerName());
            main_screen.getTotalLabel().setText(""+currentInvoice.getInvoiceTotal());
            Table_Of_items itemTableModel = new Table_Of_items(currentInvoice.getItems());
            main_screen.getLineTable().setModel(itemTableModel);
            itemTableModel.fireTableDataChanged();

        }

    }

}
