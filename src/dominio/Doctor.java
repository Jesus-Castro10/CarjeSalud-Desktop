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
public class Doctor extends Persona implements Serializable{
    
    private String codigo; 
    
    private String especialidad;
    
    @OneToMany(mappedBy = "doctor", orphanRemoval = true)
    private List<Cita> citas = new ArrayList<>();
    
    public Doctor() {
        super();
    }
    
    public Doctor(String numeroDocumento) {
        super(numeroDocumento);
    }

    public Doctor(String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, 
            String segundoApellido, Date fechaNacimiento, String sexo, String eps, String email, 
            String celular, byte[] fotoPerfil,String especialidad,String codigo) {
        super(numeroDocumento,primerNombre,segundoNombre,primerApellido,
                segundoApellido,fechaNacimiento,sexo,eps,email,celular,fotoPerfil);
        this.codigo = codigo;
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDoctor{" + "codigo=" + codigo + ", especialidad=" + especialidad + '}';
    }
    
    public String getFullName(){
        return this.getPrimerNombre() + " " + this.getPrimerApellido();
    }
}
