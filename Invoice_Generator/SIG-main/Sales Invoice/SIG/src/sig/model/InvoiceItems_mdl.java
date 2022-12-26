package sig.model;
public class InvoiceItems_mdl {
    private String item_Name;
    private double item_Price;
    private int item_Count;
    private InvoiceHeader_mdl inv_head;

    public InvoiceItems_mdl(String itemName, double itemPrice, int itemCount, InvoiceHeader_mdl inv) {
        this.item_Name = itemName;
        this.item_Price = itemPrice;
        this.item_Count = itemCount;
        this.inv_head = inv;
    }


    public int getItemCount() {
        return item_Count;
    }


    public String getItemName() {
        return item_Name;
    }


    public double getItemPrice() {
        return item_Price;
    }

    public double getItemTotal()
    {
        return item_Price * item_Count;
    }
    @Override
    public String toString() {
        return "InvoiceItem{" + ", itemName=" + item_Name + ", itemPrice=" + item_Price + ", itemCount=" + item_Count + ", inv=" + inv_head + '}';
    }

    public InvoiceHeader_mdl get_Invoice() {
        return inv_head;
    }
    public String getItemFile() // For Saving InvoiceLine File
    {
        return inv_head.getInvoiceNumber()+ "," + item_Name + "," + item_Price + "," + item_Count;
    }
}
