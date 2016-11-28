package com.javarush.test.level32.lesson15.big01;

import javax.swing.text.html.HTMLDocument;
import java.io.File;

/**
 2.1.	Добавь в контроллер и представление по методу init(), пока без реализаций. Они будут
 отвечать за инициализацию контроллера и представления.
 2.2.	Добавь в класс Controller метод main(). Он должен:
 2.2.1.	Создавать объект представления.
 2.2.2.	Создавать контроллер, используя представление.

 2.2.3.	Устанавливать у представления контроллер.
 2.2.4.	Инициализировать представление.
 2.2.5.	Инициализировать контроллер. Контроллер должен инициализироваться после представления.
 2.3.	Добавь в контроллер метод exit(), он должен вызывать статический метод exit у класса
 System.
 2.4.	Добавь в представление метод exit(), он должен вызывать exit() у контроллера.
 */
public class Controller {

    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init()
    {

    }

    public void exit()
    {
        System.exit(0);
    }

    public static void main(String[] args)
    {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
}
