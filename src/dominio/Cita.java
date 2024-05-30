package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Integer idCita;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    private String hora;
    
    private String tipo;
    
    private String motivo;
    
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    
    private String consultorio;

    public Cita() {
    }

    public Cita(Integer idCita) {
        this.idCita = idCita;
    }

    public Cita(Date fecha, String hora, String tipo, Doctor doctor, Paciente paciente, String consultorio) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
        this.doctor = doctor;
        this.paciente = paciente;
        this.consultorio = consultorio;
    }
    
    public Cita(Date fecha, String hora, String tipo, String motivo, Doctor doctor, Paciente paciente, String consultorio) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
        this.motivo = motivo;
        this.doctor = doctor;
        this.paciente = paciente;
        this.consultorio = consultorio;
    }

    public boolean equals(Cita cita) {
        return this.fecha.equals(cita.fecha) && this.hora.equals(cita.hora);
    }
    
}
