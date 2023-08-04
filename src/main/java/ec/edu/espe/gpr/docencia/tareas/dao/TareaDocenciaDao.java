package ec.edu.espe.gpr.docencia.tareas.dao;

import ec.edu.espe.gpr.docencia.tareas.model.TareaDocencia;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TareaDocenciaDao extends MongoRepository<TareaDocencia, String> {
    List<TareaDocencia> findByIdEspeDocenteRevisor(String idEspeDocenteRevisor);
    List<TareaDocencia> findByCodigoPeriodo(Integer codigoPeriodo);
}
