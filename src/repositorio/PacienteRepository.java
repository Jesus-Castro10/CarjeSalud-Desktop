package repositorio;

import dominio.Paciente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import servicio.EntityManagerFactoryProvider;

public class PacienteRepository implements IPacienteRepository{

    private EntityManagerFactory emf= EntityManagerFactoryProvider.getEntityManagerFactory();

    @Override
    public List<Paciente> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList();
    }

    @Override
    public Paciente findById(String numeroDocumento) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Paciente.class, numeroDocumento);
    }

    @Override
    public Paciente save(Paciente paciente) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(paciente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error paciente repository save : \n" + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return paciente;
    }

    @Override
    public void delete(Paciente paciente) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(entityManager.find(Paciente.class, paciente.getNumeroDocumento()));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error paciente repository delete : \n" + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Paciente paciente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Paciente p = em.find(Paciente.class, paciente.getNumeroDocumento());
            if (p != null) {
                p.setPrimerNombre(paciente.getPrimerNombre());
                p.setSegundoNombre(paciente.getSegundoNombre());
                p.setPrimerApellido(paciente.getPrimerApellido());
                p.setSegundoApellido(paciente.getSegundoApellido());
                p.setSexo(paciente.getSexo());
                p.setCelular(paciente.getCelular());
                p.setEmail(paciente.getEmail());
                p.setEps(paciente.getEps());
                p.setFechaNacimiento(paciente.getFechaNacimiento());
                p.setFotoPerfil(paciente.getFotoPerfil());
            }
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error paciente repository update : \n" + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public long count() {
        EntityManager entityManager = emf.createEntityManager();
        String jpql = "SELECT COUNT(p) FROM Paciente p";
        Query query = entityManager.createQuery(jpql);
        return (long) query.getSingleResult();
    }
}