package com.kurenkievtimur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final int column;
    private final ConnectFour connectFour;

    public ButtonListener(int column, ConnectFour connectFour) {
        this.column = column;
        this.connectFour = connectFour;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean isMove = connectFour.makeMove(column);

        if (isMove) {
            boolean isWin = connectFour.checkWin();
            if (isWin)
                connectFour.disabled();

            connectFour.switchPlayer();
        }
    }
}
