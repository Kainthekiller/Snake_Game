package com.yates;

import javax.swing.*;

public class Game_Frame extends JFrame {

//<editor-fold desc="Constructor">
    Game_Frame()
    {
        this.add(new GamePanel()); // Added Game Panel to the game frame aka this
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
    //</editor-fold>

}
