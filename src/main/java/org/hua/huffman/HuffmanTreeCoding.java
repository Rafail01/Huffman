/**
 * This code is part of the Huffman Tree exercise for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.huffman;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author thanos, rafail, stavroula
 */
public class HuffmanTreeCoding {

    private TreeNodes root;

    public void coding() throws IOException, ClassNotFoundException {
        HuffmanTree newTree = new HuffmanTree();
        newTree.huffmanCoding();

        try {
            FileInputStream treeFile = new FileInputStream("tree.dat");
            ObjectInputStream treeObject = new ObjectInputStream(treeFile);
            root = (TreeNodes) treeObject.readObject();

            File file = new File("codes.dat");
            file.delete();

            if (root == null) {
                return;
            }
            treeTraverse(root.getLeftChild(), "0");
            treeTraverse(root.getRightChild(), "1");

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void treeTraverse(TreeNodes node, String code) throws IOException {
        if (node == null) {
            return;
        }
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter("codes.dat", true));

                writer.write(node.getASCIIletter() + "-" + code + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }

        }
        treeTraverse(node.getLeftChild(), code + "0");
        treeTraverse(node.getRightChild(), code + "1");
    }

}

//
//  2ND TRY:
//    public ArrayDeque getCode() {
//        ArrayDeque code = new ArrayDeque();
//        if (root == null) {
//            return null;
//        }
//        traverse(code, root.getLeftChild(), "0");
//        traverse(code, root.getRightChild(), "1");
//        return code;
//    }
//
//    private void traverse(ArrayDeque code, TreeNodes node, String path) {
//        if (node == null) {
//            return;
//        }
//        if(node.getLeftChild() == null && node.getRightChild() == null) {
//            System.out.println(node.getASCIIletter() + ": " + path); 
//        }
//        traverse(code, node.getLeftChild(), path = "0");
//        traverse(code, node.getRightChild(), path = "1");
//        
//        code.add(path);
//    }
//
//}
//
//
//  1ST TRY:
//    public Iterator iterator() {
//        return new InorderIterator();
//    }
//
//    private class InorderIterator implements Iterator {
//
//        private Deque deque;
//        private String code = "";
//
//        public InorderIterator() {
//            deque = new ArrayDeque<>();
//            pushAllLeft(root);
//        }
//
//        @Override
//        public boolean hasNext() {
//            return !deque.isEmpty();
//        }
//
//        @Override
//        public LinkCodingData next() {
//            if (!hasNext()) {
//                throw new NoSuchElementException();
//            }
//            TreeNodes cur = (TreeNodes) deque.pop();
//            if (cur.getRightChild() != null) {
//                pushAllLeft(cur.getRightChild());
//            }
//            
//            if (cur.getLeftChild() == null && cur.getRightChild() == null) {
//                System.out.println(cur.getASCIIletter());
//                return new LinkCodingData(cur.getASCIIletter(), code);
//            }
//            
//            
//        }
//
//        private void pushAllLeft(TreeNodes x) {
//            while (x != null) {
//                deque.push(x);
//                x = x.getLeftChild();
//            }
//        }
//
//    }
//}
//
//
//[a, "01"] -> "a: 10"
//[b, "010"] -> "b: 1001"
//...
//[z, "10101010"] -> "z: 1000110110"
//public class linkCodeData {
//    public char ASCIIchar;
//    public String code;
//    
//    public linkCodeData(char c, String code) {
//        ASCIIchar = c;
//        this.code = code;
//    }
//    
//    public String toString() {
//        return c + ": " code;
//    }
//}
