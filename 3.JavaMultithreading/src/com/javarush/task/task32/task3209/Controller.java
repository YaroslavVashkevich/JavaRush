package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }
    public HTMLDocument getDocument() {
        return document;
    }
    public void init(){
        createNewDocument();
    }
    public void exit(){
        System.exit(0);
    }

    public void resetDocument(){
        if(document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        HTMLEditorKit editorKit = new HTMLEditorKit();
        document = (HTMLDocument) editorKit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    public void setPlainText(String text){
        resetDocument();
        StringReader stringReader = new StringReader(text);
        HTMLEditorKit editorKit = new HTMLEditorKit();
        try {
            editorKit.read(stringReader, document, 0);
        }catch (Exception ex){
            ExceptionHandler.log(ex);
        }
    }
    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.write(stringWriter, document, 0, document.getLength());
            stringWriter.flush();
        }catch (Exception ex){
            ExceptionHandler.log(ex);
        }
        return stringWriter.toString();
    }
    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument(){
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        HTMLFileFilter fileFilter = new HTMLFileFilter();
        jFileChooser.setFileFilter(fileFilter);
        jFileChooser.setDialogTitle("Open File" );

        int userSelection = jFileChooser.showOpenDialog(view);

        try {
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                currentFile = jFileChooser.getSelectedFile();
                resetDocument();
                view.setTitle(currentFile.getName());
                FileReader fileReader = new FileReader(currentFile);
                HTMLEditorKit editorKit = new HTMLEditorKit();
                editorKit.read(fileReader, document, 0);
                view.resetUndo();
            }
        }catch (Exception ex){
            ExceptionHandler.log(ex);
        }
    }

    public void saveDocument(){
        if(currentFile == null){
            saveDocumentAs();
        }
        try {
            view.selectHtmlTab();
            view.setTitle(currentFile.getName());
            FileWriter fileWriter = new FileWriter(currentFile);
            HTMLEditorKit editorKit = new HTMLEditorKit();
            editorKit.write(fileWriter, document, 0, document.getLength());

        }catch (Exception ex){
            ExceptionHandler.log(ex);
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        HTMLFileFilter fileFilter = new HTMLFileFilter();
        jFileChooser.setFileFilter(fileFilter);
        jFileChooser.setDialogTitle("Save File");

        int userSelection = jFileChooser.showSaveDialog(view);

        try {
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                currentFile = jFileChooser.getSelectedFile();
                view.setTitle(currentFile.getName());
                FileWriter fileWriter = new FileWriter(currentFile);
                HTMLEditorKit editorKit = new HTMLEditorKit();
                editorKit.write(fileWriter, document, 0, document.getLength());
            }
        } catch (Exception ex) {
            ExceptionHandler.log(ex);
        }
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
}
