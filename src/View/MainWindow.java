/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jfugue.*;
//import org.jfugue.pattern.Pattern;
//import org.jfugue.player.Player;
//import org.jfugue.temporal.TemporalEvents;

/**
 *
 * @author valcanaia
 */
public class MainWindow extends javax.swing.JFrame {

    public static enum Volume {

        MUTE, LOW, MEDIUM, HIGH
    }

    private static boolean vol = false;
    public static final int VOLUME_DIFF_RATE = 500;
    public static final int VOLUME_START = 10200;
    public static final int VOLUME_MIN = 8000;
    public static final int VOLUME_MAX = 16383;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2,
                dim.height / 2 - this.getSize().height / 2);
        this.setTitle("TF2_TCP");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPlay = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taTextContent = new javax.swing.JTextArea();
        tfFilePath = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPlay.setText("Play text");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        taTextContent.setColumns(20);
        taTextContent.setRows(5);
        taTextContent.setText("this text area will show the content of the selected file\n");
        jScrollPane1.setViewportView(taTextContent);

        tfFilePath.setEditable(false);
        tfFilePath.setText("click here to select a file");
        tfFilePath.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfFilePathMouseClicked(evt);
            }
        });
        tfFilePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFilePathActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(57, 57, 57)
                        .addComponent(btnPlay))
                    .addComponent(tfFilePath)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlay)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPlayActionPerformed

    private void tfFilePathMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfFilePathMouseClicked
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt", "text");
        fc.setFileFilter(filter);
        switch (fc.showOpenDialog(null)) {
            case JFileChooser.CANCEL_OPTION: {
                // show msg? nah
                break;
            }
            case JFileChooser.APPROVE_OPTION: {
                File f = fc.getSelectedFile();
                String filePath = f.getName();
                if (filePath.endsWith(".txt")) {
                    BufferedReader in = null;
                    try {
                        taTextContent.setText(""); // a way to "clear" the initial message
                        tfFilePath.setText(f.getAbsolutePath());
                        in = new BufferedReader(new FileReader(f));
                        String line = in.readLine();
                        while (line != null) {
                            taTextContent.append(line + "\n");
                            line = in.readLine();
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE,
                                null, ex);
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE,
                                null, ex);
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } finally {
                        try {
                            in.close();
                        } catch (IOException ex) {
                            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE,
                                    null, ex);
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not a txt file!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
            case JFileChooser.ERROR_OPTION: {
                JOptionPane.showMessageDialog(null, "Error!  No file opened.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                break;
            }
            default: {
                System.out.println("not expected");
            }
        }
    }//GEN-LAST:event_tfFilePathMouseClicked

    private void tfFilePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFilePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFilePathActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Player player = new Player();
        String strValidChar = "ABCDEFG";
        Pattern pattern;
        String str = taTextContent.getText();
        for (int i = 0; i < str.length(); i++) {
            char c = Character.toUpperCase(str.charAt(i));
            if (strValidChar.indexOf(c) >= 0) {
                pattern = new Pattern(Character.toString(c));
                player.play(pattern);
                System.out.println("sim: " + c);
            }
            if (c == '!') {

            } else {
                System.out.println("nao: " + c);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /* TODO(pedro): 
         1 - Verify how to keep the last note played
         2 - Dont forget to search how to turn the volume up whenever a ! is read
         */
        Controller controller = new Controller();
        Player player = new Player();
        String digitValidChar = "0123456789";
        Pattern pattern;
        String str = taTextContent.getText();
        int volume = VOLUME_START;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // Se for um digito, verificar se eh par ou impar
            if (digitValidChar.indexOf(c) >= 0) {
                int isEven = (int) c;
                if (isEven % 2 == 0) { // se eh par
                    // Devemos aumentar uma oitava
                    pattern = new Pattern(Character.toString(c));
                    player.play(pattern);
                    System.out.println("sim: " + c);
                } else {
                    // devemos diminuir uma oitava
                    pattern = new Pattern(Character.toString(c));
                    player.play(pattern);
                    System.out.println("sim: " + c);
                }
            }
            c = Character.toUpperCase(c);
            switch (c){
                case '!':
                    System.out.println("Volume: " + volume);
                case '.':
                    System.out.println("Volume: " + volume);
                case '?':
                    volume += VOLUME_DIFF_RATE * 3;
                    if (volume > VOLUME_MAX) {
                        volume = VOLUME_MAX;
                    }
                    System.out.println("Volume: " + volume);
                    break;
                case ',':
                    System.out.println("Volume: " + volume);
                case ';':
                    System.out.println("Volume: " + volume);
                    volume -= VOLUME_DIFF_RATE * 3;
                    if (volume < VOLUME_MIN) {
                        volume = VOLUME_MIN;
                    }
                    System.out.println("Volume: " + volume);
                    break;
            }
            pattern = new Pattern(" X[Volume]=" + volume + " " + Character.toString(c));
            player.play(pattern);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taTextContent;
    private javax.swing.JTextField tfFilePath;
    // End of variables declaration//GEN-END:variables
}
