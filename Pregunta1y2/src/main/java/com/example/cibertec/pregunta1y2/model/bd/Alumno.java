package com.example.cibertec.pregunta1y2.model.bd;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idesp")
    private Especialidad especialidad;

}
