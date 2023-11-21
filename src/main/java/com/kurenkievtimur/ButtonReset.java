package com.kurenkievtimur;

import javax.swing.*;
import java.awt.*;

public class ButtonReset extends JButton {
    public static final Font FONT = new Font("ARIAL", Font.BOLD, 24);
    public static final Color COLOR = new Color(255,213,79);

    public ButtonReset(String text) {
        super(text);
        setName("Button" + text);
        setFont(FONT);
        setBackground(COLOR);
    }
}
