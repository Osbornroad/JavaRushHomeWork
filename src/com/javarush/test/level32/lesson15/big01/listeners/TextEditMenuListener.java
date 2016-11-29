package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 8.2.2.	TextEditMenuListener. Этот класс также должен реализовывать интерфейс MenuListener.
 Добавь ему конструктор TextEditMenuListener(View view). В следующих заданиях мы
 рассмотрим его детальнее.
 */
public class TextEditMenuListener implements MenuListener
{
    private View view;

    @Override
    public void menuSelected(MenuEvent e)
    {

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
