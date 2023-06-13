package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    private static final String LEFT = "LEFT_CHILD";
    private static final String RIGHT = "RIGHT_CHILD";
    Entry<String> root;

    public CustomTree() {
        this.root = new Entry<>("Root");
    }

    @Override
    public boolean add(String s) {
        Queue<Entry<String>> queue = new LinkedList<>(Collections.singletonList(root));

        while (!queue.isEmpty()) {
            Entry<String> node = queue.poll();

            if (node.isAvailableToAddChildren()) {
                if (node.availableToAddLeftChildren) {
                    return appendChild(s, node, LEFT);
                }
                if (node.availableToAddRightChildren) {
                    return appendChild(s, node, RIGHT);
                }
            } else {
                if(node.leftChild != null) queue.offer(node.leftChild);
                if(node.rightChild != null) queue.offer(node.rightChild);
            }
        }
        return false;
    }

    private boolean appendChild(String s, Entry<String> node, final String child) {
        switch (child) {
            case LEFT: {
                node.leftChild = new Entry<>(s);
                node.leftChild.parent = node;
                node.checkChildren();
                return true;
            }

            case RIGHT: {
                node.rightChild = new Entry<>(s);
                node.rightChild.parent = node;
                node.checkChildren();
                return true;
            }
        }

        return false;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    public String getParent(String s) {
        Queue<Entry<String>> queue = new LinkedList<>(Collections.singletonList(root));
        while (!queue.isEmpty()) {
            Entry<String> node = queue.poll();
            if (node.elementName.equals(s)) {
                return node.parent.elementName;
            }
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = -1;
        Queue<Entry<String>> queue = new LinkedList<>(Collections.singletonList(root));
        while (!queue.isEmpty()) {
            Entry<String> entry = queue.poll();
            count++;

            if (entry.leftChild != null) {
                queue.offer(entry.leftChild);
            }
            if (entry.rightChild != null)
                queue.offer(entry.rightChild);
        }
        return count;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public void checkChildren() {
            if (leftChild != null)
                availableToAddLeftChildren = false;
            if (rightChild != null)
                availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }
        Queue<Entry<String>> nodes = new LinkedList<>(Collections.singletonList(root));
        while (!nodes.isEmpty()) {
            Entry<String> currentNode = nodes.poll();
            if(currentNode.elementName.equals(o)){
                if(currentNode.parent.leftChild == currentNode){
                    currentNode.parent.leftChild = null;
                    currentNode.parent.availableToAddLeftChildren = true;
                }
                if(currentNode.parent.rightChild == currentNode){
                    currentNode.parent.rightChild = null;
                    currentNode.parent.availableToAddRightChildren = true;
                }
                return true;
            }
            if(currentNode.leftChild != null) nodes.offer(currentNode.leftChild);
            if(currentNode.rightChild != null) nodes.offer(currentNode.rightChild);
        }
        return false;
    }
}
