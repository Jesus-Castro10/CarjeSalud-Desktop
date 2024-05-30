package repositorio;

import dominio.Recepcionista;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import servicio.EntityManagerFactoryProvider;

/**
 *
 * @author Lenovo
 */
public class RecepcionistaRepository implements IRecepcionistaRepository {

    private EntityManagerFactory emf = EntityManagerFactoryProvider.getEntityManagerFactory();

    @Override
    public List<Recepcionista> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.createQuery("SELECT r FROM Recepcionista r", Recepcionista.class).getResultList();
    }

    @Override
    public Recepcionista findById(String numeroDocumento) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Recepcionista.class, numeroDocumento);
    }

    @Override
    public Recepcionista save(Recepcionista recepcionista) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(recepcionista);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error Recepcionista repository save : \n" + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return recepcionista;
    }

    @Override
    public void delete(Recepcionista recepcionista) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(entityManager.find(Recepcionista.class, recepcionista.getNumeroDocumento()));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error cita repository delete : \n" + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Recepcionista update(Recepcionista recepcionista) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(recepcionista);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error cita repository update : \n" + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return recepcionista;
    }

    public long count() {
        EntityManager entityManager = emf.createEntityManager();
        String jpql = "SELECT COUNT(r) FROM Recepcionista r";
        Query query = entityManager.createQuery(jpql);
        return (long) query.getSingleResult();
    }
}
