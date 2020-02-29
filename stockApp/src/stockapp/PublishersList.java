
package stockapp;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class PublishersList extends javax.swing.JDialog {
    private Object jTextField1;
    private Object jTextField2;
    private Object jTextField3;

   
    public PublishersList(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();        
        
        loadPublishers();
        
    }//constructor
    
    private void loadPublishers()
    {
                   try
                  {
                String[] headings ={"Publisher Id","Name","Address","City","Pin Code","Contact Number","Email Id","Contact Name"};
               DefaultTableModel dtm = new DefaultTableModel(headings, 0);
               jTable1.setModel(dtm);
               Statement st = StockApp.con.createStatement();
                ResultSet rs = st.executeQuery("Select * From publishers");
                
                while(rs.next())
                {
                    Object[] row = new Object[8];
                    
                    row[0]= rs.getInt("publisherId");
                    row[1] = rs.getString("PubLisHerName");
                    row[2] = rs.getString("Address");
                    row[3] = rs.getString("city");
                    row[4]= rs.getString("pincode");
                    row[5]= rs.getString("contactNo");
                     row[6]= rs.getString("emailId");
                    row[7]= rs.getString("contactname");
                    
                    
                    dtm.addRow(row);
                }//while
           
        }//try
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex);
        }//catch

    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Publishers");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        int x=jTable1.getSelectedRow();
      if(x>=0)
      {
          int temp=Integer.parseInt(jTable1.getValueAt(x,0).toString());
          Publisher obj=new Publisher(null,true);
          
          obj.startEditing(temp);
          
          obj.setVisible(true);
                 
            loadPublishers();
      }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int a=jTable1.getSelectedRow();
        
        if(a>=0)
        {
            int pid =  Integer.parseInt( jTable1.getValueAt(a, 0).toString());
            
            try
            {
                PreparedStatement ps = StockApp.con.prepareStatement("Delete From Publishers where PublisherId=?");
                ps.setInt(1, pid);
                ps.execute();
                
                loadPublishers();
            }//try
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex);
            }//catch
            
        }//if
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
