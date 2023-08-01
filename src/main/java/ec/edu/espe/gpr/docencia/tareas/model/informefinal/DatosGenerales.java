package ec.edu.espe.gpr.docencia.tareas.model.informefinal;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
public class DatosGenerales {

    private String areaConocimiento;

    private String nombreDocentePresentaInforme;
    
    private String nombreCoordinadorArea;
}
