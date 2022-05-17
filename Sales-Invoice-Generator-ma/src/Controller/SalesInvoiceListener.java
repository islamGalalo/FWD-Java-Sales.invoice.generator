
package Controller;

import GUI.InvFrame;
import Model.InvHeaderTableModel;
import Model.InvLineTableModel;
import Model.InvoiceHeader;
import Model.InvoiceLine;
import View.InvHeaderDialog;
import View.InvLineDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SalesInvoiceListener implements ActionListener, ListSelectionListener {

    private InvFrame frame;
    private SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    public SalesInvoiceListener(InvFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("L")) {
            try {
                loadFiles();
            } catch (Exception ex) {
                Logger.getLogger(InvFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getActionCommand().equals("S")) {
            try {
                saveData();
            } catch (Exception ex) {
                Logger.getLogger(InvFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getActionCommand().equals("CreateInv")) {
            createInvoice();
        } else if (e.getActionCommand().equals("DeleteInv")) {
            deleteInvoce();
        } else if (e.getActionCommand().equals("InsertItem")) {
            //System.out.println("Create new item clicked");
            InsertItem();
        } else if (e.getActionCommand().equals("DeleteItem")) {
            //System.out.println("Delete an item clicked");
            deleteItem();
        } else if (e.getActionCommand().equals("creatInvOk")) {
            createInvOk();
        } else if (e.getActionCommand().equals("creatInvCancle")) {
            createInvCancle();
        } else if (e.getActionCommand().equals("creatLinevOk")) {
            createLineOk();
        } else if (e.getActionCommand().equals("creatLineCancle")) {
            createLineCancle();
        }
    }

    private void loadFiles() throws Exception {

        frame.getFilesData().clear();
        frame.getInvList().clear();
     
        JOptionPane.showMessageDialog(frame, "Select Inoices header file", "Inv Header", JOptionPane.WARNING_MESSAGE);
        JFileChooser fc = new JFileChooser();
        int option = fc.showOpenDialog(frame);
        File selectFile;
        if (option == JFileChooser.APPROVE_OPTION) {
            selectFile = fc.getSelectedFile();
            FileReader fr = new FileReader(selectFile);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] headerLine = line.split(",");
                int invNum = Integer.parseInt(headerLine[0]);
                Date invdate = df.parse(headerLine[1]);
                String custName = headerLine[2];
                InvoiceHeader header = new InvoiceHeader(invNum, invdate, custName);
                frame.getFilesData().add(header);
            }
            br.close();
            fr.close();

        }
  
        JOptionPane.showMessageDialog(frame, " Select Invoice Lines file", "Inv Lines", JOptionPane.WARNING_MESSAGE);
        option = fc.showOpenDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION) {
            selectFile = fc.getSelectedFile();
            FileReader fr = new FileReader(selectFile);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] InvoiceLines = line.split(",");
                int invNum = Integer.parseInt(InvoiceLines[0]);
                String CustomerName = InvoiceLines[1];
                double price = Double.parseDouble(InvoiceLines[2]);
                int count = Integer.parseInt(InvoiceLines[3]);
                InvoiceHeader header = findByNum(invNum);
                InvoiceLine Invline = new InvoiceLine(CustomerName, price, count, header);
                header.addLine(Invline);

            }
            br.close();
            fr.close();
            System.out.println("check line");
            frame.setHeaderTableModel(new InvHeaderTableModel(frame.getFilesData()));
            frame.getHeaderTable().setModel(frame.getHeaderTableModel());
            frame.getHeaderTable().validate();
        }

    }

    private InvoiceHeader findByNum(int num) {
        InvoiceHeader h = null;
        for (InvoiceHeader header : frame.getFilesData()) {
            if (num == header.getInvNum()) {
                h = header;
                break;
            }
        }
        return h;
    }

    private void saveData() throws Exception {

        JOptionPane.showMessageDialog(frame, "Please Chosce File Header to Save", "Invooice Header", JOptionPane.WARNING_MESSAGE);
        JFileChooser fileChoosers = new JFileChooser();
        int option = fileChoosers.showOpenDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION) {
            File Csvfile = fileChoosers.getSelectedFile();
            PrintWriter out = new PrintWriter(Csvfile);

            for (InvoiceHeader header : frame.getFilesData()) {

                out.printf("%s,%s,%s", ""+header.getInvNum(), df.format(header.getInvDate()), header.getCusName());
                out.println();
            }
            out.close();
            JOptionPane.showMessageDialog(frame, "Successfully Header Saved", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        JOptionPane.showMessageDialog(frame, "Please Chosce File Line to Save", "Invooice Line", JOptionPane.WARNING_MESSAGE);
        fileChoosers = new JFileChooser();
        option = fileChoosers.showOpenDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION) {
            File Csvfilee = fileChoosers.getSelectedFile();
            PrintWriter file = new PrintWriter(Csvfilee);

            for (InvoiceHeader header : frame.getFilesData()) {
                for (InvoiceLine Lines : header.getLines()) {

                    file.printf("%s,%s,%s,%s", ""+Lines.getInvoiceHeader().getInvNum(), Lines.getItemName(), "" + Lines.getItemPrice(), ""+Lines.getCount());
                    file.println();
                }
            }
            file.close();
            JOptionPane.showMessageDialog(frame, "Successfully Lines Saved", "Information", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void createInvoice() {
        frame.setHeaderDialog(new InvHeaderDialog(frame));
        frame.getHeaderDialog().setVisible(true);
    }

    private void deleteInvoce() {
        int x = frame.getHeaderTable().getSelectedRow();
        frame.getHeaderTableModel().removeRow(x);
        frame.getHeaderTableModel().fireTableDataChanged();
        frame.getLineTableModel().fireTableDataChanged();

    }

    private void headerTableRowSelected() {
        int selectedRowIndex = frame.getHeaderTable().getSelectedRow();
        if (selectedRowIndex >= 0) {
            InvoiceHeader row = frame.getHeaderTableModel().getHeaders().get(selectedRowIndex);
            frame.getCusNameTF().setText(row.getCusName());
            frame.getInvDateTF().setText(row.getInvDate().toString());
            frame.getInvNumLbl().setText("" + row.getInvNum());
            frame.getInvTotalLbl().setText("" + row.getInvTotal());
            ArrayList<InvoiceLine> lines = row.getLines();
            frame.setLineTableModel(new InvLineTableModel(lines));
            frame.getLineTable().setModel(frame.getLineTableModel());
            frame.getLineTableModel().fireTableDataChanged();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        headerTableRowSelected();
    }

    private void InsertItem() {
        frame.setLineDialog(new InvLineDialog(frame));
        frame.getLineDialog().setVisible(true);
    }

    private void deleteItem() {

        int x = frame.getLineTable().getSelectedRow();
        frame.getLineTableModel().removeRow(x);
        frame.getLineTableModel().fireTableDataChanged();
        frame.getHeaderTableModel().fireTableDataChanged();
    }

    private void createInvOk() {

        String customername = frame.getHeaderDialog().getCustNameField().getText();
        String invdateString = frame.getHeaderDialog().getInvDateField().getText();
        Date invdate = new Date();
        try {
            Date inDate = df.parse(invdateString);
        } catch (ParseException ex) {
            //  Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.getHeaderDialog().setVisible(false);

        int newNumber = getMaxNumber();
        InvoiceHeader headerNew = new InvoiceHeader(newNumber, invdate, customername);
        frame.getFilesData().add(headerNew);
        frame.getHeaderTableModel().fireTableDataChanged();

    }

    private void createInvCancle() {
        frame.getHeaderDialog().setVisible(false);
    }

    private void createLineOk() {
        String itemName = frame.getLineDialog().getItemNameField().getText();
        String itemCountStr = frame.getLineDialog().getItemCountField().getText();
        String itemPriceStr = frame.getLineDialog().getItemPriceField().getText();
        frame.getLineDialog().setVisible(false);
        int itemCount = Integer.parseInt(itemCountStr);
        double itemPrice = Double.parseDouble(itemPriceStr);
        InvoiceHeader invoiceHeader = frame.getFilesData().get(frame.getHeaderTable().getSelectedRow());

        InvoiceLine line = new InvoiceLine(itemName, itemPrice, itemCount, invoiceHeader);
        invoiceHeader.addLine(line);
        frame.getLineTableModel().fireTableDataChanged();
        frame.getHeaderTableModel().fireTableDataChanged();
    }

    private void createLineCancle() {
        frame.getLineDialog().setVisible(false);
    }

    private int getMaxNumber() {
        int num = 0;
        for (InvoiceHeader header : frame.getFilesData()) {

            if (header.getInvNum() > num) {
                num = header.getInvNum();
            }
        }

        return num + 1;
    }

    private Object getFilesData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
