package pe.example.cibertec.pregunta3.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "alumno")
@Getter
@Setter
@NoArgsConstructor
public class Alumno {
    @Id
    private String idalumno;
    @Column(name = "nomalumno")
    private String nomalumno;
    @Column(name = "apealumno")
    private String apealumno;
    @Column(name = "proce")
    private String proce;
    @Column(name = "idesp")
    private String idesp;


}