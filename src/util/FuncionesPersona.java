package util;

import dominio.Persona;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Lenovo
 */
public class FuncionesPersona {
    
    public static String obtenerEdad(Persona persona) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        String sFechaNacimiento = persona.getFechaNacimiento().toString();
//        Long fecha = persona.getFechaNacimiento().;
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.parse(sFechaNacimiento,formatter);
        // Calcula la diferencia de años, meses y días
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        // Obtiene la edad en años
        int edad = periodo.getYears();
        String sEdad;
        if (edad < 1) {
            edad = periodo.getMonths();
            sEdad = edad + " meses";
            if (edad < 1) {
                edad = periodo.getDays();
                sEdad = edad + " dias";
            }
        } else {
            sEdad = edad + " años";
        }
        return  sEdad;
    }
}
