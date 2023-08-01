package ec.edu.espe.gpr.docencia.tareas.dto;

import ec.edu.espe.gpr.docencia.tareas.model.TareaDocencia;
import ec.edu.espe.gpr.docencia.tareas.model.informefinal.InformeFinal;
import ec.edu.espe.gpr.docencia.tareas.model.microservicegpr.Docente;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

@Data
public class TareaDocenteDocenciaDTO {
    private String id;

    private TareaDocencia tareaDocencia;

    private Docente docenteAsignado;

    private String estadoTareaDocente;

    private InformeFinal informeFinal;

    private Date fechaEntrega;

    private Date fechaModificacion;
}
