package repositorio;

import dominio.Recepcionista;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface IRecepcionistaRepository {
    List<Recepcionista> findAll();
    Recepcionista findById(String codigo);
    Recepcionista save(Recepcionista recepcionista);
    void delete(Recepcionista recepcionista);
    Recepcionista update(Recepcionista recepcionista);
}
