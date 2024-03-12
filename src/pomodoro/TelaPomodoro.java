package pomodoro;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

public class TelaPomodoro extends javax.swing.JFrame {
    private static final int TIMER_DELAY = 1000;
    private Timer timer;
    private int totSeg, minutos, segundos;
    private boolean tocando=true;
    private int tempo;
    
    
    public TelaPomodoro() {
        initComponents();
        estadoBotao();
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSeg = new javax.swing.JLabel();
        btnComecar = new javax.swing.JButton();
        btnMinutos = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        btnPause = new javax.swing.JButton();
        btnCanc = new javax.swing.JButton();
        lblMin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnPomodoro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cronometro");
        setBackground(new java.awt.Color(204, 204, 255));

        lblSeg.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblSeg.setText("0");

        btnComecar.setText("Começar");
        btnComecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComecarActionPerformed(evt);
            }
        });

        btnMinutos.setModel(new javax.swing.SpinnerNumberModel(1, 1, 60, 1));

        jLabel4.setText("Minutos");

        btnPause.setText("Pause");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnCanc.setText("Cancelar");
        btnCanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancActionPerformed(evt);
            }
        });

        lblMin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblMin.setText("0");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText(":");

        btnPomodoro.setText("Pomodoro");
        btnPomodoro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPomodoroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSeg)
                .addGap(123, 123, 123))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPomodoro, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnComecar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCanc)
                                .addGap(109, 109, 109))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnPomodoro))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeg)
                    .addComponent(lblMin)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComecar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCanc)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComecarActionPerformed
        // TODO add your handling code here:
        getContentPane().setBackground(Color.green);
        estadoBotao();
        try {
                            playSound("time-passing-sound-effect-fast-clock-108403.wav");
                        } catch (LineUnavailableException ex) {
                            Logger.getLogger(TelaPomodoro.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPomodoro.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (UnsupportedAudioFileException ex) {
                            Logger.getLogger(TelaPomodoro.class.getName()).log(Level.SEVERE, null, ex);
                        }
        minutos = Integer.parseInt(btnMinutos.getValue().toString());     
        totSeg = minutos * 60;
        segundos = 60;
        minutos -=1;
        lblMin.setText(Integer.toString(minutos));
        timer = new Timer(TIMER_DELAY, e -> {
                contSeg();
                lblSeg.setText(Integer.toString(segundos));
                if(segundos==0){
                    minutos--;
                    segundos=60;
                    if(minutos==-1){
                        lblMin.setText("0");
                        segundos = 0;
                    }else{
                        lblMin.setText(Integer.toString(minutos));
                    }
                }
                if(totSeg == 0){
                    getContentPane().setBackground(Color.LIGHT_GRAY);
                    timer.stop();
                    estadoBotao();
                    //Tocar som de alarme chamando a função playsound
                    try {
                            playSound("clock-alarm-8761.wav");
                        } catch (LineUnavailableException ex) {
                            Logger.getLogger(TelaPomodoro.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPomodoro.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (UnsupportedAudioFileException ex) {
                            Logger.getLogger(TelaPomodoro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
        });
        timer.start();
        tocando = true;
    }//GEN-LAST:event_btnComecarActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        // TODO add your handling code here:
        if(tocando){
            timer.stop();
            tocando = false;
            getContentPane().setBackground(Color.cyan);
        }else{
            timer.start();
            tocando = true;
            getContentPane().setBackground(Color.green);
        }
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnCancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancActionPerformed
        // TODO add your handling code here:
        getContentPane().setBackground(Color.red);
        totSeg = 0;
        timer.restart();
        timer.stop();
        tocando = true;
        estadoBotao();
    }//GEN-LAST:event_btnCancActionPerformed

    private void btnPomodoroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPomodoroActionPerformed
        // TODO add your handling code here:
        btnMinutos.setValue(25);
    }//GEN-LAST:event_btnPomodoroActionPerformed
    
    public int contSeg(){
        totSeg--;
        return (segundos--);
    }
    
    private void estadoBotao(){
        tocando = !tocando;
        btnComecar.setEnabled(!tocando);
        btnPomodoro.setEnabled(!tocando);
        btnPause.setEnabled(tocando);
        btnCanc.setEnabled(tocando);
    }
    
    public void playSound(String soundFile) throws MalformedURLException, LineUnavailableException, IOException, UnsupportedAudioFileException {
        File f = new File("./" + soundFile);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }


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
            java.util.logging.Logger.getLogger(TelaPomodoro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPomodoro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPomodoro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPomodoro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPomodoro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCanc;
    private javax.swing.JButton btnComecar;
    private javax.swing.JSpinner btnMinutos;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPomodoro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblSeg;
    // End of variables declaration//GEN-END:variables
}
