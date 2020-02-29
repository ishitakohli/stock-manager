
package stockapp;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PurchaseList extends javax.swing.JDialog {
   

    
    public PurchaseList(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            
        
        String[] headings={"Purchase Id","Date","Bill No.","Description"};
        DefaultTableModel dtm=new DefaultTableModel(headings,0);
        jTable1.setModel(dtm);
        
        Statement st=StockApp.con.createStatement();
        ResultSet rs=st.executeQuery("Select P.purchasemasterId,P.date,P.billNo,P.description from PurchaseMaster as P ");
        
          while(rs.next())
        {
            Object[] row=new Object[4];
            row[0]=rs.getInt("purchasemasterid");
            row[1]=rs.getString("date");
            row[2]=rs.getString("billNo");
            row[3]=rs.getString("description");
            
           
            dtm.addRow(row);
        }//while
        }//try
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PURCHASES");

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       try
       {
        if(evt.getClickCount()==1)
        {
            int index = jTable1.getSelectedRow();
            
            int PMID = Integer.parseInt( jTable1.getValueAt(index, 0).toString());
            PreparedStatement ps=StockApp.con.prepareStatement("Select PD.DetailId, B.BookName, PD.Quantity, PD.Price, PD.Tax From PurchaseDetails as [PD], Books as [B] Where PD.BookId=B.BookId and PD.PurchaseMasterId="+PMID);
            ResultSet rs=ps.executeQuery();
            String[] headings={"Detail Id","Book Name","Quantity","Price","Tax"};
            DefaultTableModel dtm=new DefaultTableModel(headings,0);
            jTable2.setModel(dtm);
            Object[] r=new Object[5];
            while(rs.next())
            {
              r[0]=rs.getInt("detailId");
              r[1]=rs.getString("bookName");
              r[2]=rs.getString("quantity");
              r[3]=rs.getString("price");
              r[4]=rs.getString("tax");
              dtm.addRow(r);
            }
            rs.close();
            ps.close();
                 
            
            
            
        }//IF
       }//try
       catch(Exception ex)
       {
           JOptionPane.showMessageDialog(rootPane, ex);
       }//catch
        
    }//GEN-LAST:event_jTable1MouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
