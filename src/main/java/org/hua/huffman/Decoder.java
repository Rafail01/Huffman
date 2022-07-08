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
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author thanos
 */
public class Decoder {

    public void readHuffman(String[] args) throws ClassNotFoundException {
        if (args.length != 2) {
            System.out.println("Please provide input and output files!");
            System.exit(0);
        }

        File deleteFile = new File(args[1]);
        deleteFile.delete();

        try {
            File file = new File(args[0]);
            InputStream inputFile = new FileInputStream(file);
            long inputFileLength = file.length();
            int fileLength = (int) inputFileLength;
            int[] fileBits = new int[fileLength];

            int c = 0;
            int i = 0;
            while ((c = inputFile.read()) != -1) {
                if (c == 48) {
                    fileBits[i] = 0;
                } else {
                    fileBits[i] = 1;
                }
                i++;
            }
            traverseTreeFile(fileBits, args);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void traverseTreeFile(int[] fileBits, String[] args) throws ClassNotFoundException {
        TreeNodes root;
        try {
            FileInputStream treeFile = new FileInputStream("tree.dat");
            ObjectInputStream treeObject = new ObjectInputStream(treeFile);
            root = (TreeNodes) treeObject.readObject();

            int i = 0;
            TreeNodes curNode = root;
            String leafLetter = "";
            while (i < fileBits.length) {
                if (fileBits[i] == 0) {
                    curNode = curNode.getLeftChild();
                } else {
                    curNode = curNode.getRightChild();
                }
                if (curNode.getLeftChild() == null && curNode.getRightChild() == null) {
                    leafLetter = String.format("%8s", Integer.toBinaryString(curNode.getASCIIletter())).replace(' ', '0');

                    BufferedWriter writer = null;
                    try {
                        writer = new BufferedWriter(new FileWriter(args[1], true));
                        writer.write(leafLetter);
                        writer.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }

                    curNode = root;
                }
                i++;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}