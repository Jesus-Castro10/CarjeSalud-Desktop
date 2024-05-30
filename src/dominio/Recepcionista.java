package dominio;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
public class Recepcionista extends Persona implements Serializable{      
    
    private String codigo;

    public Recepcionista() {
    }

    public Recepcionista(String codigo) {
        this.codigo = codigo;
    }

    public Recepcionista(String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, 
            String segundoApellido, Date fechaNacimiento, String sexo, String eps, String email, 
            String celular, byte[] fotoPerfil,String codigo) {
        super(numeroDocumento,primerNombre,segundoNombre,primerApellido,
                segundoApellido,fechaNacimiento,sexo,eps,email,celular,fotoPerfil);
        this.codigo = codigo;
    }
    
    public String getFullName(){
        return this.getPrimerNombre() + " " + this.getPrimerApellido();
    }

}
