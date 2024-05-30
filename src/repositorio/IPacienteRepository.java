package repositorio;

import dominio.Paciente;
import java.util.List;

public interface IPacienteRepository {
    List<Paciente> findAll();
    Paciente findById(String id);
    Paciente save(Paciente paciente);
    void delete(Paciente paciente);
    void update(Paciente paciente);
}
