package servicio;

import dominio.Recepcionista;
import java.util.List;
import repositorio.RecepcionistaRepository;

/**
 *
 * @author Lenovo
 */
public class RecepcionistaService {

    private RecepcionistaRepository recepcionistaRepository;

    public RecepcionistaService() {
        this.recepcionistaRepository = new RecepcionistaRepository();
    }

    public List<Recepcionista> listarRecepcionistaes() {
        return recepcionistaRepository.findAll();
    }

    public Recepcionista encontrarRecepcionista(String numeroDocumento) {
        return recepcionistaRepository.findById(numeroDocumento);
    }

    public Recepcionista guardarRecepcionista(Recepcionista recepcionista) {
        return recepcionistaRepository.save(recepcionista);
    }

    public void eliminarRecepcionista(Recepcionista recepcionista) {
        recepcionistaRepository.delete(recepcionista);
    }

    public void actualizarRecepcionista(Recepcionista recepcionista) {
        recepcionistaRepository.update(recepcionista);
    }

    public long totalRecepcionistas() {
        return recepcionistaRepository.count();
    }
}
