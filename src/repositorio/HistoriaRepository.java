package repositorio;

import dominio.Historia;
import dominio.Paciente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import servicio.EntityManagerFactoryProvider;

/**
 *
 * @author Lenovo
 */
public class HistoriaRepository implements IHistoriaRepository {

    private EntityManagerFactory emf = EntityManagerFactoryProvider.getEntityManagerFactory();

    @Override
    public Historia findById(Integer idHistoria) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Historia.class, idHistoria);
    }

    @Override
    public List<Historia> findByPaciente(Paciente paciente) {
        EntityManager entityManager = emf.createEntityManager();
        String jpql = "SELECT h FROM Historia h WHERE h.paciente = :paciente";
        Query query = entityManager.createQuery(jpql, Historia.class);
        query.setParameter("paciente", paciente);
        return query.getResultList();
    }

    @Override
    public Historia save(Historia historiaClinica) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(historiaClinica);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error HistoriaClinica repository save : \n" + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return historiaClinica;
    }

    @Override
    public void delete(Historia historiaClinica) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(historiaClinica);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error HistoriaClinica repository delete : \n" + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Historia update(Historia historiaClinica) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(historiaClinica);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error HistoriaClinica repository update : \n" + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return historiaClinica;
    }

}
