package com.javarush.test.level34.lesson15.big01.model;

import static com.javarush.test.level34.lesson15.big01.model.Model.FIELD_SELL_SIZE;

/**
 * Created by User on 30.01.2017.
 */
public abstract class CollisionObject extends GameObject
{
    public CollisionObject(int x, int y)
    {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction)
    {
        int movedX = this.getX();
        int movedY = this.getY();
        switch (direction)
        {
            case LEFT:
                movedX -= FIELD_SELL_SIZE;
                break;
            case UP:
                movedY -= FIELD_SELL_SIZE;
                break;
            case RIGHT:
                movedX += FIELD_SELL_SIZE;
                break;
            case DOWN:
                movedY += FIELD_SELL_SIZE;
                break;
        }
        if ((movedX == gameObject.getX()) && (movedY == gameObject.getY()))
            return true;
        else
            return false;
    }
}
