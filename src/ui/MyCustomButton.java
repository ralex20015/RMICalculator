package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCustomButton extends JButton {

    public MyCustomButton(Color backgrounColor, Color textColor, String contentOfButton){
        setFont(new Font("Arial",Font.PLAIN,22));
        setBackground(backgrounColor);
        setForeground(textColor);
        setText(contentOfButton);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(true);
        setUI(new RoundedButtonUI());
        setContentAreaFilled(false);
    }

}
