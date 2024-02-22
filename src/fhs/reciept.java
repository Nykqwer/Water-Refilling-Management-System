/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fhs;


import java.awt.Color;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author Nyko
 */
public class reciept extends javax.swing.JFrame {



   
    public reciept() {
        initComponents();
        format_JTable();
      fill_receipt();
        
    }
    
    private void format_JTable(){
    JTableHeader header = table_content.getTableHeader();
    header.setVisible(false);
    DefaultTableCellRenderer right = new DefaultTableCellRenderer();
    right.setHorizontalAlignment(JLabel.RIGHT);
       DefaultTableCellRenderer left = new DefaultTableCellRenderer();
    left.setHorizontalAlignment(JLabel.CENTER);
       table_content.setShowGrid(false);
    table_content.setAutoResizeMode(0);
      table_content.getColumnModel().getColumn(1).setCellRenderer(left);
    table_content.getColumnModel().getColumn(2).setCellRenderer(right);
     table_content.getColumnModel().getColumn(0).setPreferredWidth(180);
      table_content.getColumnModel().getColumn(1).setPreferredWidth(120);
   table_content.getColumnModel().getColumn(2).setPreferredWidth(130);
    table_pane.getColumnHeader().setVisible(false);
    table_pane.getViewport().setBackground(Color.WHITE);
    
    
    
    
    }
    double QTY;
private void fill_receipt() {
    DefaultTableModel model1 = (DefaultTableModel) waterrefilling1.reciept_table.getModel();
    DefaultTableModel model2 = (DefaultTableModel) table_content.getModel();
    ArrayList<String> items = new ArrayList<>();
    ArrayList<String> quantity = new ArrayList<>();
    ArrayList<String> amount = new ArrayList<>();

    for (int r = 0; r < model1.getRowCount(); r++) {
        Object itemValue = model1.getValueAt(r, 0);
        Object quantityValue = model1.getValueAt(r, 1);
        Object amountValue = model1.getValueAt(r, 2);

        if (itemValue != null && quantityValue != null && amountValue != null) {
            items.add(itemValue.toString());
            quantity.add(quantityValue.toString());
            amount.add(amountValue.toString());
        }
    }

    int item_count = items.size();
    for (int i = 0; i < item_count; i++) {
        String particulars = "";
        String qty2 = "";
        String unit_price2 = "";

        if (i < items.size()) {
            String item = items.get(i);
            if (item != null) {
                particulars = item + ".....................................................................";
            }
        }

        if (i < quantity.size()) {
            String qty = quantity.get(i);
            if (qty != null) {
                int qtyInt = Integer.parseInt(qty.replace(",", ""));
                qty2 = String.format("%,d", qtyInt);
            }
        }

        if (i < amount.size()) {
            String price = amount.get(i);
            if (price != null) {
                double unit_price = Double.parseDouble(price.replace(",", ""));
                unit_price2 = String.format("%,.2f", unit_price);
            }
        }

        String[] unit = {particulars, qty2, unit_price2};
        model2.addRow(unit);
    }

    double total_amount = 0.00;
    
    for (int row = 0; row < model2.getRowCount(); row++) {
        Object value = table_content.getValueAt(row, 2);
        if (value != null) {
            String n = value.toString().replace(",", "");
            double n1 = Double.parseDouble(n);
            total_amount += n1;
            QTY = total_amount / 15.00;
        }
    }

    String totalamount = String.format("%,.2f", total_amount);
    String pricestock = String.format("%,.2f", QTY);

    String tenderamount = waterrefilling1.tender_amount.getText();
    double tender = 0.00;
    if (tenderamount != null) {
        tender = Double.parseDouble(tenderamount);
    }
    double change = tender - total_amount;

    String[] tendered = {String.format("%-30s", ""), String.format("%-10s", "CASH"), String.format("%,.2f", tender)};


String[] balance = {String.format("%-30s", ""), String.format("%-10s", "CHANGE"), String.format("%,.2f", change)};

String[] ttamt = {String.format("%-30s", ""), String.format("%-10s", "Total Amount"), totalamount};
String[] stocks = {String.format("%-30s", ""), String.format("%-10s", "Total QTY"), pricestock};

    String[] blank = null;
    model2.addRow(blank);
    model2.addRow(blank);
    model2.addRow(blank);
    model2.addRow(blank);
   model2.addRow(ttamt);
    model2.addRow(stocks);
    model2.addRow(blank);
    model2.addRow(tendered);
    model2.addRow(balance); 


    this.revalidate();

    try {
        BufferedImage img = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        panel.paint(img.getGraphics());
        ImageIO.write(img, "jpg", new File("D:\\fhs\\Receipt\\image.jpg"));
        Desktop.getDesktop().print(new File("D:\\fhs\\Receipt\\image.jpg"));
        this.dispose();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}


 /*private void fill_receipt(){
      
  DefaultTableModel model1 = (DefaultTableModel)waterrefilling1.reciept_table.getModel();
   DefaultTableModel model2 = (DefaultTableModel)table_content.getModel();
   ArrayList<String> items = new ArrayList<>();
    ArrayList<String> quantity = new ArrayList<>();
   ArrayList<String> amount = new ArrayList<>();
   
   for (int r=0;r<model1.getRowCount();r++){
   items.add(model1.getValueAt(r,0).toString());
    quantity.add(model1.getValueAt(r,1).toString());
   amount.add(model1.getValueAt(r,2).toString());
  
   }
 
   int item_count = items.size();
   for(int i = 0; i<item_count;i++){
       String particulars = items.get(i)+".....................................................................";
         int qty = Integer.parseInt(quantity.get(i).replace(",",""));
           String qty2 = String.format("%,d", qty);
       double unit_price = Double.parseDouble(amount.get(i).replace(",",""));
       String unit_price2 = String.format("%,.2f", unit_price);
       String [] unit = {particulars, qty2, unit_price2};
     
       model2.addRow(unit);
   
   }
  
  
   double total_amount  = 0.00;
   for(int row = 0; row<model2.getRowCount();row++){
   String n = table_content.getValueAt(row,2).toString().replace(",","");
   double n1 = Double.parseDouble(n);
   total_amount +=n1; 
    QTY = total_amount / 15.00;
   
   } 
   
   String totalamount = String.format("%,.2f",total_amount);
   String  pricestock = String.format("%,.2f",QTY);
   
   String tenderamount = waterrefilling1.tender_amount.getText();
   double tender = Double.parseDouble(tenderamount);
   double change = tender - total_amount;
      String blank3 = null;
   String [] tendered = {String.format("%30s", "CASH"),String.format("%,.2f",tender),blank3};
   String [] balance = {String.format("%30s", "CHANGE"),String.format("%,.2f",change),blank3};
   
  
   String [] ttamt = {String.format("%30s", "Total Amount"), totalamount,blank3};
   String [] stocks = {String.format("%30s", "Total QTY"), pricestock,blank3};
   String [] blank = null;
    String [] blank1 = null;
    model2.addRow(blank);
   model2.addRow(ttamt);
   model2.addRow(stocks);
    model2.addRow(blank);
    model2.addRow(tendered);
     model2.addRow(balance);
   this.revalidate();
   
   try{
       BufferedImage img = new BufferedImage(panel.getWidth(),panel.getHeight(),BufferedImage.TYPE_INT_RGB);
       panel.paint(img.getGraphics());
       ImageIO.write(img,"jpg", new File("D:\\fhs\\Receipt\\image.jpg"));
       Desktop.getDesktop().print(new File("D:\\fhs\\Receipt\\image.jpg"));
       this.dispose();
   
   }catch(Exception e){
   JOptionPane.showMessageDialog(null,e);
   
  } 
  
   
  }*/
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jTextArea2 = new javax.swing.JTextArea();
        jTextArea5 = new javax.swing.JTextArea();
        jTextArea7 = new javax.swing.JTextArea();
        table_pane = new javax.swing.JScrollPane();
        table_content = new javax.swing.JTable();
        jTextArea9 = new javax.swing.JTextArea();
        jTextArea8 = new javax.swing.JTextArea();
        jTextArea10 = new javax.swing.JTextArea();
        jTextArea11 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(424, 600));
        setMinimumSize(new java.awt.Dimension(424, 600));

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setMaximumSize(new java.awt.Dimension(460, 553));
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("Thank you!");
        jTextArea2.setBorder(null);
        jTextArea2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextArea2PropertyChange(evt);
            }
        });
        panel.add(jTextArea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 100, 20));

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jTextArea5.setText("---------------------------------------------------------------------------------------------------------------------------");
        jTextArea5.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextArea5PropertyChange(evt);
            }
        });
        panel.add(jTextArea5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 460, 20));

        jTextArea7.setColumns(20);
        jTextArea7.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        jTextArea7.setRows(5);
        jTextArea7.setText("Particulars \t         QTY\t\tAmount");
        jTextArea7.setBorder(null);
        jTextArea7.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextArea7PropertyChange(evt);
            }
        });
        panel.add(jTextArea7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 370, 20));

        table_pane.setBackground(new java.awt.Color(255, 255, 255));
        table_pane.setBorder(null);
        table_pane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        table_pane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        table_content.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_contentMouseClicked(evt);
            }
        });
        table_content.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                table_contentPropertyChange(evt);
            }
        });
        table_pane.setViewportView(table_content);

        panel.add(table_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 430, 300));

        jTextArea9.setColumns(20);
        jTextArea9.setRows(5);
        jTextArea9.setText("---------------------------------------------------------------------------------------------------------------------------");
        jTextArea9.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextArea9PropertyChange(evt);
            }
        });
        panel.add(jTextArea9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 440, 20));

        jTextArea8.setColumns(20);
        jTextArea8.setRows(5);
        jTextArea8.setText("---------------------------------------------------------------------------------------------------------------------------");
        jTextArea8.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextArea8PropertyChange(evt);
            }
        });
        panel.add(jTextArea8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 440, 20));

        jTextArea10.setColumns(20);
        jTextArea10.setRows(5);
        jTextArea10.setText("---------------------------------------------------------------------------------------------------------------------------");
        jTextArea10.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextArea10PropertyChange(evt);
            }
        });
        panel.add(jTextArea10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 460, 20));

        jTextArea11.setColumns(20);
        jTextArea11.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        jTextArea11.setRows(5);
        jTextArea11.setText("   South East Asian Institute of Technology Inc.\n\t    FHS Water Refilling Station\n \t   http://seait-edu.ph/index.php\n\t\t0999999999999999\n");
        jTextArea11.setBorder(null);
        jTextArea11.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextArea11PropertyChange(evt);
            }
        });
        panel.add(jTextArea11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 436, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextArea11PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextArea11PropertyChange
 jTextArea11.setEditable(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea11PropertyChange

    private void jTextArea7PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextArea7PropertyChange
        jTextArea7.setEditable(false);
    }//GEN-LAST:event_jTextArea7PropertyChange

    private void jTextArea2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextArea2PropertyChange
         jTextArea2.setEditable(false);
    }//GEN-LAST:event_jTextArea2PropertyChange

    private void jTextArea8PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextArea8PropertyChange
       jTextArea8.setEditable(false);
    }//GEN-LAST:event_jTextArea8PropertyChange

    private void jTextArea9PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextArea9PropertyChange
         jTextArea9.setEditable(false);
    }//GEN-LAST:event_jTextArea9PropertyChange

    private void jTextArea10PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextArea10PropertyChange
        jTextArea10.setEditable(false);
    }//GEN-LAST:event_jTextArea10PropertyChange

    private void jTextArea5PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextArea5PropertyChange
        jTextArea5.setEditable(false);
    }//GEN-LAST:event_jTextArea5PropertyChange

    private void table_contentPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_table_contentPropertyChange
       
    }//GEN-LAST:event_table_contentPropertyChange

    private void table_contentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_contentMouseClicked
   
    }//GEN-LAST:event_table_contentMouseClicked

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked
               new waterrefilling1().show();
         this.dispose();
    }//GEN-LAST:event_panelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(reciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reciept().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JPanel panel;
    protected static javax.swing.JTable table_content;
    private javax.swing.JScrollPane table_pane;
    // End of variables declaration//GEN-END:variables
}
