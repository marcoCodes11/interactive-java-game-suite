package puzzlegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class FifthteenPuzzleGameJFrame extends JFrame {

    private static final int SIZE = 4; // 4x4 grid
    private static final int EMPTY = 0;
    private int[][] board;
    private int emptyRow, emptyCol;
    private JButton[][] buttons;

    public FifthteenPuzzleGameJFrame() {
        board = new int[SIZE][SIZE];
        buttons = new JButton[SIZE][SIZE];
        initializeBoard();
        initializeGUI();
    }

    private void initializeBoard() {
        ArrayList<Integer> tiles = new ArrayList<>();
        for (int i = 1; i < SIZE * SIZE; i++) {
            tiles.add(i);
        }
        tiles.add(EMPTY);
        Collections.shuffle(tiles);

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                int value = tiles.remove(0);
                board[row][col] = value;
                if (value == EMPTY) {
                    emptyRow = row;
                    emptyCol = col;
                }
            }
        }
    }

    private void initializeGUI() {
        setTitle("15 Puzzle Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE));

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                JButton button = new JButton(board[row][col] == EMPTY ? "" : String.valueOf(board[row][col]));
                button.setFont(new Font("Arial", Font.BOLD, 24));
                button.addActionListener(new ButtonClickListener(row, col));
                buttons[row][col] = button;
                add(button);
            }
        }

        setSize(400, 400);
        setVisible(true);
    }

    private boolean isSolved() {
        int value = 1;
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
    
   private boolean moveTile(int row, int col) {
        if (isAdjacent(row, col, emptyRow, emptyCol)) {
            board[emptyRow][emptyCol] = board[row][col];
            board[row][col] = EMPTY;
            emptyRow = row;
            emptyCol = col;
            return true;
        }
        return false;
    }

   private boolean isAdjacent(int row1, int col1, int row2, int col2) {
        return (Math.abs(row1 - row2) + Math.abs(col1 - col2)) == 1;
    }

    private void updateButtons() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                buttons[row][col].setText(board[row][col] == EMPTY ? "" : String.valueOf(board[row][col]));
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
        public void actionPerformed(ActionEvent e) {
            if (moveTile(row, col)) {
                updateButtons();
                if (isSolved()) {
                    JOptionPane.showMessageDialog(FifthteenPuzzleGameJFrame.this, "Congratulations! You've solved the puzzle!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(FifthteenPuzzleGameJFrame.this, "Invalid move!", "Error", JOptionPane.ERROR_MESSAGE);
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
