
package sig.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class Table_Of_items extends AbstractTableModel{
    private ArrayList<InvoiceItems_mdl> items;
    private String[] itemColumns = {"Number", "Item Name", "Item Price", "Count", "Total"};

    public Table_Of_items(ArrayList<InvoiceItems_mdl> items) {
        this.items = items;
    }

    public ArrayList<InvoiceItems_mdl> getItems() {
        return items;
    }


    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return itemColumns.length;
    }

    @Override
    public String getColumnName(int column) {
        return itemColumns[column];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceItems_mdl item = items.get(rowIndex);

        switch(columnIndex){
            case 0:
                return item.get_Invoice().getInvoiceNumber();
            case 1:
                return item.getItemName();
            case 2:
                return item.getItemPrice();
            case 3:
                return item.getItemCount();
            case 4:
                return item.getItemTotal();
            default :
                return "";

        }
    }

}
