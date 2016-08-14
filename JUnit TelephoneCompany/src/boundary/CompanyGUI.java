package boundary;

import control.PhoneControl;
import control.PhoneControl;
import entity.PhoneCall_Calculator;

/**
 *
 * @author Simon
 */
public class CompanyGUI extends javax.swing.JFrame {

    private PhoneControl control;

    public CompanyGUI() {
        initComponents();
        control = new PhoneControl();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        textFieldTime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        helpLabel = new javax.swing.JLabel();
        textFieldDuration = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        buttonRandomCall = new javax.swing.JButton();
        textFieldRandomTime = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textFieldRandomDur = new javax.swing.JTextField();
        buttonCalculateCall = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaOutput = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));

        jPanel1.setLayout(null);
        jPanel1.add(textFieldTime);
        textFieldTime.setBounds(10, 240, 50, 30);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("PPP ™");
        jLabel2.setToolTipText("Pelo Phone Phun");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 6, 56, 24);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 190, 210, 10);

        helpLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        helpLabel.setForeground(java.awt.Color.red);
        jPanel1.add(helpLabel);
        helpLabel.setBounds(10, 50, 410, 20);
        jPanel1.add(textFieldDuration);
        textFieldDuration.setBounds(130, 240, 50, 30);

        jLabel3.setFont(new java.awt.Font("Californian FB", 0, 12)); // NOI18N
        jLabel3.setText("Call duration (mm):");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(130, 220, 110, 15);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(10, 41, 410, 10);

        jLabel5.setFont(new java.awt.Font("Californian FB", 0, 16)); // NOI18N
        jLabel5.setText("Rate calculator for phone calls:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(83, 10, 188, 20);

        jLabel6.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel6.setText("Create a random call:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 100, 130, 17);

        jLabel7.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel7.setText("Make you own call:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 200, 120, 17);

        jLabel8.setFont(new java.awt.Font("Californian FB", 0, 12)); // NOI18N
        jLabel8.setText("Start time (HHmm):");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 220, 110, 15);

        buttonRandomCall.setLabel("Random");
        buttonRandomCall.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonRandomCallActionPerformed(evt);
            }
        });
        jPanel1.add(buttonRandomCall);
        buttonRandomCall.setBounds(140, 100, 80, 23);

        textFieldRandomTime.setEditable(false);
        textFieldRandomTime.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel1.add(textFieldRandomTime);
        textFieldRandomTime.setBounds(10, 150, 50, 30);

        jLabel9.setFont(new java.awt.Font("Californian FB", 0, 12)); // NOI18N
        jLabel9.setText("Start time (HHmm):");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 130, 110, 15);

        jLabel10.setFont(new java.awt.Font("Californian FB", 0, 12)); // NOI18N
        jLabel10.setText("Call duration (mm):");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(130, 130, 110, 15);

        textFieldRandomDur.setEditable(false);
        textFieldRandomDur.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel1.add(textFieldRandomDur);
        textFieldRandomDur.setBounds(130, 150, 50, 30);

        buttonCalculateCall.setText("Calculate Call");
        buttonCalculateCall.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonCalculateCallActionPerformed(evt);
            }
        });
        jPanel1.add(buttonCalculateCall);
        buttonCalculateCall.setBounds(240, 260, 180, 23);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextAreaOutput.setColumns(20);
        jTextAreaOutput.setLineWrap(true);
        jTextAreaOutput.setRows(5);
        jScrollPane2.setViewportView(jTextAreaOutput);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(240, 100, 180, 150);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCalculateCallActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonCalculateCallActionPerformed
    {//GEN-HEADEREND:event_buttonCalculateCallActionPerformed
        helpLabel.setText("");
        //Getting information out of the GUI:
        String startTime = textFieldTime.getText();
        String duration = textFieldDuration.getText();

        //Validating information:
        String testResult = control.validateUserInfo(startTime, duration); //Return either "OK" or an error message for the user
        if( testResult.equals( control.OK ) )
        {
            jTextAreaOutput.setText( control.getCalculatedCall(startTime, duration) );
        }
        else{  //User entered the wrong information and we are now notifying him:
              helpLabel.setText(testResult); 
        }
        
    }//GEN-LAST:event_buttonCalculateCallActionPerformed

    private void buttonRandomCallActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonRandomCallActionPerformed
    {//GEN-HEADEREND:event_buttonRandomCallActionPerformed
        textFieldRandomTime.setText( control.getRandomStartTime() );
        textFieldRandomDur.setText(  control.getRandomDuration()  );
        
        textFieldTime.setText( control.getRandomStartTime() );
        textFieldDuration.setText(  control.getRandomDuration()  );
    }//GEN-LAST:event_buttonRandomCallActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(CompanyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompanyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompanyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompanyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompanyGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCalculateCall;
    private javax.swing.JButton buttonRandomCall;
    private javax.swing.JLabel helpLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaOutput;
    private javax.swing.JTextField textFieldDuration;
    private javax.swing.JTextField textFieldRandomDur;
    private javax.swing.JTextField textFieldRandomTime;
    private javax.swing.JTextField textFieldTime;
    // End of variables declaration//GEN-END:variables
}
