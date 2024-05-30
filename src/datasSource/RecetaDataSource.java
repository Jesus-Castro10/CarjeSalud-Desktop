/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datasSource;

import dominio.Cita;
import dominio.Historia;
import dominio.Paciente;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import org.json.JSONArray;
import org.json.JSONObject;
import servicio.HistoriaService;
import util.FuncionesForm;
import util.FuncionesPersona;

/**
 *
 * @author Lenovo
 */
public class RecetaDataSource implements JRDataSource {

    private final Object[][] data;
    private int index;
    private Paciente paciente;
    private Historia historia;
    private HistoriaService historiaService = new HistoriaService();

    public RecetaDataSource(Paciente paciente) {
        this.index = -1;
        this.paciente = paciente;
        this.historia = historiaService.encontrarHistoriaPaciente(paciente).get(0);
        int length = new JSONArray(historia.getMedicamentos()).length();
        data = new Object[length][4];
        recuperarMedicamentos();
    }

    @Override
    public boolean next() throws JRException {
        index++;
        return (index < data.length);
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object value = null;
        String fieldName = jrf.getName();
        JSONObject cita = new JSONObject(historia.getCita());
        switch (fieldName) {
            case "idMedicamento" -> {
                value = data[index][0];
            }
            case "nombreMedicamento" -> {
                value = data[index][1];
            }
            case "posologia" -> {
                value = data[index][2];
            }
            case "cantidad" -> {
                value = data[index][3];
            }
            case "paciente_id" -> {
                value = paciente.getNumeroDocumento();
            }
            case "nombre_paciente" -> {
                value = paciente.getFullName();
            }
            case "sexo" -> {
                value = paciente.getSexo();
            }
            case "eps" -> {
                value = paciente.getEps();
            }
            case "medico" -> {
                value = cita.get("doctor");
            }
            case "especialidad" -> {
                value = cita.get("tipo");
            }
            case "fecha_cita" -> {
                value = cita.get("fecha");
            }
            case "edad" -> {
                value = FuncionesPersona.obtenerEdad(paciente);
            }
        }
        return value;
    }

    private void recuperarMedicamentos() {
        JSONArray array = new JSONArray(historia.getMedicamentos());
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(0);
            data[i][0] = i + 1;
            data[i][1] = object.get("medicamento");
            data[i][2] = object.get("posologia");
            data[i][3] = Integer.valueOf(object.get("cantidad").toString());
        }
    }

    public static JRDataSource getDataSource(Paciente paciente) {
        return new RecetaDataSource(paciente);
    }
}
