package servicio;

import dominio.Doctor;
import dominio.Paciente;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class test {
    public static void main(String[] args) {
//        PacienteService ps = new PacienteService();
//        ps.actualizarPaciente(new Paciente("104711330", "Yisus", "Daniel", "Castro", "Mendoza", new Date(), "M", "Coosalud", "jesus@gmail.com", "3146627", null));
//        List li = ps.listarPacientes();
//        for (Object object : li) {
//            System.out.println("object = " + object);
//        }
//        var pa = ps.encontrarPaciente("1");
////        pa.setPrimerNombre("Yisus");
////        ps.actualizarPaciente(pa);
//        System.out.println("paciente = " + pa);
        citaa();
    }
    
    public static void recep(){
        RecepcionistaService recepcionistaService = new RecepcionistaService();
        var r = recepcionistaService.encontrarRecepcionista("10001");
        System.out.println("r = " + r);
    }
    
    public static void docto(){
        DoctorService ds = new DoctorService();
        System.out.println(ds.totalRegistros());
    }
    
    public static void citaa(){
        CitaService citaService = new CitaService();
        DoctorService ds = new DoctorService();
        Doctor doctor = ds.encontrarDoctor("1008829");
        List l = citaService.listarCitasDoctor(doctor);
        for (Object object : l) {
            System.out.println("object = " + object);
        }
    }
}
