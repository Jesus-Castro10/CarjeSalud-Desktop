/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import lombok.*;

/**
 *
 * @author Lenovo
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Medicamento {
    
    private int idMedicamento;
    private String nombreMedicamento;
    private String posologia;
    private int cantidad;
}
