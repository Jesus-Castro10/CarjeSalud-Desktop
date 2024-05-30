package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Paciente extends Persona implements Serializable {

    @OneToMany(mappedBy = "paciente", orphanRemoval = true)
    private List<Cita> citas = new ArrayList<>();

    public Paciente() {
        super();
    }

    public Paciente(String numeroDocumento) {
        super(numeroDocumento);
    }

    public Paciente(String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido,
            String segundoApellido, Date fechaNacimiento, String sexo, String eps, String email,
            String celular, byte[] fotoPerfil) {
        super(numeroDocumento, primerNombre, segundoNombre, primerApellido,
                segundoApellido, fechaNacimiento, sexo, eps, email, celular, fotoPerfil);
    }

    @Override
    public String toString() {
        return "Paciente{" + super.toString() + "Citas \n" + this.citas + '}';
    }

    public String getFullName() {
        return this.getPrimerNombre() + " " + this.getPrimerApellido();
    }

}
