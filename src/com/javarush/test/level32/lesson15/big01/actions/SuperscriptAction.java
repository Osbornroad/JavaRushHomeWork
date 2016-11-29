package com.javarush.test.level32.lesson15.big01.actions;

import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Created by User on 29.11.2016.
 */
public class SuperscriptAction extends StyledEditorKit.StyledTextAction
{
    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    public SuperscriptAction()
    {
        super(StyleConstants.Superscript.toString());
    }
}
