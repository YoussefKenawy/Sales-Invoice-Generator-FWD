package sig.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class HeaderTable_mdl extends AbstractTableModel{
    private ArrayList<InvoiceHeader_mdl> headers;
    private String[] headerColumns = {"Number", "Date", "Customer", "Total Amount"};

    public HeaderTable_mdl(ArrayList<InvoiceHeader_mdl> headers) {
        this.headers = headers;
    }



    @Override
    public int getRowCount() {
        return headers.size();
    }

    @Override
    public int getColumnCount() {
        return headerColumns.length;
    }

    @Override
    public String getColumnName(int column) {
        return headerColumns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader_mdl invoice = headers.get(rowIndex);

        switch(columnIndex)
        {
            case 0:
                return invoice.getInvoiceNumber();
            case 1:
                return invoice.getInvoiceDate();
            case 2:
                return invoice.getCustomerName();
            case 3:
                return invoice.getInvoiceTotal();
            default :
                return "";


        }
    }

}
