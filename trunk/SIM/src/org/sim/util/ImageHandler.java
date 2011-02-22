/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.util;

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
}
