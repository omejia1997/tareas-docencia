package ec.edu.espe.gpr.docencia.tareas.mapper;

import ec.edu.espe.gpr.docencia.tareas.dto.TareaDocenciaDTO;
import ec.edu.espe.gpr.docencia.tareas.enums.EstadoTareaEnum;
import ec.edu.espe.gpr.docencia.tareas.model.TareaDocencia;

public class TareaDocenciaMapper {
    public static TareaDocenciaDTO buildTareaDocenciaDTO(TareaDocencia tareaDocencia) {
        return TareaDocenciaDTO.builder()
                .id(tareaDocencia.getId())
                .idEspeDocenteRevisor(tareaDocencia.getIdEspeDocenteRevisor())
                .codigoPeriodo(tareaDocencia.getCodigoPeriodo())
                .nombreDocenteRevisor(tareaDocencia.getNombreDocenteRevisor())
                .nombreTarea(tareaDocencia.getNombreTarea())
                .fechaCreaciontarea(tareaDocencia.getFechaCreaciontarea())
                .observacionTarea(tareaDocencia.getObservacionTarea())
                .estadoTarea(tareaDocencia.getEstadoTarea())
                .build();
    }

    public static TareaDocencia buildTareaDocencia(TareaDocenciaDTO tareaDocenciaDTO) {
        if(tareaDocenciaDTO.getId()==null){
            tareaDocenciaDTO.setEstadoTarea(EstadoTareaEnum.ACTIVE.getValue().charAt(0));
            return TareaDocencia.builder()
                    .idEspeDocenteRevisor(tareaDocenciaDTO.getIdEspeDocenteRevisor())
                    .codigoPeriodo(tareaDocenciaDTO.getCodigoPeriodo())
                    .nombreDocenteRevisor(tareaDocenciaDTO.getNombreDocenteRevisor())
                    .nombreTarea(tareaDocenciaDTO.getNombreTarea())
                    .fechaCreaciontarea(tareaDocenciaDTO.getFechaCreaciontarea())
                    .fechaModificaciontarea(tareaDocenciaDTO.getFechaModificaciontarea())
                    .observacionTarea(tareaDocenciaDTO.getObservacionTarea())
                    .estadoTarea(tareaDocenciaDTO.getEstadoTarea())
                    .build();
        }
        return TareaDocencia.builder()
                .id(tareaDocenciaDTO.getId())
                .idEspeDocenteRevisor(tareaDocenciaDTO.getIdEspeDocenteRevisor())
                .codigoPeriodo(tareaDocenciaDTO.getCodigoPeriodo())
                .nombreDocenteRevisor(tareaDocenciaDTO.getNombreDocenteRevisor())
                .nombreTarea(tareaDocenciaDTO.getNombreTarea())
                .fechaCreaciontarea(tareaDocenciaDTO.getFechaCreaciontarea())
                .observacionTarea(tareaDocenciaDTO.getObservacionTarea())
                .estadoTarea(tareaDocenciaDTO.getEstadoTarea())
                .build();
    }
}
