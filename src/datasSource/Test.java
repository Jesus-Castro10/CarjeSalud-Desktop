/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datasSource;

import dominio.Cita;
import dominio.Medicamento;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import servicio.CitaService;
import util.CustomJasperViewer;

/**
 *
 * @author Lenovo
 */
public class Test {

    public Test() {
        Object[][] m = {{1,"Sevedol","Tomar cada noche",30}, {2,"Omeprazol","Tomar cada noche",30}
                ,{3,"Ibuprofeno","Tomar cada noche",30},{4,"Advil","Tomar cada noche",30}
                ,{4,"Advil","Tomar cada noche",30}};
//        RecetaDataSource rds = new RecetaDataSource(medicamentos);
            List<Medicamento> medicamentos = new ArrayList<>();
            medicamentos.add(new Medicamento(1,"Sevedol","Tomar cada noche",30));
            medicamentos.add(new Medicamento(2,"Omeprazol","Tomar cada noche",30));
            medicamentos.add(new Medicamento(3,"Ibuprofeno","Tomar cada noche",30));
            medicamentos.add(new Medicamento(4,"Advil","Tomar cada noche",30));
            medicamentos.add(new Medicamento(4,"Advil","Tomar cada noche",30));
        try {
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(medicamentos);
            String ruta = System.getProperty("user.dir") + "\\src\\reportes\\receta.jrxml";
//            Cita cita = new CitaService().encontrarCita(11);
            Map<String,Object> parameters = new HashMap<>();
            parameters.put("paciente_id", "1009");
            parameters.put("nombre_paciente", "Jesus Castro");
            parameters.put("sexo", "Masculino");
            parameters.put("eps", "Coosalud");
            parameters.put("fecha_cita", "12/12/2000");
            parameters.put("medico", "Jose Jose");
            parameters.put("especialidad", "Ortopedia");
            parameters.put("edad", "");
            
            
//            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/receta.jasper"));
            JasperReport report = JasperCompileManager.compileReport(ruta);
            JasperPrint jprint = JasperFillManager.fillReport(report,parameters , dataSource);
//            JasperPrint jprint = JasperFillManager.fillReport(report, null, RecetaDataSource.getDataSource(m,cita));
            JasperViewer view = new JasperViewer(jprint, false);    
//            JasperViewer view = new CustomJasperViewer(jprint);
            view.setVisible(true);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
            Collection c = dataSource.getData();
            for (Object object : c) {
                System.out.println("object = " + object);
            }
        } catch (JRException ex) {
            System.out.println("Y mi jOption?");
            System.out.println("ex = " + ex.getMessage());
            System.out.println("ex = " + ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
    }
}
