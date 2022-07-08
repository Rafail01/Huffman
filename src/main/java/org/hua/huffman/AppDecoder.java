/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.huffman;

/**
 *
 * @author thanos
 */
public class AppDecoder {
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
        
        Decoder decoder = new Decoder();
        decoder.readHuffman(args);
        
    }
}
