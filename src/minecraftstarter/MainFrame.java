package minecraftstarter;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Crimson
 */
public class MainFrame extends javax.swing.JFrame {
    
    private boolean def;
    private String S = SystemUtils.FILE_SEPARATOR;
    private String Q = "\"";
    private String ext = ".exe";
    private String patch = SystemUtils.getJavaHome().getAbsolutePath();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        if (SystemUtils.IS_OS_UNIX) {
            osType.setSelectedIndex(1);
            javaVersion.setEnabled(false);
            osArch.setEnabled(false);
        }
        if (SystemUtils.IS_JAVA_1_6) {
            javaVersion.setSelectedIndex(0);
        }
        if (SystemUtils.IS_JAVA_1_7) {
            javaVersion.setSelectedIndex(1);
        }
        if (SystemUtils.IS_JAVA_1_8) {
            javaVersion.setSelectedIndex(2);
        }
        if (SystemUtils.OS_ARCH.contains("64")) {
            osArch.setSelectedIndex(1);
        }
        
        nameField.requestFocusInWindow();
        def = true;
        
    }
    
    public void launch() {
        String java=Q+getJavaHome()+S+"java"+ext+Q;
        String data=buildMinecraftPatch();

        String exec = java+" -Xms"+xms.getText().trim()+"m -Xmx"+xmx.getText().trim()+"m -cp "+Q
                + data+S+"bin"+S+"minecraft.jar;"
                + data+S+"bin"+S+"lwjgl.jar;"
                + data+S+"bin"+S+"lwjgl_util.jar;"
                + data+S+"bin"+S+"jinput.jar;"
                + Q
                + " -Djava.library.path="+Q+data+S+"bin"+S+"natives"+Q
                + " net.minecraft.client.Minecraft "+nameField.getText().trim();
        
        System.out.println(exec);
        try {
            Runtime.getRuntime().exec(exec);
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
        }
        System.exit(1);
        
    }
    
    public String getJavaHome() {
        if (def) { return SystemUtils.getJavaHome().getAbsolutePath()+S+"bin"; } else {
            return buildPatch();
        }
    }
    
    public String buildPatch() {
        String p = System.getenv("ProgramFiles")+(((SystemUtils.OS_ARCH.contains("64")) && osArch.getSelectedIndex()==0)?" (x86)":"");
        String j = "Java"+S+"jre"+javaVersion.getSelectedItem().toString()+S+"bin";
        return p+S+j;
    }
    
    public String buildMinecraftPatch() {
        String dataFolder = System.getenv("APPDATA")+S+".minecraft";
        if (new File("bin").exists() && new File("lib").exists()) {
            dataFolder=MainFrame.class.getProtectionDomain().getCodeSource().toString();
        }
        return dataFolder;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        osArch = new javax.swing.JComboBox();
        nameField = new javax.swing.JTextField();
        javaVersion = new javax.swing.JComboBox();
        osType = new javax.swing.JComboBox();
        launchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        xmx = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        xms = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple Minecraft Launcher");
        setType(java.awt.Window.Type.UTILITY);

        osArch.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        osArch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "x32", "x64" }));
        osArch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                osArchItemStateChanged(evt);
            }
        });

        nameField.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameFieldKeyReleased(evt);
            }
        });

        javaVersion.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        javaVersion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "6", "7", "8" }));
        javaVersion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                javaVersionItemStateChanged(evt);
            }
        });

        osType.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        osType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "WIN", "*NIX" }));
        osType.setEnabled(false);
        osType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                osTypeItemStateChanged(evt);
            }
        });

        launchButton.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        launchButton.setText("Launch");
        launchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        jLabel2.setText("JRE:");

        xmx.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        xmx.setText("1024");
        xmx.setMinimumSize(new java.awt.Dimension(30, 20));

        jLabel3.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        jLabel3.setText("-Xmx");

        xms.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        xms.setText("512");

        jLabel4.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        jLabel4.setText("-Xms");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(osType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(javaVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(osArch, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(launchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xms, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xmx, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(osArch)
                            .addComponent(javaVersion)
                            .addComponent(osType)))
                    .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(launchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(xmx, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(xms, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void osTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_osTypeItemStateChanged
        def=false;
    }//GEN-LAST:event_osTypeItemStateChanged

    private void javaVersionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_javaVersionItemStateChanged
        def=false;
    }//GEN-LAST:event_javaVersionItemStateChanged

    private void osArchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_osArchItemStateChanged
        def=false;
    }//GEN-LAST:event_osArchItemStateChanged

    private void launchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchButtonActionPerformed
        launch();
    }//GEN-LAST:event_launchButtonActionPerformed

    private void nameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyPressed

    }//GEN-LAST:event_nameFieldKeyPressed

    private void nameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyReleased
        if (evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) {
            launch();
        }
    }//GEN-LAST:event_nameFieldKeyReleased

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox javaVersion;
    private javax.swing.JButton launchButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JComboBox osArch;
    private javax.swing.JComboBox osType;
    private javax.swing.JTextField xms;
    private javax.swing.JTextField xmx;
    // End of variables declaration//GEN-END:variables
}
