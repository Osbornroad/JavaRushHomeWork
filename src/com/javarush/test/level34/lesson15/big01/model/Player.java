package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

import static com.javarush.test.level34.lesson15.big01.model.Model.FIELD_SELL_SIZE;

/**
 * Created by User on 31.01.2017.
 */
public class Player extends CollisionObject implements Movable
{
    public Player(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void move(int x, int y)
    {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.YELLOW);
        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;
        graphics.drawOval(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
        graphics.fillOval(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());

    }
}
