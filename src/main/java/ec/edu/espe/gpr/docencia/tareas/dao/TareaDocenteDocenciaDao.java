package ec.edu.espe.gpr.docencia.tareas.dao;

import ec.edu.espe.gpr.docencia.tareas.model.TareaDocenteDocencia;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TareaDocenteDocenciaDao extends MongoRepository<TareaDocenteDocencia, String> {
   List<TareaDocenteDocencia> findByDocenteAsignadoCodigoDocente(Integer codigoDocente);
}
