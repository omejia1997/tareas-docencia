package ec.edu.espe.gpr.docencia.tareas.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "TareaDocencia")
@TypeAlias("TareaDocencia")
public class TareaDocencia {

    @Id 
    private String id;

    private String idEspeDocenteRevisor;

    private String nombreDocenteRevisor;
    
    private String nombreTarea;

    private LocalDate fechaCreaciontarea;

    private LocalDate fechaModificaciontarea;

    private List<String> observacionTarea;

    private Character estadoTarea;

    private String periodo; //Por definir no implementado

}
