## **Huffman** project
**part of the Huffman Tree exercise for the Data Structures course at Harokopio University of Athens, Dept. of Informatics and Telematics.**

## Sections
- [**Detailed Description**](#detailed-description)
    - [**Frequency Table**](#frequency-table)
    - [**Huffman Tree Implementation**](#huffman-tree-implementation)
    - [**Codification Implementation**](#codification-implementation)
    - [**Encoder**](#encoder)
    - [**Decoder**](#decoder)
- [**Getting Started**](#getting-started)
    - [**Classes**](#classes)
    - [**Usage**](#usage)
- [**Authors**](#authors)
- [**Acknowledgments**](#acknowledgments)

---
---

## *Detailed Description*

---

## Frequency Table

> **The first part of the project reads three links of e-books then calculates a table of frequencies for letters with ASCII from 0 to 127 and creates a frequencies.dat file with the output.**

---

## Huffman Tree Implementation

> **The second part of the project reads from the frequencies.dat file the frequency table, adds it to a priority queue and produces a Huffman tree**

---

## Codification Implementation

> **The third part of the project reads from the tree.dat file the huffman tree and then traverses it and creates the coding with 1 and 0 for every ASCII character. Finallly the result is written to a codes.dat file.**

---

## Encoder

> **The fourth part of the project reads an input file from the command line written in ascii coding and creates an output file based on the input but in huffman coding(run main from AppEncoder class).**

---

## Decoder

> **The fifth and last part of the project reads an input file from the command line written in huffman coding and creates an output file based on the input but in ascii coding(run main from AppDecoder class).**

---
---

## *Getting Started*

---

## Classes

The project is consists of the classes:

- **AppEncoder (main)**
- **AppDecoder (main)**
- **FileHandling**
- **TreeNodes**
- **HuffmanTree**
- **MinHeap**
- **ArrayMinHeap**
- **HuffmanTreeCoding**
- **Encoder**
- **Decoder**

---

## Usage

Compile using

    mvn compile

Create a jar using

    mvn package

Run main using

    java -cp target/huffman-1.0-SNAPSHOT.jar org.hua.huffman.App



---
---

## Authors

*Stavroula Pratth* (it219151)

*Rafail Ntymenos* (it21965)

*Athanasios Ntelis* (it21963)

---

## Acknowledgments
- [Oracle: Basic I/O tutorial](https://docs.oracle.com/javase/tutorial/essential/io/index.html)
- [How to open and read from a URL in Java by Alvin Alexander](https://alvinalexander.com/blog/post/java/how-open-read-url-java-url-class-example-code/)
- [README-Template by DomPizzie](https://gist.github.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc)
- [Introduction to Markdown by James Q Quick](https://www.youtube.com/watch?v=pTCROLZLhDM)
- [Bufferedreader-readline](https://www.tutorialspoint.com/java/io/bufferedreader_readline.html)
- [Split a String](https://www.guru99.com/how-to-split-a-string-in-java.html)
- [ObjectStreams](https://docs.oracle.com/javase/tutorial/essential/io/objectstreams.html)
- [Comparable](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)

- [Java: write to a file](https://www.baeldung.com/java-write-to-file)
- [Traverse a tree using recursion](https://www.geeksforgeeks.org/dfs-traversal-of-a-tree-using-recursion/)
- [Add character to srting](https://java2blog.com/add-character-to-string-java/)
- [Delete a file using Java](https://www.geeksforgeeks.org/delete-file-using-java/)
- [Oracle: Command-Line Arguments](https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html)
- [stackoverflow: netbeans how to set command line arguments in java](https://stackoverflow.com/questions/9168759/netbeans-how-to-set-command-line-arguments-in-java)
- [Reading binary file into byte array in Java](https://www.roseindia.net/java/javafile/java-read-binary-file-into-byte-array.shtml)
- [Java: binary to decimal](https://www.javatpoint.com/java-binary-to-decimal)
- [Java: decimal to binary](https://www.javatpoint.com/java-int-to-string)
- [stackoverflow: Get total size of file in bytes](https://stackoverflow.com/questions/14478968/get-total-size-of-file-in-bytes)
- [Decimal to Binary in Java](https://www.javatpoint.com/java-decimal-to-binary)
- [How to add 0s in front of a binary number](https://stackoverflow.com/questions/22539995/how-to-add-0s-in-front-of-a-binary-number)
- [Binary to Decimal Convertor](https://www.rapidtables.com/convert/number/binary-to-decimal.html)