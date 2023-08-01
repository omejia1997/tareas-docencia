package ec.edu.espe.gpr.docencia.tareas.model.microservicegpr;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Docente{

    @Indexed(name = "idx_tareaDocenteDocencia_docente_codigoDocente")
    private Integer codigoDocente;

    @Indexed(name = "idx_tareaDocenteDocencia_docente_idDocente")
    private String idDocente;
    
    private String nombreDocente;
    
    private String apellidoDocente;

    @Indexed(name = "idx_tareaDocenteDocencia_docente_cedula_docente")
    private String cedulaDocente;
    
    private String correoDocente;
}
