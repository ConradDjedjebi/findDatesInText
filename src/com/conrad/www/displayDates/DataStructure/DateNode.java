/**
 * @author Conrad Djedjebi (protected by copyrights)
 * @date 07/10/18
 * @project FiftyFive_Test
 */
package com.conrad.www.displayDates.DataStructure;
import com.conrad.www.displayDates.Util.CustomHandler;
import java.util.logging.*;

public class DateNode {
    //------------------------------------ MEMBERS ---------------------------------//
    /**
     * root is the top node of a 3-dimensional triply-linked data structure (graph)
     * root is the head of a graph containing the year, the month and the day graphs
     **/
    private BasicNode<Integer> root = new BasicNode<Integer>(null);
    private static Logger LOGGER = Logger.getLogger(DateNode.class.getName());

    //------------------------------------ CONSTRUCTORS ---------------------------------//
    /**
     * Default constructor of object DateNode
     *
     * Initialize the logger
     **/
    public DateNode() {
        LogManager.getLogManager().reset();
        LOGGER.addHandler(new CustomHandler());
        LOGGER.setLevel(Level.OFF);
    }

    //------------------------------------ GETTERS --------------------------------//
    public BasicNode<Integer> getRoot(){
        return this.root;
    }

    //------------------------------------ METHODS --------------------------------//
    /**
     * addYear(): add a year to the year graph
     *
     * Each value is added to the left if it is smaller. Otherwise, it is added to the right
     * If value already exists in the graph, its counter increments.
     * That way, the min value in the graph is always on the very left side #GraphTheory
     *
     * @see com.conrad.www.displayDates.DataStructure.DateNode#displayYears(BasicNode) displayYears
     * @param node root of the graph
     * @param year the year
     * @param month the month
     * @param day the day
     **/
    private void addYear(BasicNode<Integer> node, Integer year, Integer month, Integer day) {
        LOGGER.fine("adding year " + year);
        if (node.getData() != null) {
            if (node.getData().compareTo(year) < 0) {
                LOGGER.fine("adding to right side");
                if (node.getRight() == null) {
                    LOGGER.finest("creating a right child");
                    node.setRight(new BasicNode<Integer>(year));
                    node.getRight().setMeta(new BasicNode<Integer>(month));
                    node.getRight().getMeta().setMeta(new BasicNode<Integer>(day));
                } else {
                    LOGGER.finest("adding value to right child's child");
                    addYear(node.getRight(), year, month, day);
                }
            } else if (node.getData().compareTo(year) == 0) {
                LOGGER.fine("value already exists in tree. Lets increament counter!");
                node.setCount(node.getCount() + 1);
                addMonth(node.getMeta(), month, day);
            } else {
                LOGGER.fine("adding to left side");
                if (node.getLeft() == null) {
                    LOGGER.finest("creating a left child");
                    node.setLeft(new BasicNode<Integer>(year));
                    node.getLeft().setMeta(new BasicNode<Integer>(month));
                    node.getLeft().getMeta().setMeta(new BasicNode<Integer>(day));
                } else {
                    LOGGER.finest("adding value to left child's child");
                    addYear(node.getLeft(), year, month, day);
                }
            }
        } else {
            LOGGER.fine("adding value to current node");
            node.setData(year);
            node.setMeta(new BasicNode<Integer>(month));
            node.getMeta().setMeta(new BasicNode<Integer>(day));
        }
    }


    /**
     * addMonth(): add a month to the month graph
     *
     * Each value is added to the left if it is smaller. Otherwise, it is added to the right
     * If value already exists in the graph, its counter increments.
     * That way, the min value in the graph is always on the very left side #GraphTheory
     *
     * @see com.conrad.www.displayDates.DataStructure.DateNode#displayMonths(BasicNode) displayMonths
     * @param node the root of the graph
     * @param month the month
     * @param day the day
     **/
    private void addMonth(BasicNode<Integer> node, Integer month, Integer day) {
        LOGGER.fine("adding month " + month);
        if (node.getData() != null) {
            if (node.getData() < month) {
                LOGGER.fine("adding to Right side");
                if (node.getRight() == null) {
                    LOGGER.finest("creating a right child");
                    node.setRight(new BasicNode<Integer>(month));
                    node.getRight().setMeta(new BasicNode<Integer>(day));
                } else {
                    LOGGER.finest("adding value to right child's child");
                    addMonth(node.getRight(), month, day);
                }
            } else if (node.getData().compareTo(month) == 0) {
                //this is a year. so this has a meta
                LOGGER.fine("value already exists in tree");
                node.setCount(node.getCount() + 1);
                addDay(node.getMeta(), day);
            } else {
                LOGGER.fine("adding to Left side");
                if (node.getLeft() == null) {
                    LOGGER.finest("creating a left child");
                    node.setLeft(new BasicNode<Integer>(month));
                    node.getLeft().setMeta(new BasicNode<Integer>(day));
                } else {
                    LOGGER.finest("adding value to left child's child");
                    addMonth(node.getLeft(), month, day);
                }
            }
        } else {
            LOGGER.fine("adding value to current node");
            node.setData(month);
            node.setMeta(new BasicNode<Integer>(day));
        }
    }

