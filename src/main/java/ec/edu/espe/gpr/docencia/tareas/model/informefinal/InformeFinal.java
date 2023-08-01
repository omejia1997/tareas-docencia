package ec.edu.espe.gpr.docencia.tareas.model.informefinal;

import ec.edu.espe.gpr.docencia.tareas.model.informefinal.AccionesMejoraDocente;
import ec.edu.espe.gpr.docencia.tareas.model.informefinal.DatosGenerales;
import ec.edu.espe.gpr.docencia.tareas.model.informefinal.EvaluacionDocente;
import ec.edu.espe.gpr.docencia.tareas.model.informefinal.TematicaCapacitacion;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class InformeFinal {
    private DatosGenerales datosGenerales;
    private ArrayList<String> antecedentes;
    private String objetivo;
    private String datosAsignatura;
    private EvaluacionDocente evaluacionDocente;
    private ArrayList<String> fortalezas;
    private ArrayList<String> debilidades;
    private ArrayList<String> apreciacionGlobalFortalezas;
    private ArrayList<String> apreciacionGlobalDebilidades;
    private AccionesMejoraDocente accionesMejoraDocente;
    private ArrayList<TematicaCapacitacion> tematicaCapacitaciones;
    private ArrayList<String> conclusiones;
    private ArrayList<String> recomendaciones;

}
