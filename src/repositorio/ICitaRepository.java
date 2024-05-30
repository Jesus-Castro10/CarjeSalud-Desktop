/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import dominio.Cita;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface ICitaRepository {
    List<Cita> findAll();
    Cita findById(Integer codigo);
    Cita save(Cita cita);
    void delete(Cita cita);
    Cita update(Cita cita);
}
