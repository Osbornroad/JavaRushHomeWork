package com.javarush.test.level34.lesson15.big01.controller;

import com.javarush.test.level34.lesson15.big01.model.Model;
import com.javarush.test.level34.lesson15.big01.view.View;

/**
 * Created by User on 28.12.2016.
 */
public class Controller
{
    private View view;
    private Model model;

    public Controller()
    {
        this.view = new View(this);
        this.model = new Model();
        view.init();
    }

    public static void main (String[] args) {
        Controller controller =  new Controller();
    }
}
