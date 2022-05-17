package Model;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class InvHeaderTableModel extends DefaultTableModel {
    private String[] cols = {"No.", "Invoice Date", "Customer Name", "Total"};
    private ArrayList<InvoiceHeader> headers;

    public InvHeaderTableModel(ArrayList<InvoiceHeader> data) {
        this.cols = cols;
        this.headers= data;
    }


    @Override
    public int getRowCount() {
        if (headers == null){
        headers =new ArrayList<>();
        }
        return headers.size();
    }

 
    @Override
    public String getColumnName(int column) {
      
        return cols[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader row = headers.get(rowIndex);
        switch (columnIndex) {
            case 0: return row.getInvNum();
            case 1: return row.getInvDate();
            case 2: return row.getCusName();
            case 3: return row.getInvTotal();
        }
        return "";
    }
   @Override
    public int getColumnCount() {
        return cols.length;
    }

    public ArrayList<InvoiceHeader> getHeaders() {
        return headers;
    }
    
    @Override
    public void removeRow(int row) {
    headers.remove(row);
    }
}


