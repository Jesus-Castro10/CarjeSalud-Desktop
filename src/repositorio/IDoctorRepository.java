package repositorio;

import dominio.Doctor;
import java.util.List;

/**
 *
 * @author Jesus Castro
 */
public interface IDoctorRepository {
    List<Doctor> findAll();
    List<Doctor> findAllByEspecialidad(String especialidad);
    Doctor findById(String codigo);
    Doctor save(Doctor doctor);
    void delete(Doctor doctor);
    Doctor update(Doctor doctor);
}
