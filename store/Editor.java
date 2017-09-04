/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

/**
 *
 * @author Joseph
 */
public class Editor {
        //Add spaces for description with integer and integer
        public Editor(){};
    
        public StringBuilder addSpaces(int n, int descriptionLength){
        StringBuilder whiteSpaces = new StringBuilder();
        n = n - descriptionLength;
        for (int i = 0; i < n; i++){
            whiteSpaces.append(" ");
        }
        
        return whiteSpaces;
    }
        
        //Add spaces for descriptions with integer and double
        public StringBuilder addSpaces2(int n, double descriptionLength){
        StringBuilder whiteSpaces = new StringBuilder();
        String testDouble = Double.toString(descriptionLength);
        n = n - testDouble.length();
        for (int i = 0; i < n-testDouble.length(); i++){
            whiteSpaces.append(" ");
        }
        
        return whiteSpaces;
    }
}
