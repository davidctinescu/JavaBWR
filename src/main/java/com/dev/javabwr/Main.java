package com.dev.javabwr;

import com.dev.javabwr.Atom;
import com.dev.javabwr.BWR;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BWR frame = new BWR();
            frame.setVisible(true);
        });
    }
}