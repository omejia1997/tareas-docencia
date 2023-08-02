package ec.edu.espe.gpr.docencia.tareas.services;

import ec.edu.espe.gpr.docencia.tareas.config.BaseURLValues;
import ec.edu.espe.gpr.docencia.tareas.dao.TareaDocenciaDao;
import ec.edu.espe.gpr.docencia.tareas.dao.TareaDocenteDocenciaDao;
import ec.edu.espe.gpr.docencia.tareas.dto.TareaDocenteDocenciaDTO;
import ec.edu.espe.gpr.docencia.tareas.enums.EstadoTareaDocenteEnum;
import ec.edu.espe.gpr.docencia.tareas.mapper.TareaDocenciaMapper;
import ec.edu.espe.gpr.docencia.tareas.model.TareaDocencia;
import ec.edu.espe.gpr.docencia.tareas.dto.TareaDocenciaDTO;
import ec.edu.espe.gpr.docencia.tareas.model.TareaDocenteDocencia;
import ec.edu.espe.gpr.docencia.tareas.model.informefinal.InformeFinal;
import ec.edu.espe.gpr.docencia.tareas.model.microservicegpr.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class TareaDocenciaService {
    @Autowired
    private TareaDocenciaDao tareaDocenciaDao;

    @Autowired
    private TareaDocenteDocenciaDao tareaDocenteDocenciaDao;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BaseURLValues baseURLs;

    @Autowired
    private EmailService emservice;

    /*public TareaVinculacion obtenerTareaPorCodigoTarea(String codTarea) {
        Optional<TareaVinculacion> tareaOpt = this.tareaDao.findById(codTarea);
        if (tareaOpt.isPresent())
            return tareaOpt.get();
        else
            return null;
    }*/

    public List<TareaDocencia> listarTodasTareasPorDocente(String idEspeDocente){
        return this.tareaDocenciaDao.findByIdEspeDocenteRevisor(idEspeDocente);
    }

    public List<TareaDocenteDocenciaDTO> listarTodasTareasAsignadasPorDocente(String idEspeDocente){
        List<TareaDocenteDocencia> tareaDocenteDocencia = this.tareaDocenteDocenciaDao.findByDocenteAsignadoIdDocente(idEspeDocente);
        List<TareaDocenteDocenciaDTO> tareaDocenteDocenciaDTOS = new ArrayList<>();
        for (TareaDocenteDocencia tarea:tareaDocenteDocencia) {
            TareaDocenteDocenciaDTO tareaDocenteDocenciaDTO = new TareaDocenteDocenciaDTO();
            TareaDocencia tareaDocencia = this.tareaDocenciaDao.findById(tarea.getIdTareaDocencia()).get();
            tareaDocenteDocenciaDTO.setId(tarea.getId());
            tareaDocenteDocenciaDTO.setTareaDocencia(tareaDocencia);
            tareaDocenteDocenciaDTO.setDocenteAsignado(tarea.getDocenteAsignado());
            tareaDocenteDocenciaDTO.setEstadoTareaDocente(tarea.getEstadoTareaDocente());
            tareaDocenteDocenciaDTO.setInformeFinal(tarea.getInformeFinal());
            tareaDocenteDocenciaDTO.setFechaEntrega(tarea.getFechaEntrega());
            tareaDocenteDocenciaDTO.setFechaModificacion(tarea.getFechaModificacion());
            tareaDocenteDocenciaDTOS.add(tareaDocenteDocenciaDTO);
        }
        return tareaDocenteDocenciaDTOS;
    }

    /*public List<TareaDocenteDocenciaDTO> listarTareaAsignadaPorDocente(Integer codigoDocente){
        List<TareaDocenteDocencia> tareaDocenteDocenciaList = this.tareaDocenteDocenciaDao.findByDocenteAsignadoCodigoDocente(codigoDocente);

    }*/

    public void crearTarea(TareaDocenciaDTO tareaDocenciaRequest){
        tareaDocenciaRequest.setFechaCreaciontarea(LocalDate.now());
        tareaDocenciaRequest.setFechaModificaciontarea(LocalDate.now());
        TareaDocencia tareaDocencia = TareaDocenciaMapper.buildTareaDocencia(tareaDocenciaRequest);
        tareaDocencia= this.tareaDocenciaDao.save(tareaDocencia);
        for (Docente docente: tareaDocenciaRequest.getDocentesAsignados()) {
            TareaDocenteDocencia tareDocenteDocencia = new TareaDocenteDocencia();
            tareDocenteDocencia.setIdTareaDocencia(tareaDocencia.getId());
            tareDocenteDocencia.setDocenteAsignado(docente);
            tareDocenteDocencia.setEstadoTareaDocente(EstadoTareaDocenteEnum.ASIGNADA.getValue());
            tareDocenteDocencia.setFechaModificacion(new Date());
            this.tareaDocenteDocenciaDao.save(tareDocenteDocencia);
        }
    }

    public TareaDocencia actualizarTarea(TareaDocencia tareaDocencia){
        return this.tareaDocenciaDao.save(tareaDocencia);
    }

    public TareaDocenteDocencia guardarTareaParaRevisar(TareaDocenteDocencia tareaDocenteDocencia){
        tareaDocenteDocencia.setFechaModificacion(new Date());
        tareaDocenteDocencia.setEstadoTareaDocente(EstadoTareaDocenteEnum.EN_REVISION.getValue());
        return this.tareaDocenteDocenciaDao.save(tareaDocenteDocencia);
    }

    public TareaDocenteDocencia guardarTareaComoBorrador(String idTareaDocente, InformeFinal informeFinal){
        TareaDocenteDocencia tareaDocenteDocencia = this.tareaDocenteDocenciaDao.findById(idTareaDocente).get();
        tareaDocenteDocencia.setFechaModificacion(new Date());
        tareaDocenteDocencia.setEstadoTareaDocente(EstadoTareaDocenteEnum.GUARDAR_BORRADOR.getValue());
        tareaDocenteDocencia.setInformeFinal(informeFinal);
        return this.tareaDocenteDocenciaDao.save(tareaDocenteDocencia);
    }
}