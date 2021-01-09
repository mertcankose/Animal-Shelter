
package animalshelter;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    DatabaseOperations databaseOperations = new DatabaseOperations();
  
    public Login() {
        initComponents();
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        registerLink = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        loginPasswordInput = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        loginUsernameInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(250, 120, 0, 0));
        setMinimumSize(new java.awt.Dimension(1000, 500));
        setPreferredSize(new java.awt.Dimension(1430, 830));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registerLink.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        registerLink.setForeground(new java.awt.Color(255, 255, 255));
        registerLink.setText("REGISTER");
        registerLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerLinkMouseClicked(evt);
            }
        });
        jPanel1.add(registerLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 600, 80, 30));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Don't have an account?");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 600, 160, 20));

        loginButton.setBackground(new java.awt.Color(51, 102, 0));
        loginButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("LOGIN");
        loginButton.setBorder(null);
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 510, 110, 40));

        loginPasswordInput.setFont(new java.awt.Font("Yu Gothic UI", 0, 15)); // NOI18N
        loginPasswordInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(loginPasswordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 350, 40));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel5.setText("PASSWORD");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, -1, -1));

        loginUsernameInput.setFont(new java.awt.Font("Yu Gothic UI", 0, 15)); // NOI18N
        loginUsernameInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(loginUsernameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 350, 40));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel3.setText("USERNAME");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 100, 20));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ANIMAL SHELTER LOGIN");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 280, 50));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pet.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -60, 1440, 1090));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        ShelterGui shelter = new ShelterGui();
        
        String username = loginUsernameInput.getText();
        String password = new String(loginPasswordInput.getPassword());
        
        if(username.equals("admin") && password.equals("admin")){
             Personnel personnel = new Personnel(username,true);
        }else{
            Personnel personnel = new Personnel(username,false);
        }
       
        
        boolean login_success = databaseOperations.login(username,password);
        
        if(login_success){
            shelter.setVisible(true);
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this,"There is no user that has this username or password. Please Register!");
        }
        
        /*
        ArrayList<User> user_list = ShelterGui.getUser_list();
        
        if(user_list.size() == 0){
            JOptionPane.showMessageDialog(this,"There is no user any!");
        }else{
            for(User user:user_list){
                if(user.getEmail().equals(username) && user.getPassoword().equals(password)){
                     shelter.setVisible(true);
                     this.setVisible(false);
                     return;
                }
            }
            JOptionPane.showMessageDialog(this,"There is no user that has this mail or password. Please Register!");
        }
        */
        
    
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerLinkMouseClicked
        Register register = new Register();
        
        register.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_registerLinkMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField loginPasswordInput;
    private javax.swing.JTextField loginUsernameInput;
    private javax.swing.JLabel registerLink;
    // End of variables declaration//GEN-END:variables
}
