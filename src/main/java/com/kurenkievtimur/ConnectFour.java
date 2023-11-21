package com.kurenkievtimur;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ConnectFour extends JFrame {
    private final static int ROWS = 6;
    private final static int COLS = 7;
    private final char[][] board;
    private final Button[][] buttons;
    private char player;

    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Connect Four");
        setLayout(new BorderLayout());

        board = new char[ROWS][COLS];
        buttons = new Button[ROWS][COLS];

        player = 'X';

        init();

        ButtonReset reset = new ButtonReset("Reset");
        reset.setFocusPainted(false);
        reset.addActionListener(new ButtonResetListener(this));
        reset.setText("Reset");

        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jPanel.add(reset);

        add(jPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void init() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(6, 7, 5, 5));
        for (int i = 6, row = 0; i >= 1; i--, row++) {
            for (char c = 'A', column = 0; c <= 'G'; c++, column++) {
                String name = String.valueOf(c) + i;
                Button button = new Button(name);
                button.setFocusPainted(false);

                button.addActionListener(new ButtonListener(column, this));
                jPanel.add(button);

                board[row][column] = ' ';
                buttons[row][column] = button;
            }
        }

        add(jPanel, BorderLayout.CENTER);
    }

    public boolean makeMove(int column) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == ' ') {
                board[i][column] = player;
                Button button = buttons[i][column];
                button.setText(String.valueOf(player));

                return true;
            }
        }

        return false;
    }

    public void switchPlayer() {
        player = player == 'X' ? 'O' : 'X';
    }

    public boolean checkWin() {
        return checkHorizontallyWin() || checkVerticallyWin() || checkDiagonalWin();
    }

    public boolean checkHorizontallyWin() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j <= COLS - 4; j++) {
                if (board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player && board[i][j + 3] == player) {
                    markWin(new Button[]{buttons[i][j], buttons[i][j + 1], buttons[i][j + 2], buttons[i][j + 3]}, new Color(0,230,118));

                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkVerticallyWin() {
        for (int i = 0; i <= ROWS - 4; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player && board[i + 3][j] == player) {
                    markWin(new Button[]{buttons[i][j], buttons[i + 1][j], buttons[i + 2][j], buttons[i + 3][j]}, new Color(0,230,118));

                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkDiagonalWin() {
        for (int i = 0; i <= ROWS - 4; i++) {
            for (int j = 0; j <= COLS - 4; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player && board[i + 3][j + 3] == player) {
                    markWin(new Button[]{buttons[i][j], buttons[i + 1][j + 1], buttons[i + 2][j + 2], buttons[i + 3][j + 3]}, new Color(0,230,118));

                    return true;
                }

                if (board[i][j + 3] == player && board[i + 1][j + 2] == player && board[i + 2][j + 1] == player && board[i + 3][j] == player) {
                    markWin(new Button[]{buttons[i][j + 3], buttons[i + 1][j + 2], buttons[i + 2][j + 1], buttons[i + 3][j]}, new Color(0,230,118));


                    return true;
                }
            }
        }

        return false;
    }

    public void reset() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                Button button = buttons[i][j];

                button.setText(" ");
                button.setEnabled(true);
                button.setBackground(Button.COLOR);
            }
        }

        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }

        player = 'X';
    }

    public void markWin(Button[] buttons, Color color) {
        for (Button button : buttons) {
            button.setBackground(color);
        }
    }

    public void disabled() {
        for (Button[] buttonRow : buttons) {
            for (Button button : buttonRow) {
                button.setEnabled(false);
            }
        }
    }
}