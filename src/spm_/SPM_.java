/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm_;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static spm_.Inheritance.analizeComplexityDueToInheritanceJ;

/**
 *
 * @author hratlk
 */
public class SPM_  {

    public static void main(String[] args) throws IOException {
        File fileJ = new File("C:\\Users\\hratlk\\Desktop\\n\\CodeN.txt");
        File fileC = new File("C:\\Users\\hratlk\\Desktop\\n\\CodeC.txt");
        File file123 = new File("C:\\Users\\hratlk\\Desktop\\n\\t123.txt");
        
        File file = file123;
        String allLines = null;
        String relatedLine = null;
        String lng = "Java";
        //String lng = "C";
        
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Inheritance inheritance = new Inheritance();
        Size size = new Size();
        Recursion recursion = new Recursion();
        ControlStructure controlStructure = new ControlStructure();

        int lineNo = 0;

        try {

            int Cnc = 0;
            int Ctc = 0;
            int Cs = 0;
            int TW = 0;

            while ((relatedLine = bufferedReader.readLine()) != null) {
                //get inheritance weight
                int CCi = inheritance.inheritance(file, lng);

                allLines = relatedLine.replace("(", " ");
                allLines = allLines.replace(")", " ");
                allLines = allLines.replace(";", " ");

                //methods
                //Remove unnessasary
                CCi = inheritance.checkInheritance(relatedLine, CCi);
                //Recursion
               boolean haveRecursion = recursion.calculateRecursion(relatedLine);
                //ControlStructure
                Ctc = controlStructure.getCtcValue(relatedLine);
                
                //Total weight (TW) of a program statement
                TW = Ctc + Cnc + CCi;
                lineNo++;

                System.out.print("Line No : " + lineNo + " &|Line : " + relatedLine + "&|Inheri" + CCi + "tw:" + TW + "\n");

            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Unable to open '" + file + "' file");
        } catch (IOException e) {
            System.out.println("Error of '" + file + "' file");
        }

    }

}
