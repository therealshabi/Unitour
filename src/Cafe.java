/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Font;
import java.util.*;
/**
 *
 * @author SHAHBAZ HUSSAIN
 */
public class Cafe extends javax.swing.JFrame{

    /**
     * Creates new form FirstFloor
     */
    public Cafe() {
        initComponents();
        jLabel8.setVisible(false);
    }
    
    // CODE FOR CAFE STARTS
    
    String item;
    int price;
    int quantity;
    double user_rating;
    int n=20;
    
    
    public void add(String a,int b,int c,double d)
    {
        item=a;
        price=b;
        quantity=c;
        user_rating=d;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 150, 210));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton1.setText("Maximum Quantity");
        jRadioButton1.setOpaque(false);
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 190, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("<html>\n<body>\n<pre>\nItem(s)        Quantity       Price\n</pre>\n</body>\n</html>");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 400, 30));
        jLabel8.getAccessibleContext().setAccessibleName("<html>\n<body>\n<pre>\nItem(s)        Quantity      Price\n</pre>\n</body>\n</html>");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton2.setText("Based On Higher User Ratings with Max Quantity");
        jRadioButton2.setOpaque(false);
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, 360, -1));

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 650, 90, 30));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 140, 210));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("                ANNAPURNA CAFE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 570, 50));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton3.setText("Higher User Rating");
        jRadioButton3.setOpaque(false);
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, -1, -1));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 150, 210));

        jButton3.setText("NEXT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 650, 90, 30));

        jButton1.setText("Find");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, 70, -1));

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 510, 420, 120));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CAFE MENU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Mongolian Baiti", 1, 24))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        jLabel2.setText("<html>\n<body>\n<pre>\nSamosa\nMatar Kulcha\nPao Bhaji\nChhole Bhature\nPaani Puri\nGup-Chup Chaat\nSamosa Chaat\nBhel Puri\nPapri Chaat\nDahi Bhalla\nBhalla Papri\nRaj Kachori\nPaneer Subji \nRajma Masala\nChana Masala\nDal Makhani             \nRing Potato              \nFrench Fries             \nVeg. Cheese Burger \nGrilled Sandwich\n</pre>\n\n\n</body>\n</html>");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("<html>\n<body>\n<pre>\n  12\n 105\n 120\n 135\n  25\n  90\n  65\n  55\n 100\n 100\n 105\n 110\n 170\n 155\n 155\n 140\n  60\n  50\n  90\n  70\n</pre>\n</body>\n</html>");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel6.setText("Items                                                                          Rate");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(287, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 76, 431, 910));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("What is Your Budget ? ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 110, 184, 51));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 123, 167, 28));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Rs.");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 123, 31, 24));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/food.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -63, 960, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public int getPrice()
     {
         return price;
     }
     
     public int getQuantity()
     {
         return quantity;
     }
     
     public String getItem()
     {
         return item;
     }
     
     public double getRating()
     {
         return user_rating;
     }
     
     public int min(int a,int b)
     {
      if(a<b)
        return a;
      else return b;
     }
     
     public double max(double a,double b)
     {
      if(a>b)
        return a;
      else return b;
     }
    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Cafe obj[]=new Cafe[n];
        int i;
        for(i=0;i<n;i++)
            obj[i]=new Cafe();

        jTextArea1.setText("");
        
        obj[0].add("Samosa",12,4,2);
        obj[1].add("Matar Kulcha",105,5,4);
        obj[2].add("Pao Bhaji",120,20,4.5);
        obj[3].add("Chhole Bhature",135,8,3.5);
        obj[4].add("Paani Puri",25,9,5);
        obj[5].add("Gup-Chup Chaat",90,2,1);
        obj[6].add("Samosa Chaat",65,10,2);
        obj[7].add("Bhel Puri",55,12,4.5);
        obj[8].add("Papri Chaat",100,8,3.7);
        obj[9].add("Dahi Bhalla",100,8,4.2);
        obj[10].add("Bhalla Papri",105,14,4.7);
        obj[11].add("Raj Kachori",110,18,4.8);
        obj[12].add("Paneer Subji",170,5,3.9);
        obj[13].add("Rajma Masala",155,2,4.6);
        obj[14].add("Chana Masala",155,1,5);
        obj[15].add("Dal Makhani",140,4,3.9);
        obj[16].add("Ring Potato",60,4,3.4);
        obj[17].add("French Fries",50,6,4.2);
        obj[18].add("Veg. Cheese Burger",90,5,4.7);
        obj[19].add("Grilled Sandwich",70,10,4.9);
        
       
       if(jRadioButton1.isSelected())
       {
          jTextArea1.setText("");
          jTextArea2.setText("");
          jTextArea3.setText("");
          jTextArea4.setText("");          
          ArrayList<Cafe> list = new ArrayList(Arrays.asList(obj));          

       Collections.sort(list, new Comparator<Cafe>(){
       public int compare(Cafe o1, Cafe o2)
       {
          return Integer.compare(o1.getPrice(), o2.getPrice());
       }
       });
       
       int quantity=0;
       int quan=0;
       int budget=Integer.parseInt(jTextField1.getText());
       if(budget<48)
       {
           jLabel8.setVisible(false);
           jTextArea4.setText("\n\nNo Items are available as per your Budget");
       }
       else
       {
       Iterator<Cafe> itr = list.iterator();
       jLabel8.setVisible(true);
       while(itr.hasNext())
       {
          Cafe temp = itr.next();
          if(temp.getPrice()>budget)
          {
              continue;
          }
          quan=min(temp.getQuantity(),(budget/temp.getPrice()));
          budget=budget-(temp.getPrice()*quan);
          quantity+=quan;
          jTextArea1.append(temp.getItem()+"\n");
          jTextArea2.append("  "+quan+"\n");
          jTextArea3.append("  "+temp.getPrice()*quan+"\n");
       }
       
       if(budget>=0)
       {
           jTextArea4.append("\n\nRemaining Money = Rs. "+budget+"\n");
       }
       
        jTextArea4.append("Maximum Quantity as per your Budget is : "+quantity);
       } 
       
       /*for(i=0;i<20;i++)
           System.out.println(obj[i].getPrice());*/
        
       }
       
    else if(jRadioButton2.isSelected())
       {
          jTextArea1.setText("");
          jTextArea2.setText("");
          jTextArea3.setText("");
          jTextArea4.setText("");
          ArrayList<Cafe> list = new ArrayList(Arrays.asList(obj));          

       Collections.sort(list, new Comparator<Cafe>(){
       public int compare(Cafe o1, Cafe o2)
       {
          return Double.compare(o2.getRating(), o1.getRating());
       }
       });
       
       int quantity=0;
       int quan=0;
       int budget=Integer.parseInt(jTextField1.getText());
       if(budget<48)
       {
           jLabel8.setVisible(false);
           jTextArea4.setText("\n\nNo Items are available as per your Budget");
       }
       else
       {
       Iterator<Cafe> itr = list.iterator();
       jLabel8.setVisible(true);
       while(itr.hasNext())
       {
          Cafe temp = itr.next();
          if(temp.getPrice()>budget)
          {
              continue;
          }
          quan=min(temp.getQuantity(),(budget/temp.getPrice()));
          budget=budget-(temp.getPrice()*quan);
          quantity+=quan;
          jTextArea1.append(temp.getItem()+"\n");
          jTextArea2.append("  "+quan+"\n");
          jTextArea3.append("  "+temp.getPrice()*quan+"\n");
       }
       
       if(budget>=0)
       {
           jTextArea4.append("\n\nRemaining Money = Rs. "+budget+"\n");
       }
       
        jTextArea4.append("Enjoy Tasty Food with Maximum Quantity as per your Budget : "+quantity);
       } 
       }
       
       else if(jRadioButton3.isSelected())
       {
          jTextArea1.setText("");
          jTextArea2.setText("");
          jTextArea3.setText("");
          jTextArea4.setText("");
          ArrayList<Cafe> list = new ArrayList(Arrays.asList(obj));          

       Collections.sort(list, new Comparator<Cafe>(){
       public int compare(Cafe o1, Cafe o2)
       {
          return Double.compare(o2.getRating(), o1.getRating());
       }
       });
       
       int quan=0;
       int budget=Integer.parseInt(jTextField1.getText());
       if(budget<48)
       {
           jLabel8.setVisible(false);
           jTextArea4.setText("\n\nNo Items are available as per your Budget");
       }
       else
       {
       Iterator<Cafe> itr = list.iterator();
       jLabel8.setVisible(true);
       while(itr.hasNext())
       {
          Cafe temp = itr.next();
          if(temp.getPrice()>budget)
          {
              continue;
          }
          quan=1;
          budget=budget-(temp.getPrice()*quan);
          jTextArea1.append(temp.getItem()+"\n");
          jTextArea2.append("  "+quan+"\n");
          jTextArea3.append("  "+temp.getPrice()+"\n");
       }
       
       if(budget>=0)
       {
           jTextArea4.append("\n\nRemaining Money = Rs. "+budget+"\n");
       }
       
        jTextArea4.append("Enjoy Tasty Food as per your Budget! :)");
       } 
       }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Map().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Last().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed
      
  
       

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
            java.util.logging.Logger.getLogger(Cafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cafe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}