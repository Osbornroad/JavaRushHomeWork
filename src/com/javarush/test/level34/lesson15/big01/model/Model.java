package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;
import java.util.Set;

public class Model
{
    public static int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("./src/com/javarush/test/level34/lesson15/big01/res/levels.txt"));

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects()
    {
        return gameObjects;
    }

    public void restartLevel(int level)
    {
        this.gameObjects = levelLoader.getLevel(level);
    }

    public void restart()
    {
        restartLevel(currentLevel);
    }

    public void startNextLevel()
    {
        restartLevel(++currentLevel);
    }

    public void move(Direction direction)
    {

    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction)
    {
        for (Wall wall : gameObjects.getWalls())
        {
            if (gameObject.isCollision(wall, direction))
            {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction)
    {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction))
            return true;

        for (Box box : gameObjects.getBoxes())
        {
            if (player.isCollision(box, direction))
            {
                for (Box anotherBox : gameObjects.getBoxes())
                {
                    if (box.isCollision(anotherBox, direction))
                        return true;
                    else
                    {
                        int x = 0;
                        int y = 0;
                        switch (direction)
                        {
                            case LEFT:
                                x = - FIELD_SELL_SIZE;
                                break;
                            case UP:
                                y = - FIELD_SELL_SIZE;
                                break;
                            case RIGHT:
                                x = FIELD_SELL_SIZE;
                                break;
                            case DOWN:
                                y = FIELD_SELL_SIZE;
                                break;
                        }
                        box.move(x, y);
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public void checkCompletion()
    {

    }
}
