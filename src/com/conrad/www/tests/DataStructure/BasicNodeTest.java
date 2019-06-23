package com.conrad.www.tests.DataStructure;

import com.conrad.www.displayDates.DataStructure.BasicNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BasicNodeTest {
    @Test
    public void setParent(){
        BasicNode<Integer> parent = new BasicNode<Integer>(1780);
        BasicNode<Integer> node = new BasicNode<Integer>(2000);
        node.setParent(parent);
        assertEquals(parent.toString(), node.getParent().toString(), "node's parent should be" + parent.toString());
    }

    @Test
    public void cloneShouldDiffer() throws CloneNotSupportedException {
        BasicNode<Integer> node1 = new BasicNode<Integer>(6040);
        BasicNode<Integer> node2 = new BasicNode<Integer>(8260);
        BasicNode<Integer> node = new BasicNode<Integer>(500, node1, node2);
        BasicNode<Integer> cloned = node.clone();
        //TODO: check that data and meta are cloned!
        assertEquals(node.getData(), cloned.getData(), "node and cloned node should have same data");
        assertNotEquals(Integer.toHexString(node.hashCode()), Integer.toHexString(cloned.hashCode()), "cloned node should have dfferent hashcode");
        assertNotEquals(Integer.toHexString(node.getLeft().hashCode()), Integer.toHexString(cloned.getLeft().hashCode()), "cloned node's childs should have dfferent hashcodes");
        assertNotEquals(Integer.toHexString(node.getRight().hashCode()), Integer.toHexString(cloned.getRight().hashCode()), "cloned node's childs should have dfferent hashcodes");
    }
}
