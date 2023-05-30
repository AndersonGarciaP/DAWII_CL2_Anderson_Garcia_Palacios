package pe.example.cibertec.pregunta3.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.example.cibertec.pregunta3.Model.Alumno;
import pe.example.cibertec.pregunta3.Service.AlumnoService;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;
    @GetMapping("")
    public ResponseEntity<List<Alumno>> listarEstados(){
        List<Alumno> alumnoList = new ArrayList<>();
        alumnoService.listarAlumnos().forEach(alumnoList::add);

        if(alumnoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alumnoList, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> ObtenerAlumnosxId(@PathVariable("id") String id) {
        return new ResponseEntity<>(alumnoService.buscarAlumnoxId(id).get(), HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<Alumno> crearEstado(@RequestBody Alumno alumno){
        Alumno newAlumno = new Alumno();
        newAlumno.setIdalumno(alumno.getIdalumno());
        newAlumno.setNomalumno(alumno.getNomalumno());
        newAlumno.setApealumno(alumno.getApealumno());
        newAlumno.setProce(alumno.getProce());
        newAlumno.setIdesp(alumno.getIdesp());
        return new ResponseEntity<>(alumnoService.registrar(newAlumno),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno( @PathVariable("id") String id, @RequestBody Alumno alumno){
        Alumno upadteAlumno = alumnoService.buscarAlumnoxId(id).get();
        upadteAlumno.setNomalumno(alumno.getNomalumno());
        upadteAlumno.setApealumno(alumno.getApealumno());
        upadteAlumno.setProce(alumno.getProce());
        upadteAlumno.setIdesp(alumno.getIdesp());
        return new ResponseEntity<>(alumnoService.registrar(upadteAlumno),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.eliminarxId(id));

    }
}
