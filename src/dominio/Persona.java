package dominio;

import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public abstract class Persona {
    
    @Id
    @Column(name = "numero_documento")
    private String numeroDocumento; 
    
    @Column(name = "primer_nombre")
    private String primerNombre; 
    
    @Column(name = "segundo_nombre")
    private String segundoNombre; 
    
    @Column(name = "primer_apellido")
    private String primerApellido; 
    
    @Column(name = "segundo_apellido")
    private String segundoApellido; 
    
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    
    private String sexo;
    
    private String eps;
    
    private String email;
    
    private String celular;
    
    @Column(name = "foto_perfil")
    private byte[] fotoPerfil;

    public Persona(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

}
