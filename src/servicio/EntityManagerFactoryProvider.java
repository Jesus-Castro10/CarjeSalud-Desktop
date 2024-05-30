package servicio;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lenovo
 */
public class EntityManagerFactoryProvider {
    
    public static EntityManagerFactory getEntityManagerFactory() {
        try {
            return Persistence.createEntityManagerFactory("HosptialPU");
        } catch (Exception e) {
            System.out.println("Error al crear entity manager cita : \n" + e.getMessage());
            return null;
        }
    }
}