    /**
     * addDay(): add a day to the day graph
     *
     * Each value is added to the left if it is smaller. Otherwise, it is added to the right
     * If value already exists in the graph, its counter increments.
     * That way, the min value in the graph is always on the very left side #GraphTheory
     *
     * @see com.conrad.www.displayDates.DataStructure.DateNode#displayDays(BasicNode) displayDays
     * @param node root of the graph
     * @param day the day
     **/
    private void addDay(BasicNode<Integer> node, Integer day) {
        LOGGER.fine("adding day " + day);
        if (node.getData() != null) {
            if (node.getData().compareTo(day) < 0) {
                LOGGER.fine("adding to Right side");
                if (node.getRight() == null) {
                    LOGGER.finest("creating a right child");
                    node.setRight(new BasicNode<Integer>(day));
                } else {
                    LOGGER.finest("adding value to right child's child");
                    addDay(node.getRight(), day);
                }
            } else if (node.getData().compareTo(day) == 0) {
                LOGGER.fine("value already exists in tree");
                node.setCount(node.getCount() + 1);
            } else {
                LOGGER.fine("adding to Left side");
                if (node.getLeft() == null) {
                    LOGGER.finest("creating a left child");
                    node.setLeft(new BasicNode<Integer>(day));
                } else {
                    LOGGER.finest("adding value to left child's child");
                    addDay(node.getLeft(), day);
                }
            }
        } else {
            LOGGER.fine("adding value to current node");
            node.setData(day);
        }
    }

    /**
     * addToGraph(): add a date to the date's 3-dimensional graph (this.root)
     *
     * @param year the year
     * @param year the month
     * @param day the day
     **/
    public void addToGraph(int year, int month, int day) {
        String message = String.format("adding year %d, month %d and day %d",
                year,
                month,
                day);
        LOGGER.info(message);
        this.addYear(root, year, month, day);
    }

    /**
     * displayDates(): display all the dates saved in the 3-dimensional graph (this.root)
     **/
    public void displayDates() {
        displayYears(root);
    }

    /**
     * displayYears(): display all the years saved in the year graph (from min to max)
     * The min year is always on the very left side of the graph #GraphTheory
     *
     * @see com.conrad.www.displayDates.DataStructure.DateNode#addYear(BasicNode, Integer, Integer, Integer) addYear
     * @param node root of the graph
     **/
    private static void displayYears(BasicNode<Integer> node) {
        LOGGER.config("Displaying years from min to max");
        if (node.getLeft() == null) {
            LOGGER.fine("current node is min");
            System.out.println(node.getData()+ ":\n");
            displayMonths(node.getMeta());
            LOGGER.finest("updating tree");
            if (node.getRight() != null) {
                LOGGER.finest("replace current node by its right child");
                if (!node.isRoot()) {
                    LOGGER.finest("current node is not root");
                    node.getParent().setLeft(node.getRight());
                    LOGGER.finest("getting root..");
                    while (!node.isRoot()) {
                        node = node.getParent();
                    }
                    displayYears(node);
                } else {
                    LOGGER.finest("current node is root");
                    LOGGER.finest("right child becomes root");
                    node.getRight().setParent(null);
                    LOGGER.finest("Going on..");
                    displayYears(node.getRight());
                }
            } else {
                LOGGER.finest("current node has no child");
                if (!node.isRoot()) {
                    LOGGER.finest("current node is not root");
                    LOGGER.finest("removing node from tree");
                    node.getParent().removeLeft();
                    LOGGER.finest("getting root..");
                    while (!node.isRoot()) {
                        node = node.getParent();
                    }
                    LOGGER.finest("Going on..");
                    displayYears(node);
                } else {
                    LOGGER.finest("current node is root");
                    LOGGER.finest("we displayed all the years");
                }
            }
        } else {
            LOGGER.fine("looking for min in node's left child");
            displayYears(node.getLeft());
        }
    }

