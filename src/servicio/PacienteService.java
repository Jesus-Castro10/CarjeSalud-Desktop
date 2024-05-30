package servicio;

import dominio.Paciente;
import java.util.List;
import repositorio.PacienteRepository;

public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteService() {
        this.pacienteRepository = new PacienteRepository();
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente encontrarPaciente(String numeroDocumento) {
        return pacienteRepository.findById(numeroDocumento);
    }

    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void eliminarPaciente(Paciente paciente) {
        pacienteRepository.delete(paciente);
    }

    public void actualizarPaciente(Paciente paciente) {
        pacienteRepository.update(paciente);
    }

    public long totalPacientes() {
        return pacienteRepository.count();
    }
}
