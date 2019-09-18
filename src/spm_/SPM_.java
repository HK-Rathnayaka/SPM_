/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm_;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hratlk
 */
public class SPM_ {

    public static void main(String[] args) {
  

        System.out.println("Hi Girls  ");

    }

    public int analyze(String fileName) {

        Inheritance inheritance = new Inheritance();
        ControlStructure controlStructure = new ControlStructure();
        Recursion recursion = new Recursion();
        Size size = new Size();

        int complexitySize = 0;
        int complexityControlStructure = 0;
        int complexityInheritance = 0;
        int complexityRecursion = 0;
        int complexity = 0;

        // 1. read the file and load data to a list of strings
        ArrayList<String> lines = loadFile(fileName);

        for (String line : lines) {
            complexitySize += size.analizeComplexityDueToSize(line);
            complexityControlStructure += controlStructure.analizeComplexityDueControlStructure(line);
            complexityInheritance += inheritance.analizeComplexityDueToInheritance(line);
            complexityRecursion += recursion.analizeComplexityDueToRecursion(line);
        }
        return complexity;
    }

    private ArrayList<String> loadFile(String fileName) {
        Scanner s = null;
        try {
            s = new Scanner(new File("filepath"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNext()) {
            list.add(s.next());
        }
        s.close();
        return list;
    }

}
