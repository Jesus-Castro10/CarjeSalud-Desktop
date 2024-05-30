/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Component;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewerToolbar;
import net.sf.jasperreports.view.JRSaveContributor;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lenovo
 */
public class CustomJasperViewer extends JasperViewer{
    
    public CustomJasperViewer(JasperPrint jasperPrint) {
        super(jasperPrint);
    }

}
