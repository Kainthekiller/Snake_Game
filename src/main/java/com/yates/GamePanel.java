package com.yates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.awt.Graphics;

public class GamePanel extends JPanel implements ActionListener {

    static  final int Screen_Width = 600;
    static  final int Screen_Height = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (Screen_Width * Screen_Height) /UNIT_SIZE;
    static final int DELAY = 75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6; //Snakes Body Starts at 6 for a typical Size and will ++ with each apple grab
    int applesEaten = 0;
    int appleX;
    int appleY; //Apple Pos
    char direction = 'R';
    boolean running = true;
    Timer timer;
    Random random;
    //<editor-fold desc="Constructor">
    GamePanel()
    {
        random = new Random();
        this.setPreferredSize(new Dimension(Screen_Width, Screen_Height));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    //</editor-fold>

    public void startGame()
    {


        running = true; // Game is running
        timer = new Timer(DELAY,this);
        timer.start();
        newApple();
    }
    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        draw(g);

    }

    public void draw(Graphics g)
    {
        //Grids For Snake Game Background
        for (int i = 0; i < Screen_Height / UNIT_SIZE; i++)
        {
            //Main Grid
            g.setColor(Color.red);
            g.drawLine(i * UNIT_SIZE,0,i*UNIT_SIZE, Screen_Height);
            g.drawLine(0,i * UNIT_SIZE, Screen_Width, i*UNIT_SIZE);
        }
        //Draws the Apple

            g.setColor(Color.green);
            g.fillOval(appleX,appleY,UNIT_SIZE, UNIT_SIZE); //Location, Location,  Width Size of Draw and Hight
        //Draws Snake
        for (int i = 0; i < bodyParts ; i++)
        {
            if (i == 0)
            {
                g.setColor(Color.green);
                g.fillRect(x[i],y[i],UNIT_SIZE, UNIT_SIZE);
            }
            else
            {
                g.setColor(new Color(45,180,0));
                g.fillRect(x[i],y[i],UNIT_SIZE, UNIT_SIZE);
            }
        }
        //Random Triangle Draw
        g.setColor(Color.YELLOW);
        g.drawLine(120, 130, 280, 130) ;
        g.drawLine(120, 130, 200, 65);
        g.drawLine(200, 65, 280, 130);
    }
    public void newApple()
    {
            //Generates Apple;                  //True = 0 - 24              25
        appleX = random.nextInt((int)Screen_Width / UNIT_SIZE) * UNIT_SIZE;
        appleY = random.nextInt((int)Screen_Height / UNIT_SIZE) * UNIT_SIZE;

    }
    public void move()
    {
        //Equals the Previous Snake Body Part Position;
        for (int i = bodyParts; i > 0 ; i--)
        {
            x[i] = x[i-1]; //Shift Everything
            y[i] = y[i-1];
        }

        switch (direction)
        {
            //Go Up
            case 'U':        //25
                y[0] = y[0] - UNIT_SIZE;
                break;
            //Go Down
            case 'D':        //25
                y[0] = y[0] + UNIT_SIZE;
                break;
            //Go Right
            case 'R':        //25
                x[0] = x[0] + UNIT_SIZE;
                break;
            //Go Left
            case 'L':        //25 about size of a box
                x[0] = x[0] - UNIT_SIZE;
                break;
        }
    }
    public void checkApple()
    {

    }
    public void checkCollision()
    {
        for (int i = bodyParts; i> 0; i--) {
            //Head Collides With Ourselves
            if (x[i] == x[0] && y[i] == y[0]) {
                running = false; //Game Over
            }
            //Check if we hit Boarder
            //Right Boarder     //Left Boarder
            if (x[0] > Screen_Width || x[0] < 0) {
                running = false; // Game Over Boarder Hit
            }

            //Check if we hit top or bottom Boarder
            //Bottom Boarder          Top Boarder
            if (y[0] > Screen_Height || y[0] < 0) {
                running = false;
            }
        }
        if (!running) //Game over Stop the Timer
        {
            timer.stop();
            System.out.println("""
-----------------------------------------------------------
█▀▀ ▄▀█ █▀▄▀█ █▀▀   █▀█ █░█ █▀▀ █▀█
█▄█ █▀█ █░▀░█ ██▄   █▄█ ▀▄▀ ██▄ █▀▄
                   """);
        }



    }
    public void gameOver(Graphics g)
    {

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
            if (running)
            {
                move();
                checkApple();
                checkCollision();
            }
            repaint();
    }

    public  class MyKeyAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            switch(e.getKeyCode())
            {
                //Left Key
                case KeyEvent.VK_A:
                    if (direction != 'R')
                    {
                        direction = 'L';
                    }
                    break;
                    //Right Key
                case KeyEvent.VK_D :
                    if (direction != 'L')
                {
                    direction = 'R';
                }
                    break;
                    //Up Key
                case KeyEvent.VK_W:
                    if (direction != 'D')
                    {
                        direction = 'U';
                    }
                    break;
                    //Down Key
                case KeyEvent.VK_S:
                    if (direction != 'U')
                    {
                        direction = 'D';
                    }
                    break;

            }
        }

    }

}
