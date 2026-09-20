package puzzlegame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class CardGameJFrame extends JFrame {
    private String card1 = "";
    private String card2 = "";
    private JButton firstButton;
    private JButton secondButton;
    private int tries = 0;
    private int pairsFound = 0;
    private int elapsedTime = 0;
    private Timer gameTimer;

    public CardGameJFrame() {
        initComponents(); // Initialize components first
        setTitle("Card Game");
        setSize(480, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Allow reopening
        setLayout(null);

        // Initialize game
        setupCardButtons();
        initializeTimer();

        // Hide end message and restart button initially
        restartButton.setVisible(false);
        restartButton.addActionListener(e -> restartGame());
    }

   private void setupCardButtons() {
    JButton[] buttons = {cardButtons1, cardButtons2, cardButtons3, cardButtons4, cardButtons5, cardButtons6,
            cardButtons7, cardButtons8, cardButtons9, cardButtons10, cardButtons11, cardButtons12};

    String[] cardNames = {"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F"};
    shuffleArray(cardNames);

    for (int i = 0; i < buttons.length; i++) {
        JButton button = buttons[i];
        String cardName = cardNames[i];
        button.putClientProperty("cardName", cardName);
        button.setText("?");
        button.setEnabled(true);
        button.setBackground(null); // Reset background
        button.setOpaque(true);
        button.setBorderPainted(true);
        button.addActionListener(e -> handleCardClick(cardName, button));
    }
}
   
    private void initializeTimer() { //
        elapsedTime = 0;
        timerLabel.setText("Time: 0 seconds");
        gameTimer = new Timer(1000, (ActionEvent e) -> {
            elapsedTime++;
            timerLabel.setText("Time: " + elapsedTime + " seconds");
        });
        gameTimer.start();
    }
   
    private void handleCardClick(String cardName, JButton button) { // when the cards are being clicked
        if (button.getText().equals("?")) {  
            // Prevent selecting more than two cards
            if (card1.isEmpty() && card2.isEmpty()) {  // no cards selected
                // First card selection
                card1 = cardName;
                firstButton = button;
                button.setText(cardName);
                button.setEnabled(false);
            } else if (!card1.isEmpty() && card2.isEmpty()) { // first card selected
                // Second card selection
                card2 = cardName;
                secondButton = button;
                button.setText(cardName);
                button.setEnabled(false);

                // Check for a match after a short delay
                Timer timer = new Timer(500, e -> { // give player time to see the card value
                    checkCards();
                    ((Timer) e.getSource()).stop();
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }
   
    private void checkCards() { // was a pair found
     if (card1.equals(card2)) { // Match found
            pairsFound++;
            display.setText("Match Found!");
            firstButton.setBackground(Color.GRAY);
            secondButton.setBackground(Color.GRAY);

            // Disable the matched buttons permanently
            firstButton.setEnabled(false);
            secondButton.setEnabled(false);
        } else { // No match
            display.setText("Not a Match");
            Timer hideTimer = new Timer(500, e -> {
                firstButton.setText("?");
                secondButton.setText("?");
                firstButton.setEnabled(true);
                secondButton.setEnabled(true);
            });
            hideTimer.setRepeats(false);
            hideTimer.start();
        }

        tries++;
        triesTracker.setText("Attempts Made: " + tries);
        pairsTracker.setText("Pairs Found: " + pairsFound + "/6");

        card1 = "";
        card2 = "";

        if (pairsFound == 6) {
            endGame();
        }
    }
   
     private void endGame() {
        gameTimer.stop();
        display.setText("Game Over!");
        restartButton.setVisible(true);
    }
     
   

     private void restartGame() {
         // Reset game state
         card1 = "";
         card2 = "";
         firstButton = null;
         secondButton = null;
         tries = 0;
         pairsFound = 0;
         elapsedTime = 0;

         // Update UI elements
         display.setText("Choose Card #1");
         triesTracker.setText("Attempts Made: 0");
         pairsTracker.setText("Pairs Found: 0/6");
         timerLabel.setText("Time: 0 seconds");
         restartButton.setVisible(false);

         // Reset card buttons
         setupCardButtons();

         if (gameTimer != null) {
             gameTimer.stop();
         }
         initializeTimer();
     }
     
    private void shuffleArray(String[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
                     

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardButtons1 = new javax.swing.JButton();
        cardButtons2 = new javax.swing.JButton();
        cardButtons3 = new javax.swing.JButton();
        cardButtons4 = new javax.swing.JButton();
        cardButtons5 = new javax.swing.JButton();
        cardButtons6 = new javax.swing.JButton();
        cardButtons7 = new javax.swing.JButton();
        cardButtons8 = new javax.swing.JButton();
        cardButtons9 = new javax.swing.JButton();
        cardButtons10 = new javax.swing.JButton();
        cardButtons11 = new javax.swing.JButton();
        cardButtons12 = new javax.swing.JButton();
        triesTracker = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        pairsTracker = new javax.swing.JLabel();
        display = new javax.swing.JLabel();
        restartButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cardButtons1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        cardButtons1.setText("?");
        cardButtons1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButtons1ActionPerformed(evt);
            }
        });

        cardButtons2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        cardButtons2.setText("?");
        cardButtons2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButtons2ActionPerformed(evt);
            }
        });

        cardButtons3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        cardButtons3.setText("?");
        cardButtons3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButtons3ActionPerformed(evt);
            }
        });

        cardButtons4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        cardButtons4.setText("?");
        cardButtons4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButtons4ActionPerformed(evt);
            }
        });

        cardButtons5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        cardButtons5.setText("?");
        cardButtons5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButtons5ActionPerformed(evt);
            }
        });

        cardButtons6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        cardButtons6.setText("?");
        cardButtons6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButtons6ActionPerformed(evt);
            }
        });

        cardButtons7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        cardButtons7.setText("?");
        cardButtons7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButtons7ActionPerformed(evt);
            }
        });

        cardButtons8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        cardButtons8.setText("?");
        cardButtons8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButtons8ActionPerformed(evt);
            }
        });

        cardButtons9.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        cardButtons9.setText("?");
        cardButtons9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButtons9ActionPerformed(evt);
            }
        });

        cardButtons10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        cardButtons10.setText("?");
        cardButtons10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButtons10ActionPerformed(evt);
            }
        });

        cardButtons11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        cardButtons11.setText("?");
        cardButtons11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButtons11ActionPerformed(evt);
            }
        });

        cardButtons12.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        cardButtons12.setText("?");
        cardButtons12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardButtons12ActionPerformed(evt);
            }
        });

        triesTracker.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        triesTracker.setText("Attempts made: 0");

        timerLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        timerLabel.setText("Time: 0 seconds");

        pairsTracker.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        pairsTracker.setText("Pairs found 0/6");

        display.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        display.setText("Choose card #1");

        restartButton.setText("Restart");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timerLabel)
                            .addComponent(triesTracker)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cardButtons9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cardButtons5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cardButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(restartButton)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cardButtons6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cardButtons7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cardButtons8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cardButtons10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cardButtons11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cardButtons12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cardButtons2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cardButtons3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(display))
                                .addGap(18, 18, 18)
                                .addComponent(cardButtons4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(pairsTracker)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(display)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(restartButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(triesTracker)
                    .addComponent(pairsTracker))
                .addGap(9, 9, 9)
                .addComponent(timerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButtons2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButtons3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButtons4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardButtons5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButtons6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButtons7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButtons8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardButtons9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButtons10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButtons11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardButtons12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cardButtons1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButtons1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardButtons1ActionPerformed

    private void cardButtons2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButtons2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardButtons2ActionPerformed

    private void cardButtons3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButtons3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardButtons3ActionPerformed

    private void cardButtons4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButtons4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardButtons4ActionPerformed

    private void cardButtons5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButtons5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardButtons5ActionPerformed

    private void cardButtons6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButtons6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardButtons6ActionPerformed

    private void cardButtons7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButtons7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardButtons7ActionPerformed

    private void cardButtons8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButtons8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardButtons8ActionPerformed

    private void cardButtons9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButtons9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardButtons9ActionPerformed

    private void cardButtons10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButtons10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardButtons10ActionPerformed

    private void cardButtons11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButtons11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardButtons11ActionPerformed

    private void cardButtons12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardButtons12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardButtons12ActionPerformed
 public class CardGame {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                CardGameJFrame frame = new CardGameJFrame();
                frame.setVisible(true);
            });
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cardButtons1;
    private javax.swing.JButton cardButtons10;
    private javax.swing.JButton cardButtons11;
    private javax.swing.JButton cardButtons12;
    private javax.swing.JButton cardButtons2;
    private javax.swing.JButton cardButtons3;
    private javax.swing.JButton cardButtons4;
    private javax.swing.JButton cardButtons5;
    private javax.swing.JButton cardButtons6;
    private javax.swing.JButton cardButtons7;
    private javax.swing.JButton cardButtons8;
    private javax.swing.JButton cardButtons9;
    private javax.swing.JLabel display;
    private javax.swing.JLabel pairsTracker;
    private javax.swing.JButton restartButton;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JLabel triesTracker;
    // End of variables declaration//GEN-END:variables

}
