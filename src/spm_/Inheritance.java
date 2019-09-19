/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm_;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author hratlk
 */
public class Inheritance {

    public int inheritance(File file, String lng) throws FileNotFoundException, IOException {
        int CCi = 0;

        if (lng == "Java") {
            CCi = analizeComplexityDueToInheritanceJ(file) + 1;
            // System.out.println("Enter a invalid language."+CCi);
            if (CCi == 1) {
                CCi=0;
            }
            return CCi;
        } else if (lng == "C++") {
            CCi = analizeComplexityDueToInheritanceC(file) + 1;
             if (CCi == 1) {
               CCi=0;
            }
            return CCi;
        } else {
            System.out.println("Enter a invalid language.");
            return 0;
        }

    }

    public static int analizeComplexityDueToInheritanceJ(File file) throws FileNotFoundException {
        int count = 0;
        int lineNo = 0;
        String word = "extends";
        word = word.trim();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String nextWord = scanner.next().trim();
            if (nextWord.equals(word)) {
                ++count;
            }
            lineNo++;
            //System.out.println("Line no is" + count);
        }
        return count;
    }

    public static int analizeComplexityDueToInheritanceC(File file) throws FileNotFoundException, IOException {

        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);

        int count = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.contains("class") && line.contains(":")) {
                if (line.contains("public")) {
                    count++;
                }
                if (line.contains("protected")) {
                    count++;
                }
                if (line.contains("private")) {
                    count++;
                }
            }
        }
        return count;
    }

    public int checkInheritance(String relatedLine, int cci) {
        int CCi = cci;
        //avoid unnessary lines
        if (relatedLine.contains(" { ")) {
            cci = 0;
        }
        if (relatedLine.contains(" } ")) {
            cci = 0;
        }
        if (relatedLine.contains("//")) {
            CCi = 0;
        }
        if (relatedLine.contains("/*")) {
            CCi = 0;
        }
        if (relatedLine.contains("*/")) {
            CCi = 0;
        }
        if (relatedLine.contains("import")) {
            CCi = 0;
        }
        if (relatedLine.contains("package")) {
            CCi = 0;
        }
        if (relatedLine.contains("try")) {
            CCi = 0;
        }
        return CCi;
    }

}
