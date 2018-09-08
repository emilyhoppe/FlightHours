/** **********
 *
 *      Class:         MainFrame.java
 *      Package:       view
 *      Date:          September, 2018
 *
 *      Course: UMUC CMSC 495 6381
 *      Group A Members: John Tamer, Jason Grimard, Demetrius Billups, & Emily Hoppe
 *
 *      Class Description:
 *
 *
 *********** */
package view;

public class MainFrame extends javax.swing.JFrame {

    //Returns mainPanel so cardLayout can be updated by user
    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new view.MainPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FHS Flight Hours System");
        setName("MainFrame"); // NOI18N
        setSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(mainPanel, gridBagConstraints);

        fileMenu.setText("File");

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        setSize(new java.awt.Dimension(966, 739));
        setLocationRelativeTo(null);
    }//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        // TODO add your handling code here:
        AboutView aboutView = new AboutView(this, true);
        aboutView.setVisible(true);

    }//GEN-LAST:event_aboutMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private view.MainPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables
}
