package com.company;

public class BinarySearchTree {
    private Node root;
    private int level;
    private int size;


    public boolean add(int value) {
        Node newNode = new Node(value);
        boolean result;
        if (root == null) {
            root = newNode;
            this.size++;
            result = true;
        } else {
            result = add(root, newNode);
            if (result) {
                this.size++;
            }
        }
        return result;
    }

    private boolean add(Node cursor, Node newNode) {
        boolean result = false;
        if (newNode.getValue() > cursor.getValue()) {
            if (cursor.getRight() == null) {
                cursor.setRight(newNode);
                result = true;
            } else {
                return add(cursor.getRight(), newNode);
            }
        } else if (newNode.getValue() < cursor.getValue()) {
            if (cursor.getLeft() == null) {
                cursor.setLeft(newNode);
                result = true;
            } else {
                return add(cursor.getLeft(), newNode);
            }
        }
        return result;
    }

    public int getLevel() {
        return level;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        visit(root, builder);

        builder.append("]");
        return builder.toString();
    }

    private void visit(Node cursor, StringBuilder builder) {
        if (cursor == null) return;

        visit(cursor.getLeft(), builder);
        builder.append(cursor.getValue());
        visit(cursor.getRight(), builder);
    }



    public boolean contains(int value){
        boolean result = false;
        Node tracker = root;
        if(root.getValue()==value){
            return true;
        }else{
            while(tracker != null){
                if(tracker.getValue()==value){
                    return true;
                }else if(value > tracker.getValue()){
                    tracker=tracker.getRight();
                }else{
                    tracker=tracker.getLeft();
                }
            }

        }
        return result;
    }

}
