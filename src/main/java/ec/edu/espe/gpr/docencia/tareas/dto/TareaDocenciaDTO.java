package ec.edu.espe.gpr.docencia.tareas.dto;

import ec.edu.espe.gpr.docencia.tareas.model.microservicegpr.Docente;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class TareaDocenciaDTO {

    private String id;

    private String idEspeDocenteRevisor;

    private String nombreDocenteRevisor;

    private String nombreTarea;

    private LocalDate fechaCreaciontarea;

    private LocalDate fechaModificaciontarea;

    private List<String> observacionTarea;

    private Character estadoTarea;

    private String periodo;

    private List<Docente> docentesAsignados;
}
