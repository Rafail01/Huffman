/**
 * This code is part of the Huffman Tree exercise for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.huffman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;

/**
 *
 * @author thanos, rafail, stavroula
 */
public class Encoder {

    public void readASCII(String[] args) throws FileNotFoundException, IOException {
        if (args.length != 2) {
            System.out.println("Please provide input and output files!");
            System.exit(0);
        }

        File deleteFile = new File(args[1]);
        deleteFile.delete();

        int counter = 0;
        try {
            File file = new File(args[0]);
            InputStream inputFile = new FileInputStream(file);
            long inputFileLength = file.length();
            byte[] fileBits = new byte[8];

            for (int i = 8; i < inputFileLength; i += 8) {
                inputFile.read(fileBits, 0, 8);
                String byteString = new String(fileBits);

                int decimal = Integer.parseInt(byteString, 2);
                String decimalString = String.valueOf(decimal);
                counter += countOutputFileBits(decimalString);
            }
            inputFile.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }

            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(args[1], true));
                String counterString = String.valueOf(counter);
                writer.write(counterString);
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }

        try {
            File file = new File(args[0]);
            InputStream inputFile = new FileInputStream(file);
            long inputFileLength = file.length();
            byte[] fileBits = new byte[8];
            for (int i = 8; i < inputFileLength; i += 8) {
                inputFile.read(fileBits, 0, 8);
                String byteString2 = new String(fileBits);

                int decimal = Integer.parseInt(byteString2, 2);
                String decimalString = String.valueOf(decimal);
                searchCodesFile(decimalString, args);
            }

            inputFile.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private int countOutputFileBits(String decimal) {
        BufferedReader inputFile = null;
        try {
            inputFile = new BufferedReader(new FileReader("codes.dat"));
            String line = inputFile.readLine();

            int decimalCoding = 0;
            int huffCoding = 0;
            boolean found = false;
            while (line != null && found == false) {
                String[] splitedLines = line.split("-");
                if (splitedLines[0].equals(decimal)) {
                    found = true;

                    return splitedLines[1].length();
                }

                line = inputFile.readLine();

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    private void searchCodesFile(String decimal, String[] args) {

        BufferedReader inputFile = null;
        try {
            inputFile = new BufferedReader(new FileReader("codes.dat"));
            String line = inputFile.readLine();

            int decimalCoding = 0;
            int huffCoding = 0;
            boolean found = false;
            while (line != null && found == false) {
                String[] splitedLines = line.split("-");
                if (splitedLines[0].equals(decimal)) {
                    found = true;

                    BufferedWriter writer = null;
                    try {
                        writer = new BufferedWriter(new FileWriter(args[1], true));
                        writer.write(splitedLines[1]);
                        writer.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }

                line = inputFile.readLine();

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
