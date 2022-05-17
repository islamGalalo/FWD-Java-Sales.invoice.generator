package GUI;

import Controller.SalesInvoiceListener;
import java.util.ArrayList;
import Model.InvHeaderTableModel;
import Model.InvLineTableModel;
import Model.InvoiceHeader;
import Model.InvoiceLine;
import View.InvHeaderDialog;
import View.InvLineDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;

public class InvFrame extends javax.swing.JFrame {

    public InvFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        headerTable = new javax.swing.JTable();
        headerTable.getSelectionModel().addListSelectionListener(listener);
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(listener);
        jButton2 = new javax.swing.JButton();
        jButton2.addActionListener(listener);
        label = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        InvoiceTotal = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lineTable = new javax.swing.JTable();
        InvNumber = new javax.swing.JLabel();
        cusNameTF = new javax.swing.JTextField();
        invDateTF = new javax.swing.JTextField();
        InvTotal = new javax.swing.JLabel();
        insertItemBtn = new javax.swing.JButton();
        insertItemBtn.addActionListener(listener);
        jButton4 = new javax.swing.JButton();
        jButton4.addActionListener(listener);
        jLabel5 = new javax.swing.JLabel();
        invNumLbl = new javax.swing.JLabel();
        invTotalLbl = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadFileMenuItem = new javax.swing.JMenuItem();
        loadFileMenuItem.addActionListener(listener);
        saveFileMenuItem = new javax.swing.JMenuItem();
        saveFileMenuItem.addActionListener(listener);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "Invoice Date", "Customer Name", "Total"
            }
        ));
        headerTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(headerTable);

        jButton1.setText("Create New Invoice");
        jButton1.setActionCommand("CreateInv");

        jButton2.setText("Delete Invoice");
        jButton2.setActionCommand("DeleteInv");

        label.setText("Invoice Num.");

        label1.setText("Invoice Date");

        InvoiceTotal.setText("Customer Name");

        label4.setText("Invoice Total");

        lineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Name", "Item Price", "Count", "Item Total"
            }
        ));
        lineTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lineTable);

        insertItemBtn.setText("Insert New Item");
        insertItemBtn.setActionCommand("InsertItem");

        jButton4.setText("Delete Item");
        jButton4.setActionCommand("DeleteItem");

        jLabel5.setText("Invoice Tabel");

        jMenu1.setText("File");

        loadFileMenuItem.setText("Load File");
        loadFileMenuItem.setActionCommand("L");
        jMenu1.add(loadFileMenuItem);

        saveFileMenuItem.setText("Save");
        saveFileMenuItem.setActionCommand("S");
        jMenu1.add(saveFileMenuItem);
        saveFileMenuItem.getAccessibleContext().setAccessibleName("S");

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InvoiceTotal)
                            .addComponent(label1)
                            .addComponent(label)
                            .addComponent(label4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invDateTF)
                            .addComponent(cusNameTF)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invNumLbl)
                                    .addComponent(invTotalLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(InvTotal)
                                    .addComponent(InvNumber))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(230, 230, 230)
                .addComponent(insertItemBtn)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(InvNumber)
                    .addComponent(jLabel5)
                    .addComponent(invNumLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(invDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoiceTotal)
                            .addComponent(cusNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(InvTotal)
                            .addComponent(invTotalLbl)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(insertItemBtn)
                            .addComponent(jButton4))))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        cusNameTF.getAccessibleContext().setAccessibleName("cusNameTF");
        invDateTF.getAccessibleContext().setAccessibleName("invDateTF");
        invNumLbl.getAccessibleContext().setAccessibleName("Invoice Num.");

        pack();
    } 
    
    public static void main(String args[]) {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvFrame().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel InvNumber;
    private javax.swing.JLabel InvTotal;
    private javax.swing.JLabel InvoiceTotal;
    private javax.swing.JTextField cusNameTF;
    private javax.swing.JTable headerTable;
    private javax.swing.JButton insertItemBtn;
    private javax.swing.JTextField invDateTF;
    private javax.swing.JLabel invNumLbl;
    private javax.swing.JLabel invTotalLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label4;
    private javax.swing.JTable lineTable;
    private javax.swing.JMenuItem loadFileMenuItem;
    private javax.swing.JMenuItem saveFileMenuItem;
    
    private ArrayList<InvoiceHeader> filesData = new ArrayList<>();
    private ArrayList<InvoiceLine> invList = new ArrayList<>();
    private InvHeaderTableModel headerTableModel;
    private InvLineTableModel lineTableModel;
    private InvHeaderDialog headerDialog;
    private InvLineDialog lineDialog;
    private SalesInvoiceListener listener =new SalesInvoiceListener(this);
 
    public void setHeaderTableModel(InvHeaderTableModel headerTableModel) {
        this.headerTableModel = headerTableModel;
    }

    public void setLineTableModel(InvLineTableModel lineTableModel) {
        this.lineTableModel = lineTableModel;
    }

    public void setHeaderDialog(InvHeaderDialog headerDialog) {
        this.headerDialog = headerDialog;
    }


    public void setLineDialog(InvLineDialog lineDialog) {
        this.lineDialog = lineDialog;
    }


    
    public JLabel getInvNumber() {
        return InvNumber;
    }

    public JLabel getInvTotal() {
        return InvTotal;
    }

    public JLabel getInvoiceTotal() {
        return InvoiceTotal;
    }

    public JTextField getCusNameTF() {
        return cusNameTF;
    }

    public JTable getHeaderTable() {
        return headerTable;
    }

    public JButton getInsertItemBtn() {
        return insertItemBtn;
    }

    public JTextField getInvDateTF() {
        return invDateTF;
    }

    public JLabel getInvNumLbl() {
        return invNumLbl;
    }

    public JLabel getInvTotalLbl() {
        return invTotalLbl;
    }

    public JTable getLineTable() {
        return lineTable;
    }

    public JMenuItem getLoadFileMenuItem() {
        return loadFileMenuItem;
    }

    public JMenuItem getSaveFileMenuItem() {
        return saveFileMenuItem;
    }

    public ArrayList<InvoiceHeader> getFilesData() {
        return filesData;
    }

    public ArrayList<InvoiceLine> getInvList() {
        return invList;
    }

    public InvHeaderTableModel getHeaderTableModel() {
        return headerTableModel;
    }

    public InvLineTableModel getLineTableModel() {
        return lineTableModel;
    }


    public InvHeaderDialog getHeaderDialog() {
        return headerDialog;
    }

    public InvLineDialog getLineDialog() {
        return lineDialog;
    }

    public SalesInvoiceListener getListener() {
        return listener;
    }



    
    
    
    
}