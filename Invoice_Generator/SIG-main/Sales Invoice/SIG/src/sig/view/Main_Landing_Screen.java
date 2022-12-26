
package sig.view;
import sig.controller.ButtonActionHandler;
import sig.controller.SaveAndLoadActionHandler;
import sig.controller.TableSelectionActionHandler;
import sig.model.HeaderTable_mdl;
import sig.model.InvoiceHeader_mdl;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
public class Main_Landing_Screen extends javax.swing.JFrame {

    public Main_Landing_Screen() {
        initComponents();
    }
     private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HeaderTable = new javax.swing.JTable();
        HeaderTable.getSelectionModel().addListSelectionListener(tscontroller);
        CreateHeader = new javax.swing.JButton();
        CreateHeader.addActionListener(bcontroller);
        deleteHeader = new javax.swing.JButton();
        deleteHeader.addActionListener(bcontroller);
        InvoiceNumLabel = new javax.swing.JLabel();
        InvoiceDateLabel = new javax.swing.JLabel();
        CustomerNameLabel = new javax.swing.JLabel();
        InvoiceTotalLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LineTable = new javax.swing.JTable();
        createLine = new javax.swing.JButton();
        createLine.addActionListener(bcontroller);
        deleteLine = new javax.swing.JButton();
        deleteLine.addActionListener(bcontroller);
        InvoiceNumberLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        numberLabel = new javax.swing.JLabel();
        datelabel = new javax.swing.JLabel();
        namelabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileName = new javax.swing.JMenu();
        LoadFile = new javax.swing.JMenuItem();
        LoadFile.addActionListener(fcontroller);
        SaveFile = new javax.swing.JMenuItem();
        SaveFile.addActionListener(fcontroller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Invoice Table");
        HeaderTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        jScrollPane1.setViewportView(HeaderTable);

        CreateHeader.setFont(new java.awt.Font("Arial", 1, 14));
        CreateHeader.setText("Create New Invoice");
        CreateHeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewHeaderActionPerformed(evt);
            }
        });

        deleteHeader.setFont(new java.awt.Font("Arial", 1, 14));
        deleteHeader.setText("Delete Invoice");
        deleteHeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteHeaderActionPerformed(evt);
            }
        });

        InvoiceNumLabel.setFont(new java.awt.Font("Arial", 1, 16));
        InvoiceNumLabel.setText("Invoice Number : ");

        InvoiceDateLabel.setFont(new java.awt.Font("Arial", 1, 16));
        InvoiceDateLabel.setText("Invoice Date : ");

        CustomerNameLabel.setFont(new java.awt.Font("Arial", 1, 16));
        CustomerNameLabel.setText("Customer Name : ");

        InvoiceTotalLabel.setFont(new java.awt.Font("Arial", 1, 16));
        InvoiceTotalLabel.setText("Invoice Total Amount : ");

        LineTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        jScrollPane2.setViewportView(LineTable);

        createLine.setFont(new java.awt.Font("Arial", 1, 16));
        createLine.setText("Add Item");

        deleteLine.setFont(new java.awt.Font("Arial", 1, 16));
        deleteLine.setText("Delete Item");
        deleteLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLineActionPerformed(evt);
            }
        });

        numberLabel.setFont(new java.awt.Font("Arial", 1, 16));
        numberLabel.setForeground(new java.awt.Color(1, 1, 1));
        numberLabel.setText("0000");

        datelabel.setFont(new java.awt.Font("Arial", 1, 16));
        numberLabel.setForeground(new java.awt.Color(1, 1, 1));
        datelabel.setText("0000");

        namelabel.setFont(new java.awt.Font("Arial", 1, 14));
        numberLabel.setForeground(new java.awt.Color(1, 1, 1));

        namelabel.setText("0000");

        totalLabel.setFont(new java.awt.Font("Arial", 1, 14));
        totalLabel.setForeground(new java.awt.Color(1, 1, 1));
        totalLabel.setText("0000");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 22));
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Item Table");

        FileName.setText("File");

        LoadFile.setText("Load File");
        FileName.add(LoadFile);

        SaveFile.setText("Save File");
        SaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveFileActionPerformed(evt);
            }
        });
        FileName.add(SaveFile);

        jMenuBar1.add(FileName);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(CreateHeader)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(deleteHeader))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(createLine)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(deleteLine))
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(InvoiceDateLabel)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(InvoiceTotalLabel)
                                                                                .addGap(130, 130, 130)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(InvoiceNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(CustomerNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(InvoiceNumLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(numberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(datelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(namelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(268, 268, 268)
                                                .addComponent(jLabel2)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(InvoiceNumberLabel)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(22, 22, 22)
                                                                                .addComponent(datelabel)))
                                                                .addGap(34, 34, 34)
                                                                .addComponent(jLabel8))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(InvoiceNumLabel)
                                                                        .addComponent(numberLabel))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(InvoiceDateLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(CustomerNameLabel)
                                                                        .addComponent(namelabel))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(InvoiceTotalLabel)
                                                                        .addComponent(totalLabel))))
                                                .addGap(44, 44, 44)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CreateHeader)
                                        .addComponent(deleteHeader)
                                        .addComponent(createLine)
                                        .addComponent(deleteLine))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void CreateNewHeaderActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void SaveFileActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void deleteHeaderActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void deleteLineActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Landing_Screen().setVisible(true);
            }
        });


    }

    private javax.swing.JButton CreateHeader,createLine,deleteHeader ,deleteLine ;
    private javax.swing.JLabel CustomerNameLabel,InvoiceDateLabel,InvoiceNumLabel,InvoiceNumberLabel,InvoiceTotalLabel;
    private javax.swing.JLabel datelabel ,namelabel,numberLabel,totalLabel, jLabel1 ,jLabel10  , jLabel9  ,jLabel8  ,jLabel2;
    private javax.swing.JMenu FileName;
    private javax.swing.JTable HeaderTable,LineTable;
    private javax.swing.JMenuItem LoadFile,SaveFile;

    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1,jScrollPane2;
    private ArrayList<InvoiceHeader_mdl> invoices;
    private HeaderTable_mdl header_Table;
    private SaveAndLoadActionHandler fcontroller = new SaveAndLoadActionHandler(this);
    private ButtonActionHandler bcontroller = new ButtonActionHandler(this);
    private TableSelectionActionHandler tscontroller = new TableSelectionActionHandler(this);

    public JLabel getDatelabel() {
        return datelabel;
    }
    public JLabel getNamelabel() {
        return namelabel;
    }

    public JLabel getNumberLabel() {
        return numberLabel;
    }

    public JLabel getTotalLabel() {
        return totalLabel;
    }

    public ArrayList<InvoiceHeader_mdl> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<InvoiceHeader_mdl> invoices) {
        this.invoices = invoices;
    }

    public HeaderTable_mdl getHeaderTableModel() {
        return header_Table;
    }

    public void setHeaderTableModel(HeaderTable_mdl headerTableModel) {
        this.header_Table = headerTableModel;
    }
    public JTable getHeaderTable() {
        return HeaderTable;
    }

    public JTable getLineTable() {
        return LineTable;
    }

    public ButtonActionHandler getBcontroller() {
        return bcontroller;
    }

    public int getNextInvoiceNum() {
        int number = 0;
        for(InvoiceHeader_mdl invoice : invoices){
            if(invoice.getInvoiceNumber() > number) number = invoice.getInvoiceNumber();
        }

        return ++number;


    }


}