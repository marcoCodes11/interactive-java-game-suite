package puzzlegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class MainJFrame extends JFrame {

    public MainJFrame() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        EightPuzzleGameButton = new javax.swing.JButton();
        FifthteenPuzzleGameButton = new javax.swing.JButton();
        TicTacToeGameButton = new javax.swing.JButton();
        CardGameButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Futura", 0, 30)); // NOI18N
        titleLabel.setText(" MINI GAMES!");
        titleLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        EightPuzzleGameButton.setBackground(new java.awt.Color(0, 255, 0));
        EightPuzzleGameButton.setFont(new java.awt.Font("Futura", 0, 16)); // NOI18N
        EightPuzzleGameButton.setText("8 Puzzle Game");
        EightPuzzleGameButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EightPuzzleGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EightPuzzleGameButtonActionPerformed(evt);
            }
        });

        FifthteenPuzzleGameButton.setBackground(new java.awt.Color(0, 255, 0));
        FifthteenPuzzleGameButton.setFont(new java.awt.Font("Futura", 0, 16)); // NOI18N
        FifthteenPuzzleGameButton.setText("15 Puzzle Game");
        FifthteenPuzzleGameButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        FifthteenPuzzleGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FifthteenPuzzleGameButtonActionPerformed(evt);
            }
        });

        TicTacToeGameButton.setBackground(new java.awt.Color(0, 255, 0));
        TicTacToeGameButton.setFont(new java.awt.Font("Futura", 0, 16)); // NOI18N
        TicTacToeGameButton.setText("Tic Tac Toe");
        TicTacToeGameButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TicTacToeGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TicTacToeGameButtonActionPerformed(evt);
            }
        });

        CardGameButton.setBackground(new java.awt.Color(0, 255, 0));
        CardGameButton.setFont(new java.awt.Font("Futura", 0, 16)); // NOI18N
        CardGameButton.setText("Card Game");
        CardGameButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CardGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardGameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(FifthteenPuzzleGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EightPuzzleGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TicTacToeGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CardGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EightPuzzleGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TicTacToeGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FifthteenPuzzleGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CardGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EightPuzzleGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EightPuzzleGameButtonActionPerformed
        // TODO add your handling code here:
        // Open the SevenPuzzleGameJFrame
        new EightPuzzleGameJFrame().setVisible(true);
    }//GEN-LAST:event_EightPuzzleGameButtonActionPerformed

    private void FifthteenPuzzleGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FifthteenPuzzleGameButtonActionPerformed
        // TODO add your handling code here:
        new FifthteenPuzzleGameJFrame().setVisible(true);
    }//GEN-LAST:event_FifthteenPuzzleGameButtonActionPerformed

    private void TicTacToeGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TicTacToeGameButtonActionPerformed
        // TODO add your handling code here:
        new TicTacToeGameJFrame().setVisible(true);
    }//GEN-LAST:event_TicTacToeGameButtonActionPerformed

    private void CardGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardGameButtonActionPerformed
        // TODO add your handling code here:
        new CardGameJFrame().setVisible(true);
    }//GEN-LAST:event_CardGameButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CardGameButton;
    private javax.swing.JButton EightPuzzleGameButton;
    private javax.swing.JButton FifthteenPuzzleGameButton;
    private javax.swing.JButton TicTacToeGameButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
            MainJFrame mainFrame = new MainJFrame();
            mainFrame.setVisible(true);
        });
    }
}