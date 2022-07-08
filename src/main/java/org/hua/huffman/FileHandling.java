/**
 * This code is part of the Huffman Tree exercise for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.huffman;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URL;

/**
 *
 * @author thanos, rafail, stavroula
 */
public class FileHandling {
    
    private String gutenbergUrl;
    
    public FileHandling() {
        this.gutenbergUrl = "";
    }

    public void setGutenbergUrl(String gutenbergUrl) {
        this.gutenbergUrl = gutenbergUrl;
    }
    
    public void countLettersFrequency(int frequencyArray[]) throws Exception {
        URL file = new URL(gutenbergUrl);
        BufferedReader in = null;
        Writer out = null;
        try {
            in = new BufferedReader(new InputStreamReader(file.openStream()));
            out = new FileWriter("frequencies.dat");
            int inputChar;
            while ((inputChar = in.read()) != -1) {
                if (inputChar >= 0 && inputChar <= 127) {
                    frequencyArray[inputChar] += 1;
                }
            }

            for (int i = 0; i < frequencyArray.length; i++) {
                out.write(i + "-" + frequencyArray[i] + "\n");
            }

        } finally {
            in.close();
            out.close();
        }
        
    }
      
}
