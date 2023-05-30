package pe.example.cibertec.pregunta3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.example.cibertec.pregunta3.Model.Alumno;


@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, String> {

}
