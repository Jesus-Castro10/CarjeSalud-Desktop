package repositorio;

import dominio.Cita;
import dominio.Doctor;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import servicio.EntityManagerFactoryProvider;

/**
 *
 * @author Lenovo
 */
@ApplicationScoped
public class CitaRepository implements ICitaRepository{

    private EntityManagerFactory emf = EntityManagerFactoryProvider.getEntityManagerFactory();

    
    @Override
    public List<Cita> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.createQuery("SELECT c FROM Cita c", Cita.class).getResultList();
    }

    @Override
    public Cita findById(Integer codigo) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Cita.class, codigo);
    }
    
    @Override
    public Cita save(Cita cita) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(cita);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error cita repository save : \n" + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return cita;
    }

    @Override
    public void delete(Cita cita) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(entityManager.find(Cita.class, cita.getIdCita()));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error cita repository delete : \n" + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Cita update(Cita cita) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(cita);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error cita repository update : \n" + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return cita;
    }
    
    public List<Cita> findAllByDoctor(Doctor doctor){
        EntityManager entityManager = emf.createEntityManager();
        String jpql = "SELECT c FROM Cita c WHERE c.doctor = :doctor";
        Query q = entityManager.createQuery(jpql, Cita.class);
        q.setParameter("doctor", doctor);
        return q.getResultList();
    }
    
    public long count(){
        EntityManager entityManager = emf.createEntityManager();
        String jpql = "SELECT COUNT(c) FROM Cita c";
        Query query = entityManager.createQuery(jpql);
        return (long) query.getSingleResult();
    }
    
}
