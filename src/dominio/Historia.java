package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author user
 */
@Entity
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Historia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historia")
    private Integer idHistoria;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(columnDefinition = "TEXT")
    private String medicamentos;

    @Column(name = "estado_paciente", columnDefinition = "TEXT")
    private String estadoPaciente;

    @Column(columnDefinition = "TEXT")
    private String diagnostico;

    @Column(columnDefinition = "TEXT")
    private String cita;

    public Historia() {
    }

    public Historia(Paciente paciente) {
        this.paciente = paciente;
    }

    public Historia(Paciente paciente, Date fecha) {
        this.paciente = paciente;
        this.fecha = fecha;
    }

    public Historia(Paciente paciente, Date fecha, String medicamentos, String estadoPaciente, String diagnostico, String cita) {
        this.paciente = paciente;
        this.fecha = fecha;
        this.medicamentos = medicamentos;
        this.estadoPaciente = estadoPaciente;
        this.diagnostico = diagnostico;
        this.cita = cita;
    }

}
