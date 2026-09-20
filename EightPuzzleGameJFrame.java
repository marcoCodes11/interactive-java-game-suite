package puzzlegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class EightPuzzleGameJFrame extends JFrame {

    private static final int SIZE = 3; // 3x3 grid for the board
    private static final int EMPTY = 0; //represents the blank tile
    private int[][] board; //A 2D array representing the tile layout
    private int emptyRow, emptyCol; // Track the position of the blank tile
    private JButton[][] buttons; //A 2D array of buttons corresponding to tiles

    public EightPuzzleGameJFrame() { 
        //Initializes the board and buttons arrays
        board = new int[SIZE][SIZE]; //actual logic
        buttons = new JButton[SIZE][SIZE]; //visual 
        // Calls methods to set up the puzzle and the GUI
        initializeBoard();
        initializeGUI();
    }

    private void initializeBoard() {
        ArrayList<Integer> tiles = new ArrayList<>(); // Creates an ArrayList to hold the numbers representing the puzzle tiles
        for (int i = 1; i < SIZE * SIZE; i++) { // Adds the ArrayList with numbers from 1 to SIZE * SIZE - 1 
            tiles.add(i);
        }
        tiles.add(EMPTY); // Adds empty tile (0) to the ArrayList, represents blank space on board
        Collections.shuffle(tiles); // Randomly shuffles the ArrayList so the puzzle starts random

        for (int row = 0; row < SIZE; row++) { //Starts a loop to iterate over each row of the board
            for (int col = 0; col < SIZE; col++) { //Starts an inner loop to iterate over each column of the current row, effectively covering every position in the 2D grid
                int value = tiles.remove(0); //Removes the first element from the tiles list and assigns it to value. This ensures each tile is used exactly once
                board[row][col] = value; //Assigns the value to the current position (row, col) on the board array, populating the puzzle grid
                //Checks if the current value is the "empty" tile (0)and if true, updates the emptyRow and emptyCol variables to store the position of the blank tile
                if (value == EMPTY) {
                    emptyRow = row;
                    emptyCol = col;
                }
            }
        }
    }

    private void initializeGUI() { //Creates a 3x3 grid layout and initializes buttons for each tile
        setTitle("8 Puzzle Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE));

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                JButton button = new JButton(board[row][col] == EMPTY ? "" : String.valueOf(board[row][col])); 
                button.setFont(new Font("Arial", Font.BOLD, 24));
                button.addActionListener(new ButtonClickListener(row, col)); //Adds an ActionListener to each button to handle tile clicks
                buttons[row][col] = button;
                add(button);
            }
        }

        setSize(400, 400);
        setVisible(true);
    }

    private boolean isSolved() { //Checks if all tiles are in ascending order, with the last cell empty
        int value = 1; //creates a ``` variable value to represent the expected value in the current tile
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (row == SIZE - 1 && col == SIZE - 1) {
                    return board[row][col] == EMPTY;
                }
                if (board[row][col] != value++) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean moveTile(int row, int col) { // Moves a tile into the blank space if it's adjacent to it
        if (isAdjacent(row, col, emptyRow, emptyCol)) { // Checks if the tile is adjacent to the empty space located emptyRow, emptyCol
            board[emptyRow][emptyCol] = board[row][col]; // Moves the tile into the blank space located at row col
            board[row][col] = EMPTY; // makes the original position empty
            emptyRow = row; //updates position of empty tile
            emptyCol = col;
            return true;
        }
        return false; // returns false if the tile wasn't adjacent to blank tile
    }

    private boolean isAdjacent(int row1, int col1, int row2, int col2) { //Checks if two positions are adjacent 
        return (Math.abs(row1 - row2) + Math.abs(col1 - col2)) == 1;
    }

    private void updateButtons() { // Updates GUI button labels to the current state of the board
        for (int row = 0; row < SIZE; row++) { // Iterates over the rows of the board and buttons arrays
            for (int col = 0; col < SIZE; col++) { // Iterates over the columns within the current row
                buttons[row][col].setText(board[row][col] == EMPTY ? "" : String.valueOf(board[row][col]));
            }
        }
    }

    private class ButtonClickListener implements ActionListener { //Handles button clicks: Attempts to move the clicked tile, updates the board and buttons, checks if the puzzle is solved.
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (moveTile(row, col)) {
                updateButtons();
                if (isSolved()) {
                    JOptionPane.showMessageDialog(EightPuzzleGameJFrame.this, "Congratulations! You've solved the puzzle!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(EightPuzzleGameJFrame.this, "Invalid move!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
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
