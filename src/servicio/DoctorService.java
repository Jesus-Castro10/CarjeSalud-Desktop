package servicio;

import dominio.Doctor;
import java.util.List;
import repositorio.DoctorRepository;

/**
 *
 * @author Lenovo
 */
public class DoctorService {
    
    private DoctorRepository doctorRepository;

    public DoctorService() {
        this.doctorRepository = new DoctorRepository();
    }
    
    public List<Doctor> listarDoctores() {
        return doctorRepository.findAll();
    }
    
    public List<Doctor> listarDoctoresEspecialidad(String especialidad) {
        return doctorRepository.findAllByEspecialidad(especialidad);
    }

    public Doctor encontrarDoctor(String numeroDocumento) {
        return doctorRepository.findById(numeroDocumento);
    }

    public Doctor guardarDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void eliminarDoctor(Doctor doctor) {
        doctorRepository.delete(doctor);
    }
    
    public void actualizarDoctor(Doctor doctor){
        doctorRepository.update(doctor);
    }
    
    public Long totalRegistros(){
        return doctorRepository.count();
    }
}
