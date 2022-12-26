package sig.controller;
import sig.model.HeaderTable_mdl;
import sig.model.InvoiceHeader_mdl;
import sig.model.InvoiceItems_mdl;
import sig.view.Main_Landing_Screen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class SaveAndLoadActionHandler implements ActionListener{ //Sava & Load Actions
    private Main_Landing_Screen main_Screen;
    public SaveAndLoadActionHandler (Main_Landing_Screen main_Screen) {
        this.main_Screen = main_Screen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        System.out.println("Action Done" );

        if(actionCommand == "Load File")
        {
            loadFile();
            System.out.println("You will " + actionCommand);
        }
        else if(actionCommand == "Save File")
        {
            saveFile();
            System.out.println("You will " + actionCommand);
        }
        else {
            System.out.println("Please Use A Valid Action");
        }


    }



    private void loadFile() {
        JOptionPane.showMessageDialog(main_Screen, "Please Select Invoice Table File", "Attention", JOptionPane.INFORMATION_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        try {
            //Code To Load First File (HeaderFile)
            int openDialog = fileChooser.showOpenDialog(main_Screen);
            if(openDialog == JFileChooser.APPROVE_OPTION)
            {
                File invHeader = fileChooser.getSelectedFile();
                Path headerPath = Paths.get(invHeader.getAbsolutePath());
                List<String> headerLines = Files.readAllLines(headerPath);
                System.out.println("Invoice Table File Have Successfully Added");

                ArrayList<InvoiceHeader_mdl> headersArray = new ArrayList<>();
                for(String invoiceLine:headerLines)
                {
                    String [] invoiceParts = invoiceLine.split(",");
                    int invNum = Integer.parseInt(invoiceParts[0]);
                    String invDate = invoiceParts[1];
                    String customerName = invoiceParts[2];

                    InvoiceHeader_mdl header = new InvoiceHeader_mdl(invNum,invDate,customerName);
                    headersArray.add(header);
                }
                //Load
                JOptionPane.showMessageDialog(main_Screen, "Please Select Item Table File", "Attention", JOptionPane.INFORMATION_MESSAGE);
                openDialog = fileChooser.showOpenDialog(main_Screen);
                if(openDialog == JFileChooser.APPROVE_OPTION) {

                    File invItem = fileChooser.getSelectedFile();
                    Path itemsPath = Paths.get(invItem.getAbsolutePath());
                    List<String> itemLines = Files.readAllLines(itemsPath);
                    System.out.println("Item Table File Have Successfully Added");

                    List<InvoiceItems_mdl> AllItems = new ArrayList<>();

                    for(String itemLine:itemLines)
                    {
                        String [] itemParts = itemLine.split(",");
                        int itemNum = Integer.parseInt(itemParts[0]);
                        String itemName = itemParts[1];
                        double itemPrice = Double.parseDouble(itemParts[2]);
                        int itemCount = Integer.parseInt(itemParts[3]);

                        InvoiceHeader_mdl invoiceHeader = null;
                        for(InvoiceHeader_mdl invoice : headersArray){
                            if(invoice.getInvoiceNumber() == itemNum){
                                invoiceHeader = invoice;
                                break;
                            }

                        }
                        InvoiceItems_mdl items = new InvoiceItems_mdl(itemName,itemPrice,itemCount,invoiceHeader);
                        invoiceHeader.getItems().add(items);
                        AllItems.add(items);
                    }
                       //files Load
                    int LastNumberLine = 0;
                    for(InvoiceItems_mdl OneItem : AllItems){
                        if(LastNumberLine != OneItem.get_Invoice().getInvoiceNumber()){
                            System.out.println("         - Invoice Number " + OneItem.get_Invoice().getInvoiceNumber());
                            System.out.println("*************************************");
                            System.out.println(OneItem.get_Invoice().getInvoiceDate() + "," + OneItem.get_Invoice().getCustomerName());

                            // Print all items per this invoice
                            for(InvoiceItems_mdl SubItem : AllItems){
                                if(SubItem.get_Invoice().getInvoiceNumber() == OneItem.get_Invoice().getInvoiceNumber()){
                                    System.out.println("- Item Name : "+SubItem.getItemName()+  "   |   Item Price : " + SubItem.getItemPrice() +  "   |   ItemCount : " + SubItem.getItemCount());
                                }
                            }

                            System.out.println("*************************************");
                            LastNumberLine = OneItem.get_Invoice().getInvoiceNumber();
                        }
                    }


                }

                main_Screen.setInvoices(headersArray);
                HeaderTable_mdl headerTableModel = new HeaderTable_mdl(headersArray);
                main_Screen.setHeaderTableModel(headerTableModel);
                main_Screen.getHeaderTable().setModel(headerTableModel);
                main_Screen.getHeaderTableModel().fireTableDataChanged();
            }
        } catch(IOException ex){
            ex.printStackTrace();
        }

    }

    private void saveFile() {
        ArrayList<InvoiceHeader_mdl> invoices = main_Screen.getInvoices();
        String invoiceHeaders = "";
        String itemLines ="";
        for(InvoiceHeader_mdl invoice : invoices)
        {
            String invCSV = invoice.getInvoiceHeaderFile();
            invoiceHeaders += invCSV;
            invoiceHeaders += "\n";

            for(InvoiceItems_mdl line : invoice.getItems())
            {
                String lineCSV = line.getItemFile();
                itemLines += lineCSV;
                itemLines += "\n";
            }
        }
        try {
            //Save
            JFileChooser fc = new JFileChooser();
            int saveResult = fc.showSaveDialog(main_Screen);
            if(saveResult == JFileChooser.APPROVE_OPTION){
                File headerFile = fc.getSelectedFile();
                FileWriter headerFileWriter = new FileWriter(headerFile);
                headerFileWriter.write(invoiceHeaders);
                headerFileWriter.flush();
                headerFileWriter.close();
                saveResult = fc.showSaveDialog(main_Screen);
                if(saveResult == JFileChooser.APPROVE_OPTION){
                    File lineFile = fc.getSelectedFile();
                    FileWriter lineFileWriter = new FileWriter(lineFile);
                    lineFileWriter.write(itemLines);
                    lineFileWriter.flush();
                    lineFileWriter.close();
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
