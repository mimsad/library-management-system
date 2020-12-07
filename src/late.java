
import static java.lang.Math.abs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public final class late extends javax.swing.JFrame {
Connection conn;
//Connection connn;
ResultSet rs;
PreparedStatement pst;
ResultSet rss;
PreparedStatement pstt;
ResultSet rs1;
PreparedStatement pst1;

    /**
     * Creates new form late
     */
     public late() {
        super("late");
        initComponents();
        conn=javaconnect.ConnecrDb();
        del();
       jT2();
       
    }
     
     public void del(){
         
            String sql="delete from Late";
           try {
               pst=conn.prepareStatement(sql);
            pst.execute();
           }catch(Exception e){
               
           }
     }

     
     
     
      public void jT2(){
        try{
             String sql="select * from Issue";
        
         try{
            pst=conn.prepareStatement(sql);
           
            rs=pst.executeQuery();
             while(rs.next()){
                
               String add1=rs.getString("date_and_time");
               String sss1 = add1;
             //  System.out.println("sss = " + sss1);
               Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat();
String sss2 = sdf.format(date);
char ch1 = sss1.charAt(2);
char ch2 = sss2.charAt(2);
String s1 = "", s2 = "";
s1 += ch1;
s2 += ch2;
//System.out.println("S1 = "+ s1);
//System.out.println("S2 = "+ s2);
int num1 = Integer.parseInt(s1);
int num2 = Integer.parseInt(s2);
int ans = abs(num1 - num2);


if(ans >= 2){
    String k = sss1;
   // System.out.println("k = " + k);
    // String sq="select Book_Id, Book_Name, Student_Id, User_Name, date_and_time from Issue where date_and_time = 'k'";   
  
    
    
         String m1 = null, m2 = null, m3 = null, m4 = null, m5 = null, m6 = null, m7 = null, m8 = null, m9 = null, m10 = null, m11 = null, m12 = null;
         String sq="select * from Issue where date_and_time = ?";
         try{
             
           pstt=conn.prepareStatement(sq);
            pstt.setString(1, k);
            rss=pstt.executeQuery();
               if(rss.next()){
                   m1=rss.getString("Book_Id");
               m2=rss.getString("Book_Name");          
                m3=rss.getString("Writter_Name");           
                m4=rss.getString("Edition");
                m5=rss.getString("Student_Id");
                m6=rss.getString("User_Name");
                m7=rss.getString("Intake");
                m8=rss.getString("Section");
                m9=rss.getString("Department");
                m10=rss.getString("gmail_id");
                m11 =rss.getString("mobile_number");
               m12=rss.getString("date_and_time");
               rss.close();
               pstt.close();
               }else{
                   
               }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
            rss.close();
            pstt.close();
        }catch(Exception e){
            
        } }
         
           try{
         String sqlll ="Insert into Late (Book_Id,Book_Name,Writter_Name,Edition,Student_Id,User_Name,Intake,Section,Department,gmail_id,mobile_number,date_and_time) values (?,?,?,?,?,?,?,?,?,?,?,?)";
                   
       pst1=conn.prepareStatement(sqlll);
       pst1.setString(1, m1);
        pst1.setString(2, m2);
         pst1.setString(3, m3);
          pst1.setString(4, m4);
           pst1.setString(5, m5);
            pst1.setString(6, m6);
             pst1.setString(7, m7);
              pst1.setString(8, m8);
               pst1.setString(9, m9);
                pst1.setString(10, m10);
                 pst1.setString(11, m11);
                  pst1.setString(12, m12);
        pst1.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
     
    
}

               
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
            rs.close();
            pst.close();
        }catch(Exception e){
            
        } }
         
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        try{
            String sql="select Book_Id, Book_Name, Student_Id, User_Name, Intake, Section, date_and_time from Late";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 7), "Late Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 24), new java.awt.Color(255, 51, 51))); // NOI18N

        jTable2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1049, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\for project\\back-icon.png")); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1281, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addGap(64, 64, 64)))
                    .addGap(14, 14, 14)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(139, 139, 139)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton1)
                    .addContainerGap(139, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(1299, 569));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Home ob=new Home();
        ob.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(late.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(late.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(late.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(late.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new late().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

   
}
