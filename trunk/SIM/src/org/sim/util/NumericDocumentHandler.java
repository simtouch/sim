/*
 * Numerico.java
 *
 * Created on 20 de septiembre de 2007, 10:02 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.sim.util;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Franky Villadiego
 */
public class NumericDocumentHandler extends PlainDocument { 
    private JTextField editor; 
    private int numeroMaximoCaracteres; 

 
    public NumericDocumentHandler(JTextField editor, int numeroMaximoCaracteres) 
    { 
        this.editor=editor; 
        this.numeroMaximoCaracteres=numeroMaximoCaracteres; 
    } 

    public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException 
    { 
        if ((editor.getText().length()+arg1.length())>this.numeroMaximoCaracteres) 
            return; 
        for (int i=0;i<arg1.length();i++)
          if (EsCaracter(arg1.charAt(i))==true)
              return;
        super.insertString(arg0, arg1, arg2); 
    } 
    
    private boolean EsCaracter (char cadena){
        boolean resultado=false;
        if((cadena<'0') || (cadena>'9')){
            resultado=true;
        }
       return resultado;
    }
}

