/**
 * @author Conrad Djedjebi (protected by copyrights)
 * @date 07/10/18
 * @project FiftyFive_Test
 */
package com.conrad.www.displayDates.DataStructure;

public class BasicNode<T extends Comparable<T>> implements Cloneable {
    //------------------------------------ MEMBERS ---------------------------------//
    private T data = null;
    private BasicNode<T> parent = null;
    private BasicNode<T> left = null;
    private BasicNode<T> right = null;
    private int count = 0;
    /**
     * meta is the head of a graph related to node (a month graph for example is related/not linked to a year node.
     **/
    private BasicNode<T> meta = null;

    //------------------------------------ CONSTRUCTORS ---------------------------------//
    /**
     * Default constructor of object BasicNode
     *
     * @GraphTheory
     * Each node has an output degree of 2 and an input degree of 1.
     * Each node is part of a simple non oriented graph, more precisly a triply linked data structure
     **/
    public BasicNode() {
    }

    /**
     * Constructor of object BasicNode
     *
     * @GraphTheory
     * Each node has an output degree of 2 and an input degree of 1.
     * Each node is part of a simple non oriented graph, more precisly a triply linked data structure
     *
     * @param data the node's value
     **/
    public BasicNode(T data) {
        this();
        this.data = data;
        this.count++;
    }

    /**
     * Constructor of object BasicNode
     *
     * @GraphTheory
     * Each node has an output degree of 2 and an input degree of 1.
     * Each node is part of a simple non oriented graph, more precisly a triply linked data structure
     *
     * @param data the node's value
     * @param data the node's value
     * @param data the node's value
     **/
    public BasicNode(T data, BasicNode<T> left, BasicNode<T> right) {
        this(data);
        this.left = left;
        this.right = right;
    }

    //------------------------------------ GETTERS ---------------------------------//

    public BasicNode<T> getLeft() {
        return this.left;
    }

    public BasicNode<T> getRight() {
        return this.right;
    }

    public BasicNode<T> getParent() {
        return this.parent;
    }

    public T getData() {
        return this.data;
    }

    public BasicNode<T> getMeta() {
        return this.meta;
    }

    public int getCount() {
        return this.count;
    }
    //------------------------------------ SETTERS ---------------------------------//

    /**
     * setData(): set node's value
     * @param data desired node's value
     **/
    public void setData(T data) {
        this.data = data;
    }

    /**
     * setMeta(): set node's meta
     * @param meta desired node's meta
     **/
    public void setMeta(BasicNode<T> meta) {
        this.meta = meta;
    }

    /**
     * setCount(): set node's iteration value
     * @param count desired node's iteration value
     **/
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * setLeft(): set node's left child
     * @param child desired node's left child
     **/
    public void setLeft(BasicNode<T> child) {
        this.left = child;
        child.setParent(this);
    }

    /**
     * setRight(): set node's right child
     * @param child desired node's right child
     **/
    public void setRight(BasicNode<T> child) {
        this.right = child;
        child.setParent(this);
    }

    /**
     * setParent(): set node's parent
     * @param parent desired node's parent
     **/
    public void setParent(BasicNode<T> parent) {
        this.parent = parent;
    }

    //------------------------------------ METHODS --------------------------------//
    /**
     * isRoot()
     * @return : true if node is root, false otherwise
     **/
    public boolean isRoot() {
        return (this.parent == null);
    }

    /**
     * removeLeft(): remove node's left child
     **/
    public void removeLeft() {
        this.left = null;
    }

    /**
     * removeRight(): remove node's right child
     **/
    public void removeRight() {
        this.right = null;
    }

    /**
     * removeParent(): remove node's parent (node becomes root..)
     **/
    public void removeParent() {
        this.parent = null;
    }

    /**
     * clone(): clone a node (and its childs..)
     **/
    public BasicNode<T> clone() throws CloneNotSupportedException {
        BasicNode<T> clonedObj = (BasicNode<T>) super.clone();
        if(this.left != null)
            clonedObj.left = this.left.clone();
        if(this.right != null)
            clonedObj.right = this.right.clone();
        return clonedObj;
    }

    /**
     * getMin(): return the min value in the node's graph
     * The min value is always on the very left side of the graph #GraphTheory
     *
     * @return : min value in node's graph
     **/
    public T getMin() {
        if (this.getLeft() == null) {
            return this.getData();
        } else {
            return this.getLeft().getMin();
        }
    }
}