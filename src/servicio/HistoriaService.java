package servicio;

import dominio.Historia;
import dominio.Paciente;
import java.util.List;
import repositorio.HistoriaRepository;

/**
 *
 * @author Lenovo
 */
public class HistoriaService {

    private HistoriaRepository historiaRepository;

    public HistoriaService() {
        this.historiaRepository = new HistoriaRepository();
    }

    public Historia encontrarHistoriaClinica(Integer idHistoria) {
        return historiaRepository.findById(idHistoria);
    }
    
    public List<Historia> encontrarHistoriaPaciente(Paciente paciente) {
        return historiaRepository.findByPaciente(paciente);
    }

    public Historia guardarHistoriaClinica(Historia historiaClinica) {
        return historiaRepository.save(historiaClinica);
    }

    public void eliminarHistoriaClinica(Historia historiaClinica) {
        historiaRepository.delete(historiaClinica);
    }
    
    public void actualizarHistoriaClinica(Historia historiaClinica){
        historiaRepository.update(historiaClinica);
    }
    
}
