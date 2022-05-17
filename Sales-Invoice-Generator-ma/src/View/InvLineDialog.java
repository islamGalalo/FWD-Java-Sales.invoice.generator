/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import GUI.InvFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class InvLineDialog extends JDialog{
   
   private JTextField itemNameField;
   private JTextField itemCountField;
   private JTextField itemPriceField;
   private JLabel itemNameLbl;
   private JLabel itemCountLbl;
   private JLabel itemPriceLbl;
   private JButton okBtn;
   private JButton cancelBtn;
   
   public InvLineDialog(InvFrame frame){
        itemNameLbl = new JLabel ("Item Name: ");
        itemNameField = new JTextField(30);
        
        itemCountLbl = new JLabel ("Item Count: ");
        itemCountField  = new JTextField(30);
        
        itemPriceLbl = new JLabel ("Item Price: ");
        itemPriceField  = new JTextField(30);
        
        okBtn = new JButton ("Ok");
        cancelBtn = new JButton ("Cancel");

        okBtn.setActionCommand("creatLinevOk");
        cancelBtn .setActionCommand("creatLineCancel");
        okBtn.addActionListener(frame.getListener());
        cancelBtn.addActionListener(frame.getListener());
        
        setLayout (new GridLayout(4,2));
       
        add(itemNameField);  
        add(itemNameLbl);
       
        add(itemCountField);
        add(itemCountLbl);
        
        add(itemPriceField);
        add(itemPriceLbl);
       
        add(okBtn);
        add(cancelBtn);
        
        pack();
   }

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemCountField() {
        return itemCountField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }

}

