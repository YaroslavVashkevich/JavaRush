package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize = -1;
    private int maxSize = -1;
    private List<Path> foundFiles = new LinkedList<>();

    public void setPartOfName(String partOfName){
        this.partOfName = partOfName;
    }
    public void setPartOfContent(String partOfContent){
        this.partOfContent = partOfContent;
    }
    public void setMinSize(int minSize){
        this.minSize = minSize;
    }
    public void setMaxSize(int maxSize){
        this.maxSize = maxSize;
    }
    public List<Path> getFoundFiles(){
        return this.foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean containsName = true;

        if(partOfName!=null && containsName){
            containsName = file.getFileName().toString().contains(partOfName);
        }
        if(partOfContent!=null && containsName){
            containsName = Files.readAllLines(file).toString().contains(partOfContent);
        }
        if(minSize>=0 && containsName){
            containsName = attrs.size() > minSize;
        }
        if (maxSize >= 0 && containsName) {
            containsName = attrs.size() < maxSize;
        }
        if(containsName){foundFiles.add(file);}

        return FileVisitResult.CONTINUE;
    }
}
