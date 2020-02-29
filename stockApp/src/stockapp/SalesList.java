
package stockapp;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SalesList extends javax.swing.JDialog {

    public SalesList(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
          try {
            
        
        String[] headings={"Sale Id","Date","Customer Name","Address","Contact No."};
              DefaultTableModel dtm=new DefaultTableModel(headings,0);
                     
        jTable1.setModel(dtm);
        
        Statement st=StockApp.con.createStatement();
        ResultSet rs=st.executeQuery("Select S.saleId,S.saleDate,S.customerName,S.address,S.contactNo from sales as S");
        
          while(rs.next())
        {
            Object[] row=new Object[5];
            row[0]=rs.getInt("saleId");
            row[1]=rs.getString("saleDate");
            row[2]=rs.getString("customerName");
            row[3]=rs.getString("address");
            row[4]=rs.getString("contactNo");
            
           
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
           try
       {
        if(evt.getClickCount()==1)
        {
            int index = jTable1.getSelectedRow();
            
            int SMID = Integer.parseInt( jTable1.getValueAt(index, 0).toString());
            PreparedStatement ps=StockApp.con.prepareStatement("Select S.DetailId, B.BookName, S.Quantity, S.Price From saleDetails as [S], Books as [B] Where S.BookId=B.BookId and S.saleId="+SMID);
            ResultSet rs=ps.executeQuery();
            String[] headings={"Detail Id","Book Name","Quantity","Price"};
            DefaultTableModel dtm=new DefaultTableModel(headings,0);
            jTable2.setModel(dtm);
            Object[] r=new Object[4];
            while(rs.next())
            {
              r[0]=rs.getInt("detailId");
              r[1]=rs.getString("bookName");
              r[2]=rs.getString("quantity");
              r[3]=rs.getString("price");
             
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
