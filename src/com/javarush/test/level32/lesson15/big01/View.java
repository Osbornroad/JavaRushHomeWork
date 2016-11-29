package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener{
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    /**
     11.4.	Добавь в представление поле UndoListener undoListener, проинициализируй его
     используя undoManager.
     */

    /**
     9.2.	Добавь конструктор класса View. Он должен устанавливать внешний вид и поведение
     (look and feel) нашего приложения такими же, как это определено в системе.
     Конструктор не должен кидать исключений, только логировать их с помощью
     ExceptionHandler. Подсказа: для реализации задания используй класс UIManager.
     */

    public View()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     4.3.	Реализуй метод init() представления. Он должен:
     4.3.1.	Вызывать инициализацию графического интерфейса initGui().
     4.3.2.	Добавлять слушателя событий нашего окна. В качестве подписчика создай и используй
     объект класса FrameListener. В качестве метода для добавления подписчика используй
     подходящий метод из класса Window от которого наследуется и наш класс через
     классы JFrame и Frame.
     4.3.3.	Показывать наше окно. Используй метод setVisible с правильным параметром.
     На этом этапе приложение при запуске должно показывать окно, которое можно растягивать,
     разворачивать, закрыть и т.д.
     */

    public void init()
    {
        initGui();
        FrameListener listener = new FrameListener(this);
        addWindowListener(listener);
        setVisible(true);
    }

    public void exit()
    {
        controller.exit();
    }

    /**
     4.1.	Объяви методы initMenuBar() и initEditor() в классе View. Они будут отвечать за
     инициализацию меню и панелей редактора.

     9.1.	Реализуй метод initMenuBar(). Он должен:
     9.1.1.	Создавать новый объект типа JMenuBar. Это и будет наша панель меню.
     9.1.2.	С помощью MenuHelper инициализировать меню в следующем порядке: Файл,
     Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь.
     9.1.3.	Добавлять в верхнюю часть панели контента текущего фрейма нашу панель меню,
     аналогично тому, как это мы делали с панелью вкладок.
     */

    public void initMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar, BorderLayout.NORTH);
    }

    /**
     Реализуй метод инициализации панелей редактора initEditor(). Он должен:
     6.1.	Устанавливать значение "text/html" в качестве типа контента для компонента htmlTextPane.
     Найди и используй подходящий метод.

     6.2.	Создавать новый локальный компонент JScrollPane на базе htmlTextPane.
     6.3.	Добавлять вкладку в панель tabbedPane с именем "HTML" и компонентом из предыдущего
     пункта.

     6.4.	Создавать новый локальный компонент JScrollPane на базе plainTextPane.
     6.5.	Добавлять еще одну вкладку в tabbedPane с именем "Текст" и компонентом из
     предыдущего пункта.

     6.6.	Устанавливать предпочтительный размер панели tabbedPane.

     6.7.	Создавать объект класса TabbedPaneChangeListener и устанавливать его в качестве
     слушателя изменений в tabbedPane.

     6.8.	Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.
     Получить панель контента текущего фрейма можно с помощью метода
     getContentPane(), его реализация унаследовалась от JFrame.
     После запуска приложения можно будет увидеть текущие результаты: две независимые
     закладки (HTML и Текст), в каждой из которых можно набирать свой текст.
     */

    public void initEditor()
    {
        htmlTextPane.setContentType("text/html");

        JScrollPane jScrollHtml = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", jScrollHtml);

        JScrollPane jScrollText = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", jScrollText);

        tabbedPane.setPreferredSize(new Dimension(800, 600));

        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    /**
     4.2.	Объяви в представлении метод initGui(). Он будет инициализировать графический
     интерфейс. Вызови из него инициализацию меню initMenuBar(), инициализацию редактора
     initEditor() и метод pack(), реализацию которого мы унаследовали от класса JFrame.
     Разберись что делает метод pack().
     */

    public void initGui()
    {
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged()
    {

    }

    /**
     11.5.	Добавь в представление методы:
     11.5.1.	void undo() - отменяет последнее действие. Реализуй его используя undoManager.
     Метод не должен кидать исключений, логируй их.
     11.5.2.	void redo() - возвращает ранее отмененное действие. Реализуй его по аналогии с
     предыдущим пунктом.

     11.5.3.	Реализуй методы boolean canUndo() и boolean canRedo() используя undoManager.
     11.5.4.	Реализуй геттер для undoListener.
     11.5.5.	Добавь и реализуй метод void resetUndo(), который должен сбрасывать все правки в
     менеджере undoManager.
     */

    public void resetUndo()
    {
        undoManager.discardAllEdits();
    }

    public void undo()
    {
        try
        {
            undoManager.undo();
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    public void redo()
    {
        try
        {
            undoManager.redo();
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener()
    {
        return undoListener;
    }

    public boolean canUndo()
    {
        return undoManager.canUndo();
    }

    public boolean canRedo()
    {
        return undoManager.canRedo();
    }

    /**
     13.1.	Добавь в представление метод boolean isHtmlTabSelected(). Он должен возвращать
     true, если выбрана вкладка, отображающая html в панели вкладок (подсказка: ее индекс 0).
     */

    public boolean isHtmlTabSelected()
    {
        return tabbedPane.getSelectedIndex() == 0;
    }
}
