/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Lenovo
 */
public class FuncionesVista {
    
    public Icon crearIcono(String path) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        return img;
    }
}
