/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm_;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author hratlk
 */
public class Recursion {
      public boolean calculateRecursion(String line){
      int leftBraces = 0;
      int rightBraces = 0;
      List<String> methodList = new ArrayList<>();
      boolean isMethodFound = false;
      int count = 1;
      String[] returnTypes = {"void", "int", "float", "double", "String"};
      
          // while(line != null){ >>to stop infinite lope and no nned sine 
      //need to check in one sentence which send as string parameter to this method
                boolean isPotentialMehtod = false;
                boolean isFirstLine = false;
                
                if(!line.contains("\"") && line.contains(" ")){
                    line = line.trim();
                    String[] parts = line.split(" ");
                    parts[0] = parts[0].trim();
                    
                   // System.out.println("parts[0]: " + parts[0]); >> this line no needs to print
                    
                    for (String returnType: returnTypes) {
                        if(parts[0].equals("public") || parts[0].equals("static") || parts[0].equals(returnType)){
                            line = line.replaceAll("public", " ");
                            line = line.replaceAll("static", " ");
                            line = line.replaceAll(returnType, " ");
                            isPotentialMehtod = true;
                        }
                    }
                    
                    if(line.contains("(") && isPotentialMehtod){
                        String[] method = line.split(Pattern.quote("("));
                        
                        if(!method[0].trim().isEmpty()){
                          //  System.out.println("Method name: " + method[0].trim()); >>print statements no needs here
                            methodList.add(method[0].trim());
                            isMethodFound = true;
                            isFirstLine = true;
                        }
                    }
                }
                
                if(!line.contains("\"") && line.contains("}") && isMethodFound){
                    rightBraces++;
                }
                if(!line.contains("\"") && line.contains("{") && isMethodFound){
                    leftBraces++;
                }
                
                //check whether the recursive method is called inside the scope
                if(line.contains(" ") && isMethodFound){
                    String[] parts = line.split(" ");
                    
                    line = line.replaceAll(Pattern.quote("("), " ");
                    line = line.replaceAll(Pattern.quote(")"), " ");
                    
                    String[] subParts = line.split(" ");
                    
                    for(String part:subParts){
                        if(methodList.contains(part.trim()) && !part.contains("\"") && !isFirstLine){
                            System.out.println(part + "is a recursive method and it is found in line no. " + count);
                        }
                    }
                }
                
                if((leftBraces == rightBraces) && (leftBraces > 0) && (rightBraces > 0)){
                    System.out.println("The method ends at line no. " + count + "and braces count is " + leftBraces);
                    
                    isMethodFound = false;
                    leftBraces = 0;
                    rightBraces = 0;
                    methodList.clear();
                }
                
               // System.out.println(line);
                isFirstLine = false;
                count++;
                
                //read next line
              //  line = reader.readLine();
           // }
            //System.out.println("Potential recursive methods are: \n===============================================\n");
            
            //for(String m:methodList){
            //    System.out.println("Method: " + m);
            //}
           return true;
    }
}
