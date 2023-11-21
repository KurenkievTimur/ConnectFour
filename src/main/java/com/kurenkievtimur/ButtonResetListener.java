package com.kurenkievtimur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonResetListener implements ActionListener {
    private final ConnectFour connectFour;

    public ButtonResetListener(ConnectFour connectFour) {
        this.connectFour = connectFour;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        connectFour.reset();
    }
}
