package ec.edu.espe.gpr.docencia.tareas.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import ec.edu.espe.gpr.docencia.tareas.model.informefinal.InformeFinal;
import ec.edu.espe.gpr.docencia.tareas.model.microservicegpr.Docente;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "TareaDocenteDocencia")
@TypeAlias("TareaDocenteDocencia")
public class TareaDocenteDocencia {

    @Id
    private String id;

    @Indexed(name = "idx_tareaDocenteDocencia_idTareaDocencia")
    private String idTareaDocencia;

    private Docente docenteAsignado;

    private String estadoTareaDocente;

    private Integer codigoPeriodo;

    private InformeFinal informeFinal;

    private Date fechaEntrega;

    private Date fechaModificacion;
}