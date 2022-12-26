
package sig.model;
import java.util.ArrayList;

public class InvoiceHeader_mdl {
    private int invoiceNumber;
    private String invoiceDate;
    private String customerName;
    private ArrayList<InvoiceItems_mdl> Items;


    public InvoiceHeader_mdl(int invoiceNumber, String invoiceDate, String customerName) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }


    public int getInvoiceNumber() {
        return invoiceNumber;
    }


    public String getInvoiceDate() {
        return invoiceDate;
    }

    public double getInvoiceTotal()
    {
        double total = 0;
        for(InvoiceItems_mdl item: getItems()){
            total += item.getItemTotal();
        }
        return total;
    }
    @Override
    public String toString() {
        return "InvoiceHeader{" + "invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate + ", customerName=" + customerName + '}';
    }

    public ArrayList<InvoiceItems_mdl> getItems() {
        if(Items == null){
            Items = new ArrayList<>();
        }
        return Items;
    }

    public String getInvoiceHeaderFile() // For Saving Invoice
    {
        return invoiceNumber + "," + invoiceDate + "," + customerName;
    }

}
