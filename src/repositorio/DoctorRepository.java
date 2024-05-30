package repositorio;

import dominio.Doctor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import servicio.EntityManagerFactoryProvider;

/**
 *
 * @author Jesus Castro
 */
public class DoctorRepository implements IDoctorRepository {

    private EntityManagerFactory emf = EntityManagerFactoryProvider.getEntityManagerFactory();

    @Override
    public List<Doctor> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.createQuery("SELECT d FROM Doctor d", Doctor.class).getResultList();
    }

    @Override
    public List<Doctor> findAllByEspecialidad(String especialidad) {
        EntityManager entityManager = emf.createEntityManager();
        String jpql = "SELECT d FROM Doctor d WHERE d.especialidad = :especialidad";
        Query q = entityManager.createQuery(jpql, Doctor.class);
        q.setParameter("especialidad", especialidad);
        return q.getResultList();
    }

    @Override
    public Doctor findById(String numeroDocumento) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Doctor.class, numeroDocumento);
    }

    @Override
    public Doctor save(Doctor doctor) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(doctor);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error doctor repository save : \n" + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return doctor;
    }

    @Override
    public void delete(Doctor doctor) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(doctor);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error cita repository delete : \n" + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Doctor update(Doctor doctor) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(doctor);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error cita repository update : \n" + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return doctor;
    }
    
    public long count(){
        EntityManager entityManager = emf.createEntityManager();
        String jpql = "SELECT COUNT(d) FROM Doctor D";
        Query query = entityManager.createQuery(jpql);
        return (long) query.getSingleResult();
    }
}
