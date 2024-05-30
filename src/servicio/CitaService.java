package servicio;

import dominio.Cita;
import dominio.Doctor;
import java.util.List;
import repositorio.CitaRepository;

/**
 *
 * @author Jesus Castro
 */
public class CitaService {
    
    private CitaRepository citaRepository;

    public CitaService() {
        this.citaRepository = new CitaRepository();
    }

    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    public Cita encontrarCita(Integer codigo) {
        return citaRepository.findById(codigo);
    }

    public Cita guardarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public void eliminarCita(Cita cita) {
        citaRepository.delete(cita);
    }
    
    public void actualizarCita(Cita cita){
        citaRepository.update(cita);
    }
    
    public List<Cita> listarCitasDoctor(Doctor doctor){
        return citaRepository.findAllByDoctor(doctor);
    }
    
    public long totalCitas(){
        return citaRepository.count();
    }
}