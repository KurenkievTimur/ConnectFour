package com.kurenkievtimur;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public static final Color COLOR = new Color(156,204,102);
    public static final Color COLOR_FONT = Color.BLACK;
    public static final Font FONT = new Font("ARIAL", Font.BOLD, 32);

    public Button(String text) {
        super(" ");
        setName("Button" + text);
        setBackground(COLOR);
        setFont(FONT);
        setForeground(COLOR_FONT);
    }
}
