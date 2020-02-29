
package stockapp;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class AddBook extends javax.swing.JDialog {
    
    private int bookId;
    
    ArrayList<Integer> authorIDS=new ArrayList<Integer>();
    ArrayList<Integer> publisherIDS= new ArrayList<Integer>();
    ArrayList<Integer> categoryIDS=new ArrayList<Integer>();
    ArrayList<Integer> subjectIDS=new ArrayList<Integer>();

    public void startEditingBooks(int bid)
    {
        try
        {
        bookId=bid;
        PreparedStatement ps=StockApp.con.prepareStatement("Select B.bookID, B.bookName, A.firstName, P.publisherName, C.categoryName, S.subjectName, B.edition From Books as [B], authors as [A], publishers as [P], category as [C], subjects as [S] Where B.authorId=A.authorId and B.publisherId=P.publisherId and B.subjectId=S.subjectId and S.categoryId=C.categoryId and B.BookId=?");
        ps.setInt(1, bookId);
        
        ResultSet rs=ps.executeQuery();
        rs.next();

        String s1=rs.getString("bookName");
        jTextField1.setText(s1);
        
        s1=rs.getString("firstName");
        String fnm="";
        
        for(int i=0;i<jComboBox1.getItemCount() ; i++ )
            {
                
                fnm =jComboBox1.getItemAt(i).toString();
                
                if(s1.equals(fnm))
                {
                    jComboBox1.setSelectedIndex(i);
                    break;
                }//IF
                
            }//For
        s1=rs.getString("publisherName");
        String pnm="";
        
        for(int i=0;i<jComboBox2.getItemCount() ; i++ )
        {
                pnm =jComboBox2.getItemAt(i).toString();
                
                if(s1.equals(pnm))
                {
                    jComboBox2.setSelectedIndex(i);
                    break;
                }//IF
        }//For

        s1=rs.getString("categoryName");
        String cnm="";
                  
        for(int i=0;i<jComboBox3.getItemCount() ; i++ )
        {
                
                cnm =jComboBox3.getItemAt(i).toString();
                
                if(s1.equals(cnm))
                {
                    jComboBox3.setSelectedIndex(i);
                    break;
                }//IF
                
            }//For
            s1=rs.getString("subjectName") ;
            String snm="";
            
                for(int i=0;i<jComboBox4.getItemCount() ; i++ )
               {
                
                snm =jComboBox4.getItemAt(i).toString();
                
                if(s1.equals(snm))
                {
                    jComboBox4.setSelectedIndex(i);
                    break;
                }//IF
                
            }//For
                      s1 = rs.getString("edition");
            
            if(s1.equals("1st"))
                jRadioButton1.setSelected(true);
            else if(s1.equals("2nd"))
                jRadioButton2.setSelected(true);
            else 
                jRadioButton3.setSelected(true);
             }//try
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex);
        }//catch
    }//func
      
    public AddBook(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
     
        try
        {
            Statement st=StockApp.con.createStatement();
            ResultSet rs=st.executeQuery("Select * from authors");
            int x;
            while (rs.next())
            {
                x=rs.getInt("authorId");
                authorIDS.add(x);
                jComboBox1.addItem(rs.getString("firstName"));

            }//while
            rs.close();
            st.close();
         }//try
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex);
        }//catch
    
    try
    {
        Statement  st=StockApp.con.createStatement();
        ResultSet  rs=st.executeQuery("Select * from publishers");
        int y;
        while(rs.next())
        {
            y=rs.getInt("publisherId");
            publisherIDS.add(y);
            jComboBox2.addItem(rs.getString("publisherName"));
            
        }//while
        
        rs.close();
        st.close();
    }//try
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(rootPane, ex);
               
    }//catch
    
    
    try
    {
        Statement  st=StockApp.con.createStatement();
        ResultSet  rs=st.executeQuery("Select * from Category");
        int y;
        while(rs.next())
        {
            y=rs.getInt("categoryId");
            categoryIDS.add(y);
            jComboBox3.addItem(rs.getString("categoryName"));
            
        }//while
        
        rs.close();
        st.close();
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(rootPane, ex);
               
    }//catch
    
    }//constructor 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DETAILS");

        jLabel1.setText("Book Name");

        jLabel2.setText("Author");

        jLabel3.setText("Publisher");

        jLabel4.setText("Category");

        jLabel5.setText("Subject");

        jLabel6.setText("Edition");

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("1st");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("2nd");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("3rd");

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
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
             this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try
         {
              if(bookId==0)
              {
             
             PreparedStatement ps=StockApp.con.prepareStatement("Insert into Books values(?,?,?,?,?)");
             ps.setString(1, jTextField1.getText());
             
             int i=jComboBox1.getSelectedIndex();
             int aid=authorIDS.get(i);
             ps.setInt(2,aid);
             
             int p=jComboBox2.getSelectedIndex();
             int pid=publisherIDS.get(p);
             ps.setInt(3,pid);
            
             int s=jComboBox4.getSelectedIndex();
             int sid=subjectIDS.get(s);
             ps.setInt(4,sid);
             
             if(jRadioButton1.isSelected())
             ps.setString(5, "1st");
             else if(jRadioButton2.isSelected())
                 ps.setString(5,"2nd");
             else if(jRadioButton3.isSelected())
                 ps.setString(5, "3rd");
             ps.execute();
             JOptionPane.showMessageDialog(rootPane, "Record saved");
             jTextField1.setText("");
            
              }//if
              else
              {
            PreparedStatement ps=StockApp.con.prepareStatement("Update Books set bookName=?,authorId=?,publisherid=?,subjectId=?,edition=? where bookId=?");
             ps.setString(1, jTextField1.getText());
             
             int i=jComboBox1.getSelectedIndex();
             int aid=authorIDS.get(i);
             ps.setInt(2,aid);
             
             int p=jComboBox2.getSelectedIndex();
             int pid=publisherIDS.get(p);
             ps.setInt(3,pid);
            
             int s=jComboBox4.getSelectedIndex();
             int sid=subjectIDS.get(s);
             ps.setInt(4,sid);
             
             if(jRadioButton1.isSelected())
             ps.setString(5, "1st");
             else if(jRadioButton2.isSelected())
                 ps.setString(5,"2nd");
             else if(jRadioButton3.isSelected())
                 ps.setString(5, "3rd");
             ps.setInt(6,bookId);
             ps.execute();
             JOptionPane.showMessageDialog(rootPane, "Record Updated");
             jTextField1.setText("");
             
              }//else
                  
            
         }//try
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(rootPane, ex);
         }//catch
                
            
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed

        try{
            int categoryid = categoryIDS.get(jComboBox3.getSelectedIndex() );
            Statement st=StockApp.con.createStatement();
            ResultSet rs=st.executeQuery("Select * from subjects where categoryid="+ categoryid);
            int z;
            subjectIDS.clear();
            jComboBox4.removeAllItems();
            while(rs.next())
            {
                z=rs.getInt("subjectId");
                subjectIDS.add(z);
                jComboBox4.addItem(rs.getString("subjectName"));

            }//while

            rs.close();
            st.close();

        }//try
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex);
        }//catch

    }//GEN-LAST:event_jComboBox3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
