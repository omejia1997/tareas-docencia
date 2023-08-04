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

    public List<TareaDocenciaDTO> listarTodasTareasPorPeriodo(Integer codigoPeriodo) {
        List<TareaDocencia> tareaDocencia = this.tareaDocenciaDao.findByCodigoPeriodo(codigoPeriodo);
        List<TareaDocenciaDTO> tareaDocenciaDTOList = new ArrayList<>();
        for (TareaDocencia tarea:tareaDocencia) {
            TareaDocenciaDTO tareaDocenciaDTO = TareaDocenciaMapper.buildTareaDocenciaDTO(tarea);
            List<TareaDocenteDocencia> tareaDocenteDocenciaList = this.tareaDocenteDocenciaDao.findByIdTareaDocencia(tarea.getId());
            List<Docente> docentes = new ArrayList<>();
            for (TareaDocenteDocencia tareaDocenteDocencia: tareaDocenteDocenciaList) {
                docentes.add(tareaDocenteDocencia.getDocenteAsignado());
            }
            tareaDocenciaDTO.setDocentesAsignados(docentes);
            tareaDocenciaDTOList.add(tareaDocenciaDTO);
        }
        return tareaDocenciaDTOList;
    }


    public List<TareaDocenteDocenciaDTO> listarTodasTareasAsignadasPorDocente(String idEspeDocente) {
        List<TareaDocenteDocencia> tareaDocenteDocencia = this.tareaDocenteDocenciaDao.findByDocenteAsignadoIdDocente(idEspeDocente);
        List<TareaDocenteDocenciaDTO> tareaDocenteDocenciaDTOS = new ArrayList<>();
        for (TareaDocenteDocencia tarea : tareaDocenteDocencia) {
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

    public List<TareaDocenteDocenciaDTO> listarTodasTareasSubidasPorPeriodo(Integer codigoPeriodo) {
        List<TareaDocenteDocencia> tareaDocenteDocencia = this.tareaDocenteDocenciaDao.findByEstadoTareaDocenteAndCodigoPeriodo(EstadoTareaDocenteEnum.SUBIDA_NO_ACEPTA_CAMBIOS.getValue(), codigoPeriodo);
        List<TareaDocenteDocenciaDTO> tareaDocenteDocenciaDTOS = new ArrayList<>();
        for (TareaDocenteDocencia tarea : tareaDocenteDocencia) {
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

    /*public List<TareaDocenteDocenciaDTO> listarTodasTareasSubidasModuloDocencia() {
        List<TareaDocenteDocencia> tareaDocenteDocencia = this.tareaDocenteDocenciaDao.findByEstadoTareaDocente(EstadoTareaDocenteEnum.SUBIDA_NO_ACEPTA_CAMBIOS.getValue());
        List<TareaDocenteDocenciaDTO> tareaDocenteDocenciaDTOS = new ArrayList<>();
        for (TareaDocenteDocencia tarea : tareaDocenteDocencia) {
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
            tareDocenteDocencia.setCodigoPeriodo(tareaDocencia.getCodigoPeriodo());
            tareDocenteDocencia.setFechaModificacion(new Date());
            this.tareaDocenteDocenciaDao.save(tareDocenteDocencia);
        }
    }

    public TareaDocencia actualizarTarea(TareaDocenciaDTO tareaDocenciaRequest){
        tareaDocenciaRequest.setFechaModificaciontarea(LocalDate.now());
        TareaDocencia tareaDocencia = TareaDocenciaMapper.buildTareaDocencia(tareaDocenciaRequest);
        tareaDocencia = this.tareaDocenciaDao.save(tareaDocencia);
        List<TareaDocenteDocencia> tareaDocenteDocenciaList = this.tareaDocenteDocenciaDao.findByIdTareaDocencia(tareaDocencia.getId());
        for (Docente docente: tareaDocenciaRequest.getDocentesAsignados()) {
            if(!tareaDocenteDocenciaList.contains(docente)) {
                TareaDocenteDocencia tareDocenteDocencia = new TareaDocenteDocencia();
                tareDocenteDocencia.setIdTareaDocencia(tareaDocencia.getId());
                tareDocenteDocencia.setDocenteAsignado(docente);
                tareDocenteDocencia.setEstadoTareaDocente(EstadoTareaDocenteEnum.ASIGNADA.getValue());
                tareDocenteDocencia.setCodigoPeriodo(tareaDocencia.getCodigoPeriodo());
                tareDocenteDocencia.setFechaModificacion(new Date());
                this.tareaDocenteDocenciaDao.save(tareDocenteDocencia);
                tareaDocenteDocenciaList.remove(docente);
            }
        }
        if(tareaDocenteDocenciaList.size()>0){
            for (TareaDocenteDocencia tareaDocenteDocencia:tareaDocenteDocenciaList) {
                this.tareaDocenteDocenciaDao.delete(tareaDocenteDocencia);
            }
        }
        return tareaDocencia;
    }

    public TareaDocenteDocencia guardarTareaParaRevisar(TareaDocenteDocencia tareaDocenteDocencia){
        tareaDocenteDocencia.setFechaModificacion(new Date());
        tareaDocenteDocencia.setEstadoTareaDocente(EstadoTareaDocenteEnum.SUBIDA_NO_ACEPTA_CAMBIOS.getValue());
        return this.tareaDocenteDocenciaDao.save(tareaDocenteDocencia);
    }

    public TareaDocenteDocencia guardarTareaComoBorrador(String idTareaDocente, InformeFinal informeFinal){
        TareaDocenteDocencia tareaDocenteDocencia = this.tareaDocenteDocenciaDao.findById(idTareaDocente).get();
        tareaDocenteDocencia.setFechaModificacion(new Date());
        //tareaDocenteDocencia.setEstadoTareaDocente(EstadoTareaDocenteEnum.GUARDAR_BORRADOR.getValue());
        tareaDocenteDocencia.setInformeFinal(informeFinal);
        return this.tareaDocenteDocenciaDao.save(tareaDocenteDocencia);
    }

    public TareaDocenteDocencia guardarTareaParaSubir(String idTareaDocente, InformeFinal informeFinal){
        TareaDocenteDocencia tareaDocenteDocencia = this.tareaDocenteDocenciaDao.findById(idTareaDocente).get();
        tareaDocenteDocencia.setFechaModificacion(new Date());
        tareaDocenteDocencia.setFechaEntrega(new Date());
        tareaDocenteDocencia.setEstadoTareaDocente(EstadoTareaDocenteEnum.SUBIDA_NO_ACEPTA_CAMBIOS.getValue());
        tareaDocenteDocencia.setInformeFinal(informeFinal);
        return this.tareaDocenteDocenciaDao.save(tareaDocenteDocencia);
    }

    public void habilitarTareaParaEditar(String idTareaDocente) {
        TareaDocenteDocencia tareaDocenteDocencia = this.tareaDocenteDocenciaDao.findById(idTareaDocente).get();
        //tareaDocenteDocencia.setFechaModificacion(new Date());
        tareaDocenteDocencia.setEstadoTareaDocente(EstadoTareaDocenteEnum.ASIGNADA.getValue());
        this.tareaDocenteDocenciaDao.save(tareaDocenteDocencia);
    }
}