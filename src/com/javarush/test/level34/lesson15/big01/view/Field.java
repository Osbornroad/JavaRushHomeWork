package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.Direction;
import com.javarush.test.level34.lesson15.big01.model.GameObject;
import com.javarush.test.level34.lesson15.big01.model.GameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

import static java.awt.event.KeyEvent.*;

/**
 * Created by User on 30.01.2017.
 */
public class Field extends JPanel
{
    private View view;

    private EventListener eventListener;

    public Field (View view) {
        this.view = view;
        KeyHandler keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        setFocusable(true);
    }

    public void paint(Graphics g) {
        g.setColor(new Color(0x000000));
        g.fillRect(0, 0, view.getWidth(), view.getHeight());
        GameObjects gameObjects = view.getGameObjects();
        Set<GameObject> setGameObjects = gameObjects.getAll();
        for(GameObject gameObject : setGameObjects)
            gameObject.draw(g);
    }

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    public class KeyHandler extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
                case VK_LEFT:
                    eventListener.move(Direction.LEFT);
                    break;
                case VK_RIGHT:
                    eventListener.move(Direction.RIGHT);
                    break;
                case VK_UP:
                    eventListener.move(Direction.UP);
                    break;
                case VK_DOWN:
                    eventListener.move(Direction.DOWN);
                    break;
                case VK_R:
                    eventListener.restart();
                    break;
            }
        }
    }
}
