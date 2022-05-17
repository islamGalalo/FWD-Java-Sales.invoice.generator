
package Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


public class InvLineTableModel extends DefaultTableModel {
    private String[] cols = {"Item name", "Item Price", "Count", "Item Total"};
    private ArrayList<InvoiceLine> Liness;

    public InvLineTableModel(ArrayList<InvoiceLine> cols) {
      
        this.Liness = cols;
    }


    @Override
    public int getRowCount() {
        if (Liness == null){
        Liness =new ArrayList<>();
        }
        return Liness.size();
        
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        InvoiceLine row = Liness.get(rowIndex);
        switch (columnIndex){
            case 0 : return row.getItemName();
            case 1 : return row.getItemPrice();
            case 2 : return row.getCount();         
            case 3 : return row.getItemTotal();          
        
        }
        return " ";

    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
    
        public ArrayList<InvoiceLine> getLiness() {
        return Liness;
    }

    @Override
    public void removeRow(int row) {
    Liness.remove(row);
    }

        
        
}