/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm_;

import java.util.StringTokenizer;

/**
 *
 * @author hratlk
 */
public class ControlStructure {
    private int lineWeight;
    private String[] ifElseKeywords = {"if(", "else{", "if", "else"};
    private String[] loopsKeywords = {"while", "while(", "for(", "for", "do-while(", "do-while", "foreach", "foreach("};
    private String[] switchStatementKeywords = {"case:", "case", "switch", "switch{"};
    private String[] operatorKeywords = {"&&", "||", "&", "|"};
    
    public ControlStructure() {
    }
    
    public int getCtcValue(String inputLineVal) {
        String lineWord;
        boolean conditionBooleanVal = false;
        boolean iterativeBooleanVal = false;
        boolean operatorBooleanVal = false;
        int count = 0;
        lineWeight = 0;

        StringTokenizer stTokenizer = new StringTokenizer(inputLineVal);
        while (stTokenizer.hasMoreTokens()) {

            //which allows to break words in each inputLineVal
            lineWord = stTokenizer.nextToken();

            //checking for conditional keywords
            for (int i = 0; i < ifElseKeywords.length; i++) {
                if (ifElseKeywords[i].equals(lineWord)) {
                    lineWeight++;
                    conditionBooleanVal = true;
                }
            }

            //checking for iterativeBooleanVal keywords
            for (int i = 0; i < loopsKeywords.length; i++) {
                if (loopsKeywords[i].equals(lineWord)) {
                    iterativeBooleanVal = true;
                    lineWeight++;
                }
            }

            for (int i = 0; i < switchStatementKeywords.length; i++) {
                //for conditional keywords
                if (switchStatementKeywords[i].equals(lineWord)) {
                    lineWeight += 2;
                }
            }

            for (int i = 0; i < operatorKeywords.length; i++) {
                if (operatorKeywords[i].equals(lineWord)) {
                    operatorBooleanVal = true;
                    count++;
                }
            }

            
        }


        if (conditionBooleanVal && operatorBooleanVal) {
            lineWeight += count;
        } else if (iterativeBooleanVal && operatorBooleanVal) {
            lineWeight += count;
        }

        return lineWeight;
    }
}
