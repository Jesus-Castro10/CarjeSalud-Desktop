package repositorio;

import dominio.Historia;
import dominio.Paciente;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface IHistoriaRepository {

    Historia findById(Integer idHistoria);

    List<Historia> findByPaciente(Paciente paciente);

    Historia save(Historia historiaClinica);

    void delete(Historia historiaClinica);

    Historia update(Historia historiaClinica);
}
