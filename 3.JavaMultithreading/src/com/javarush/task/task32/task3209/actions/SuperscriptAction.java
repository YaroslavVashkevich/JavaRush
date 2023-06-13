package com.javarush.task.task32.task3209.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

public class SuperscriptAction extends StyledEditorKit.StyledTextAction {

    public SuperscriptAction() {
        super(StyleConstants.Superscript.toString());
    }//nadstro4nii

    @Override
    public void actionPerformed(ActionEvent e) {
        JEditorPane pane = getEditor(e);
        if(pane != null){
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(pane).getInputAttributes();
            SimpleAttributeSet attributeSet = new SimpleAttributeSet();
            StyleConstants.setSuperscript(attributeSet, !StyleConstants.isSuperscript(mutableAttributeSet));
            setCharacterAttributes(pane, attributeSet, false);
        }
    }
}
