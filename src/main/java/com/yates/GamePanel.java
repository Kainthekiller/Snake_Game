package com.yates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements ActionListener {

    static  final int Screen_Width = 800;
    static  final int Screen_Height = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (Screen_Width * Screen_Height) /UNIT_SIZE;
    static final int DELAY = 75;
    //<editor-fold desc="Constructor">
    GamePanel()
    {

    }
    //</editor-fold>

    public void startGame()
    {

    }
    public void paintComponents(Graphics g)
    {

    }
    public void draw(Graphics g)
    {

    }
    public void move()
    {

    }
    public void checkApple()
    {

    }
    public void checkCollision()
    {

    }
    public void gameOver(Graphics g)
    {

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public  class MyKeyAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {

        }

    }

}
