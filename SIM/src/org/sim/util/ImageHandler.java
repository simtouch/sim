/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.sim.view.Main;

/**
 *
 * @author Franky Villadiego
 */
public final class ImageHandler {

    private ImageHandler(){

    }

    public static Icon createIcon(String imageName){
        Icon i=new ImageIcon(Main.imagePath+File.separator+imageName);
        return i;
    }
    /**
     * Retorna un objeto Image
     * @param imageName
     * @return
     */
    public static Image cretaeImage(String imageName){
        String classPath="org/sim/view/images/";
        Image i = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(classPath+imageName));
        return i;
    }
}
