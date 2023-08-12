package ec.edu.espe.gpr.docencia.tareas.dao;

import ec.edu.espe.gpr.docencia.tareas.model.TareaDocenteDocencia;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TareaDocenteDocenciaDao extends MongoRepository<TareaDocenteDocencia, String> {
   List<TareaDocenteDocencia> findByDocenteAsignadoCodigoDocente(Integer codigoDocente);
   List<TareaDocenteDocencia> findByDocenteAsignadoIdDocenteAndEstadoTareaDocente(String idDocente,String estadoTareaDocente);
   List<TareaDocenteDocencia> findByDocenteAsignadoIdDocenteAndEstadoTareaDocenteNot(String idDocente,String estadoTareaDocente);
   List<TareaDocenteDocencia> findByEstadoTareaDocente(String estadoTareaDocente);
   List<TareaDocenteDocencia> findByEstadoTareaDocenteAndCodigoPeriodo(String estadoTareaDocente,Integer codigoPeriodo);

    //List<TareaDocenteDocencia> findByCodigoPeriodo(Integer codigoPeriodo);
    List<TareaDocenteDocencia> findByIdTareaDocencia(String idTareaDocencia);
}