    /**
     * displayMonths(): display all the months saved in the month graph (from min to max)
     * The min month is always on the very left side of the graph #GraphTheory
     *
     * @see com.conrad.www.displayDates.DataStructure.DateNode#addMonth(BasicNode, Integer, Integer) addMonth
     * @param node root of the graph
     **/
    private static void displayMonths(BasicNode<Integer> node) {
        LOGGER.config("Displaying months from min to max");
        if (node.getLeft() == null) {
            LOGGER.fine("current node is min");
            System.out.println(node.getData()<10? "    -0" + node.getData()+ "\n" : "    -" + node.getData()+ "\n");
            displayDays(node.getMeta());
            LOGGER.finest("updating tree");
            if (node.getRight() != null) {
                LOGGER.finest("replace current node by its right child");
                if (!node.isRoot()) {
                    LOGGER.finest("current node is not root");
                    node.getParent().setLeft(node.getRight());
                    LOGGER.finest("getting root..");
                    while (!node.isRoot()) {
                        node = node.getParent();
                    }
                    displayMonths(node);
                } else {
                    LOGGER.finest("current node is root");
                    LOGGER.finest("right child becomes root");
                    node.getRight().removeParent();
                    LOGGER.finest("Going on..");
                    displayMonths(node.getRight());
                }
            } else {
                LOGGER.finest("current node has no child");
                if (!node.isRoot()) {
                    LOGGER.finest("current node is not root");
                    LOGGER.finest("removing node from tree");
                    node.getParent().removeLeft();
                    LOGGER.finest("getting root..");
                    while (!node.isRoot()) {
                        node = node.getParent();
                    }
                    LOGGER.finest("Going on..");
                    displayMonths(node);
                } else {
                    LOGGER.finest("current node is root");
                    LOGGER.finest("we displayed all the years");
                }
            }
        } else {
            LOGGER.fine("looking for min in current node's left child");
            displayMonths(node.getLeft());
        }
    }

    /**
     * displayDays(): display all the days saved in the day graph (from min to max)
     * The min day is always on the very left side of the graph #GraphTheory
     *
     * @see com.conrad.www.displayDates.DataStructure.DateNode#addDay(BasicNode, Integer) addDay
     * @param node root of the graph
     **/
    private static void displayDays(BasicNode<Integer> node) {
        LOGGER.config("Displaying days from min to max");
        if (node.getLeft() == null) {
            LOGGER.fine("current node is min");
            System.out.println(node.getData() < 10? "        -0" + node.getData()+ " (" + node.getCount() + ")" + "\n" : "        -" + node.getData()+ " (" + node.getCount() + ")" + "\n");
            LOGGER.finest("updating tree");
            if (node.getRight() != null) {
                LOGGER.finest("replace current node by its right child");
                if (!node.isRoot()) {
                    LOGGER.finest("current node is not root");
                    node.getParent().setLeft(node.getRight());
                    LOGGER.finest("getting root..");
                    while (!node.isRoot()) {
                        node = node.getParent();
                    }
                    displayDays(node);
                } else {
                    LOGGER.finest("current node is root");
                    LOGGER.finest("right child becomes root");
                    node.getRight().setParent(null);
                    LOGGER.finest("Going on..");
                    displayDays(node.getRight());
                }
            } else {
                LOGGER.finest("current node has no child");
                if (!node.isRoot()) {
                    LOGGER.finest("current node is not root");
                    LOGGER.finest("removing node from tree");
                    node.getParent().removeLeft();
                    LOGGER.finest("getting root..");
                    while (!node.isRoot()) {
                        node = node.getParent();
                    }
                    LOGGER.finest("Going on..");
                    displayDays(node);
                } else {
                    LOGGER.finest("current node is root");
                    LOGGER.finest("we displayed all the years");
                }
            }
        } else {
            LOGGER.fine("looking for min in current node's left child");
            displayDays(node.getLeft());
        }
    }
}