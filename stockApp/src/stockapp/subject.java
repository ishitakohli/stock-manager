
package stockapp;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class subject extends javax.swing.JDialog {
    ArrayList<Integer> CategoryIDS=new ArrayList<Integer>();
    private int subjectId=0;
    public void startEditingSubject(int sid)
    {
        subjectId=sid;
        try
        {
        PreparedStatement ps=StockApp.con.prepareStatement("Select S.subjectId, S.subjectName, C.categoryId, C.categoryName From subjects as [S], category as [C] Where S.categoryId=C.categoryId and S.subjectId=?"); 
           ps.setInt(1, subjectId);
            
          ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            String s1 = rs.getString("subjectName");
            jTextField1.setText(s1);
            
            s1 = rs.getString("categoryName");
                        String cnm="";
            
            for(int p=0;p<jComboBox1.getItemCount() ; p++ )
            {
                
                cnm =jComboBox1.getItemAt(p).toString();
                
                if(s1.equals(cnm))
                {
                    jComboBox1.setSelectedIndex(p);
                    break;
                }//IF
                
            }//For
            
        }//try
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex);
        }//catch
       
    }           
                    
            

    

    public subject(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try
        {
            Statement st=StockApp.con.createStatement();
            ResultSet rs=st.executeQuery("select * from category");
            int b;
            while(rs.next())
            {
              b=rs.getInt("categoryId");
              CategoryIDS.add(b);
             jComboBox1.addItem( rs.getString("categoryName"));
            }//while
             rs.close();
             st.close();
        }//try
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane , ex);
        }//catch
              
            
            
        
                   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DETAILS");

        jLabel1.setText("Subject Name");

        jLabel2.setText("Category");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Close");
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
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jTextField1)
                    .addComponent(jComboBox1, 0, 144, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            if(subjectId==0)
            {
            PreparedStatement ps=StockApp.con.prepareStatement("insert into subjects values(?,?)");
            ps.setString(1, jTextField1.getText());
            int i = jComboBox1.getSelectedIndex();
            int cid = CategoryIDS.get(i);
            
            ps.setInt(2, cid);
            
            ps.execute();
            }//if
            else
            {
                PreparedStatement ps=StockApp.con.prepareStatement("Update subjects set subjectName=?, categoryId=?  Where subjectId=?");
                                ps.setString(1, jTextField1.getText()  );
                                int i = jComboBox1.getSelectedIndex();
                                int cid = CategoryIDS.get(i);
                                ps.setInt(2, cid);
                                ps.setInt(3, subjectId);
                                ps.execute();

            }//else
        }//try
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex);
        }//catch
        JOptionPane.showMessageDialog(rootPane, "Record saved");
        jTextField1.setText("");
            
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                subject dialog = new subject(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
