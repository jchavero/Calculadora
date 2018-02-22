/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

import Pilas.PilaA;
import java.util.*;

/**
 *
 * @author jerusa
 */
public class ConvierteExpresion {
    PilaA <Character> pila= new PilaA<Character>();
    private String expresionIn;
    private String expresionPre;
    StringBuilder sb=new StringBuilder();
    
    
    public ConvierteExpresion(String expresionIn){
        this.expresionIn=expresionIn;
    }
    
    
    
    
    public int prioridadOperando(char o){
        int i=0;
        
        if(o=='^')
            i=0;
        else{
            if(o=='*' || o=='/')
                i=i-1;
            else{
                if(o=='+' || o=='-')
                    i=i-2;
            }
        }
        return i;
            
    }
    
    public String convierteExpresion(){
        int i=0, k=0, j;
        char variable, charFE;
        ArrayList<Character> expresionP=new ArrayList<Character>();
        
        while(i<expresionIn.length()){
            variable=expresionIn.charAt(i);
            if(variable!='+' && variable!='-' && variable!='*' && variable!='^' && variable!='/' && variable!='(' && variable!=')')
                expresionP.add(variable);
            else{
            if(variable=='(')
                pila.push(variable);
            else{
                if(variable==')'){
                while(!pila.isEmpty() && pila.peek()!='('){
                    charFE=pila.pop();
                    expresionP.add(charFE);
                }
                pila.pop();
                }
                else{
                    if(variable=='+' || variable=='-' || variable=='*' || variable=='^' || variable=='/'){
                        while(!pila.isEmpty() && prioridadOperando(variable)<=prioridadOperando(pila.peek()) && pila.peek()!='('){
                            //&& prioridad del operando <=prioridad de pila.peek()
                            charFE=pila.pop();
                            expresionP.add(charFE);
                    }
                        pila.push(variable);
                }
                    
                
            }
            
        }
        }
            i++;
    }
        while(!pila.isEmpty()){
            charFE=pila.pop();
            expresionP.add(charFE);
        }
        
        for(j=0;j<expresionP.size();j++){
            sb.append(expresionP.get(j));
        }
        
        return sb.toString();
    
    
}
}
