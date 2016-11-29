package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 8.2.2.	TextEditMenuListener. Этот класс также должен реализовывать интерфейс MenuListener.
 Добавь ему конструктор TextEditMenuListener(View view). В следующих заданиях мы
 рассмотрим его детальнее.
 */
public class TextEditMenuListener implements MenuListener
{
    private View view;
    /**
     13.2.	Добавь в класс TextEditMenuListener поле View, проинициализируй его в конструкторе
     класса.
     13.3.	В классе TextEditMenuListener переопредели метод menuSelected(MenuEvent
     menuEvent). Он должен:
     13.3.1.	Из переданного параметра получать объект, над которым было совершено действие. В
     нашем случае это будет объект с типом JMenu.
     13.3.2.	У полученного меню получать список компонентов (пунктов меню).
     13.3.3.	Для каждого пункта меню вызывать метод setEnabled, передав в качестве параметра
     результат вызова метода isHtmlTabSelected() из представления.

     */
    @Override
    public void menuSelected(MenuEvent e)
    {
        JMenu menu = (JMenu) e.getSource();
        Component[] components = menu.getMenuComponents();
        for (Component component : components)
        {
            component.setEnabled(view.isHtmlTabSelected());
        }
    }

    @Override
    public void menuDeselected(MenuEvent e)
    {

    }

    @Override
    public void menuCanceled(MenuEvent e)
    {

    }

    public TextEditMenuListener(View view)
    {
        this.view = view;
    }


}
