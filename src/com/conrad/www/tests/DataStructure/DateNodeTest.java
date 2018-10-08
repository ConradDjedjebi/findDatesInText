package com.conrad.www.tests.DataStructure;

import com.conrad.www.displayDates.DataStructure.DateNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DateNodeTest {
    @Test
    public void setParent(){
        DateNode dateNode = new DateNode();
        dateNode.addToGraph(2018, 1, 17);
        dateNode.addToGraph(1898, 5, 30);
        dateNode.addToGraph(2010, 10, 7);
        dateNode.addToGraph(3258, 12, 1);
        dateNode.addToGraph(2029, 7, 9);
        dateNode.addToGraph(1918, 11, 12);
        dateNode.addToGraph(2003, 4, 6);
        dateNode.addToGraph(2012, 9, 22);
        dateNode.addToGraph(1286, 10, 24);
        int val = dateNode.getRoot().getMin();
        assertEquals(1286, val, "Min value in node should be 1286");
    }
}
