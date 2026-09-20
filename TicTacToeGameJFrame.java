package puzzlegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGameJFrame extends JFrame {

    private static final int SIZE = 3; // 3x3 grid
    private char[][] board;
    private JButton[][] buttons;
    private char currentPlayer;
    private String playerXName;
    private String playerOName;

    public TicTacToeGameJFrame() {
        board = new char[SIZE][SIZE]; // Initializes the 2D array board to represent the Tic Tac Toe board
        // SIZE is a variable that specifies the dimensions of the board 
        // The board will store characters to keep track of the game state
        buttons = new JButton[SIZE][SIZE]; //Initializes a 2D array of JButton objects to represent the buttons displayed on the GUI
        //Each button corresponds to a cell on the Tic Tac Toe board and is clickable by the players
        currentPlayer = 'X';
        initializePlayerNames();
        initializeBoard();
        initializeGUI();
    }

    private void initializePlayerNames() {
        JTextField playerXField = new JTextField(10);
        JTextField playerOField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter name for Player X: "));
        panel.add(playerXField);
        panel.add(Box.createHorizontalStrut(15)); // Spacer
        panel.add(new JLabel("Enter name for Player O: "));
        panel.add(playerOField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Player Names", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            playerXName = playerXField.getText().trim();
            playerOName = playerOField.getText().trim();

            if (playerXName.isEmpty()) {
                playerXName = "Player X";
            }

            if (playerOName.isEmpty()) {
                playerOName = "Player O";
            }
        } else {
            playerXName = "Player X";
            playerOName = "Player O";
        }
    }
    
    private void initializeBoard() { //DMethod named initializeBoard to set up the initial state of the game board
        for (int row = 0; row < SIZE; row++) { //Iterates over each row of the 2D array board
            for (int col = 0; col < SIZE; col++) { //Iterates over each column within the current row
                board[row][col] = ' '; //Sets the value of the cell at position in the board array to a blank space 
            }
        }
    }

    private void initializeGUI() {
        setTitle("Tic Tac Toe Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE));

        for (int row = 0; row < SIZE; row++) { //Iterates over each row 
            for (int col = 0; col < SIZE; col++) { //Iterates over each column within the current row
                JButton button = new JButton(" "); //Creates a new JButton object
                button.setFont(new Font("Arial", Font.BOLD, 24));
                button.addActionListener(new ButtonClickListener(row, col)); //Adds an ActionListener to the button, enabling it to respond to clicks
                buttons[row][col] = button; //Stores the created button in the buttons 2D array at position
                add(button); //Adds the button to the GUI 
            }
        }

        setSize(400, 400);
        setVisible(true);
    }

    private boolean checkWin(char player) {
        // Check rows and columns
        for (int i = 0; i < SIZE; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void updateButtons() { //synchronizes the text on the GUI buttons with the current state of the board
        for (int row = 0; row < SIZE; row++) { 
            for (int col = 0; col < SIZE; col++) { 
                buttons[row][col].setText(String.valueOf(board[row][col])); //updates the text at the specfic position
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) { //Handles the button click event
            if (board[row][col] == ' ') { //Checks if the corresponding cell on the board is empty
                board[row][col] = currentPlayer; //Updates the board array at the clicked position with the symbol of the current player 
                updateButtons(); //Updates the GUI buttons to reflect the current state of the board

                if (checkWin(currentPlayer)) { //Checks if the currentPlayer has won the game using the checkWin method
                    String winnerName = currentPlayer == 'X' ? playerXName : playerOName;
                    JOptionPane.showMessageDialog(TicTacToeGameJFrame.this, winnerName + " wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    resetGame();
                } else if (isBoardFull()) {
                    JOptionPane.showMessageDialog(TicTacToeGameJFrame.this, "It's a draw!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    resetGame();
                } else { //Alternates the turn between players
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                JOptionPane.showMessageDialog(TicTacToeGameJFrame.this, "Invalid move!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void resetGame() { //resets the game
        initializeBoard(); // makes everything blank
        updateButtons();
        currentPlayer = 'X';
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
