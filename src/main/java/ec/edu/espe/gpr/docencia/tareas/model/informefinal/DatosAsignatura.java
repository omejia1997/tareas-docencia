package ec.edu.espe.gpr.docencia.tareas.model.informefinal;

import lombok.Data;

@Data
public class DatosAsignatura {

    private String carrera;

    private String asignatura;

    private String componente;

    private String nrc;

    private EstudiantesMatriculados estudiantesMatriculados;

    private EstudiantesRetirados estudiantesRetirados;

    private EstudiantesReprobados estudiantesReprobados;

    private EstudiantesAprobados estudiantesAprobados;

    private PromedioRendimientoAcademico promedioRendimientoAcademico;

    private DesviacionEstandar desviacionEstandar;

    private Double promedioFinalRendimientoAcademico;

    private Double promedioFinalDesviacionEstandar;

    private TutoriaEstudiantesPromedioMenor14 tutoriaEstudiantesPromedioMenor14;

    private TutoriaEstudiantesPromedioMenor14Asistieron tutoriaEstudiantesPromedioMenor14Asistieron;

    private Integer tutoriaEstudiantesPromedioMenor14AsistieronNoAprobaron;

}
