/**
 * This code is part of the Huffman Tree exercise for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.huffman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author thanos, rafail, stavroula
 */
public class HuffmanTree implements Serializable{
    
    private MinHeap<TreeNodes> queue;
    
    public void huffmanCoding() throws IOException {
        getFileData();
        
        TreeNodes root = new TreeNodes();
        while(queue.size() > 1) {
            TreeNodes tmpLeftNode = new TreeNodes();
            tmpLeftNode = queue.findMin();
            queue.deleteMin();
            
            TreeNodes tmpRightNode = new TreeNodes();
            tmpRightNode = queue.findMin();
            queue.deleteMin();
            
            TreeNodes fusedNode = new TreeNodes();
            fusedNode.setASCIIletter(-1);
            fusedNode.setFrequency(tmpLeftNode.getFrequency() + tmpRightNode.getFrequency());
            fusedNode.setLeftChild(tmpLeftNode);
            fusedNode.setRightChild(tmpRightNode);
            
            root = fusedNode;
            
            queue.insert(fusedNode);
        }
        
        try {
            FileOutputStream treeFile = new FileOutputStream("tree.dat");
            ObjectOutputStream treeObject = new ObjectOutputStream(treeFile);
            treeObject.writeObject(root);
            treeObject.close();
        } catch(IOException e) {
            System.out.println(e);
        }
    }
    
    private void getFileData() throws FileNotFoundException, IOException {
        BufferedReader inputFile = null;
        
        queue = new ArrayMinHeap<>();
        try {
            inputFile = new BufferedReader(new FileReader("frequencies.dat"));
            String line = inputFile.readLine();

            int i = 0;
            int ASCIIletter = 0;
            int frequency = 0;
            while (line != null) {
                String[] splitedLines = line.split("-");
                ASCIIletter = Integer.parseInt(splitedLines[0]);
                frequency = Integer.parseInt(splitedLines[1]);
                
                TreeNodes newNode = new TreeNodes();
                newNode.setASCIIletter(ASCIIletter);
                newNode.setFrequency(frequency);
                newNode.setLeftChild(null);
                newNode.setRightChild(null);
                
                queue.insert(newNode);
                
                line = inputFile.readLine();
            }
            
        } finally {
            inputFile.close();
        }
    }
}
