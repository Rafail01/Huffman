/**
 * This code is part of the Huffman Tree exercise for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.huffman;

/**
 *
 * @author thanos, rafail, stavroula
 */
public class AppEncoder {

    public static void main(String[] args) throws Exception {
        int frequencyArray[] = new int[128];
        
        FileHandling file1 = new FileHandling();
        file1.setGutenbergUrl("https://www.gutenberg.org/files/1342/1342-0.txt");
        file1.countLettersFrequency(frequencyArray);
        
        FileHandling file2 = new FileHandling();
        file2.setGutenbergUrl("https://www.gutenberg.org/files/11/11-0.txt");
        file2.countLettersFrequency(frequencyArray);
        
        FileHandling file3 = new FileHandling();
        file3.setGutenbergUrl("https://www.gutenberg.org/files/2701/2701-0.txt");
        file3.countLettersFrequency(frequencyArray);
        
        HuffmanTreeCoding code = new HuffmanTreeCoding();
        code.coding();
        
        Encoder encoder = new Encoder();
        encoder.readASCII(args);
        
    }
}

