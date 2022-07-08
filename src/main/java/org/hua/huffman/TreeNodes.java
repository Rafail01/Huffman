/**
 * This code is part of the Huffman Tree exercise for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.huffman;

import java.io.Serializable;

/**
 *
 * @author thanos, rafail, stavroula
 */
public class TreeNodes implements Comparable<TreeNodes>, Serializable {

    private int ASCIIletter;
    private int frequency;
    private TreeNodes leftChild;
    private TreeNodes rightChild;

    public TreeNodes() {
        ASCIIletter = 0;
        frequency = 0;
        leftChild = null;
        rightChild = null;
    }

    public void setASCIIletter(int ASCIIletter) {
        this.ASCIIletter = ASCIIletter;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setLeftChild(TreeNodes leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(TreeNodes rightChild) {
        this.rightChild = rightChild;
    }

    public int getASCIIletter() {
        return ASCIIletter;
    }

    public int getFrequency() {
        return frequency;
    }

    public TreeNodes getLeftChild() {
        return leftChild;
    }

    public TreeNodes getRightChild() {
        return rightChild;
    }
    
    
    @Override
    public int compareTo(TreeNodes myNode) {
        
        if (this.frequency > myNode.frequency) {
            return 1;
        }
        if (this.frequency < myNode.frequency) {
            return -1;
        } else {
            return 0;
        }
    }
    
}
