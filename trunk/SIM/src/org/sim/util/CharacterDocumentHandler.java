/*
 * LimitaCar.java
 *
 * Created on 30 de septiembre de 2007, 12:33 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.sim.util;

/**
 *
 * @author Franky Villadiego
 */
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class CharacterDocumentHandler extends PlainDocument {
    private JTextField editor;
    private int numeroMaxCar; 
    private boolean numerico;
    private boolean mayusculas;
 
    public CharacterDocumentHandler(int numeroMaxCar, boolean numerico,boolean mayusculas, JTextField editor)
    { 
        this.numerico=numerico;
        this.numeroMaxCar=numeroMaxCar; 
        this.mayusculas=mayusculas;
        this.editor=editor;
    } 

    public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException 
    { 
        if(arg1==null)
            return;
        
        if ((editor.getText().length()+arg1.length())>this.numeroMaxCar) {
            //JOptionPane.showMessageDialog(null, editor.getText().length());
            return; 
        }
        char [] cadena=arg1.toCharArray();        
        for (int i=0;i<cadena.length;i++){
            if(numerico==true){
                if (EsCaracter(cadena[i])==true)
                    return;
            }else{
               cadena[i]=Character.toUpperCase(cadena[i]);
            }
        }
         super.insertString(arg0, new String(cadena) , arg2);             
    } 
    
    private boolean EsCaracter (char cadena){
        boolean resultado=false;
        if((cadena<'0') || (cadena>'9')){
            resultado=true;
        }
       return resultado;
    }
}