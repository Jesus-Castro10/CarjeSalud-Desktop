package dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Lenovo
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Usuario {

    private String username;
    private String contraseña;
    private String cargo;
    
    
}
