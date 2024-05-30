package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Lenovo
 */
public class Reportes {
    
    public static void exportarExcel(JTable table) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xlsx");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Guardar reporte");
        fileChooser.setDialogType(2);
        fileChooser.setAcceptAllFileFilterUsed(false);
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = fileChooser.getSelectedFile().toString().concat(".xlsx");
            try {
                File archivoXLSX = new File(ruta);
                if (archivoXLSX.exists()) {
                    archivoXLSX.delete();
                }
                archivoXLSX.createNewFile();
                Workbook libro = new XSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLSX);
                Sheet hoja = libro.createSheet("Reporte");
                for (int i = 0; i < table.getRowCount(); i++) {
                    Row fila = hoja.createRow(i);
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        Cell celda = fila.createCell(j);
                        if (i == 0) {
                            celda.setCellValue(table.getColumnName(j));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < table.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < table.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (table.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(table.getValueAt(f, c).toString()));
                        } else if (table.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat(table.getValueAt(f, c).toString()));
                        } else {
                            celda.setCellValue(String.valueOf(table.getValueAt(f, c)));
                        }
                    }
                }
                libro.write(archivo);
                archivo.close();
//                Desktop.getDesktop().open(archivoXLSX);
            } catch (IOException ex) {
                System.err.println("Error exportar excel : " + ex.getMessage());
            }
        }
    }
    
    public static void crearReportePdf(String rutaArchivo,JRDataSource dataSource){
        try {
            JasperReport report = JasperCompileManager.compileReport(rutaArchivo);
            JasperPrint jprint = JasperFillManager.fillReport(report, null, dataSource);
            JasperViewer view = new JasperViewer(jprint, false);    
            view.setVisible(true);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
