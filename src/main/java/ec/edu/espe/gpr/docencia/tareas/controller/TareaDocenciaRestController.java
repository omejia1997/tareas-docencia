package ec.edu.espe.gpr.docencia.tareas.controller;

import ec.edu.espe.gpr.docencia.tareas.dto.TareaDocenteDocenciaDTO;
import ec.edu.espe.gpr.docencia.tareas.model.TareaDocencia;
import ec.edu.espe.gpr.docencia.tareas.dto.TareaDocenciaDTO;
import ec.edu.espe.gpr.docencia.tareas.model.TareaDocenteDocencia;
import ec.edu.espe.gpr.docencia.tareas.model.informefinal.InformeFinal;
import ec.edu.espe.gpr.docencia.tareas.services.TareaDocenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "https://yellow-river-0ca1d1510.3.azurestaticapps.net", "http://localhost:4200" })
@RestController
@RequestMapping(path = "/tareaDocencia")
@RequiredArgsConstructor
public class TareaDocenciaRestController {

    @Autowired
    private TareaDocenciaService tareaDocenciaService;

    @GetMapping(path = "/listarTodasTareasPorPeriodo/{codigoPeriodo}")
    public ResponseEntity<List<TareaDocenciaDTO>> listarTodasTareasPorDocente(@PathVariable Integer codigoPeriodo) {
        try {
            List<TareaDocenciaDTO> tareasDocencia = this.tareaDocenciaService.listarTodasTareasPorPeriodo(codigoPeriodo);
            return ResponseEntity.ok(tareasDocencia);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/listarTodasTareasAsignadasPorDocente/{idEspeDocente}")
    public ResponseEntity<List<TareaDocenteDocenciaDTO>> listarTodasTareasAsignadasPorDocente(@PathVariable String idEspeDocente) {
        try {
            List<TareaDocenteDocenciaDTO> tareasDocencia = this.tareaDocenciaService.listarTodasTareasAsignadasPorDocente(idEspeDocente);
            return ResponseEntity.ok(tareasDocencia);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/listarTodasTareasNoAsignadasPorDocente/{idEspeDocente}")
    public ResponseEntity<List<TareaDocenteDocenciaDTO>> listarTodasTareasNoAsignadasPorDocente(@PathVariable String idEspeDocente) {
        try {
            List<TareaDocenteDocenciaDTO> tareasDocencia = this.tareaDocenciaService.listarTodasTareasNoAsignadasPorDocente(idEspeDocente);
            return ResponseEntity.ok(tareasDocencia);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/listarTodasTareasSubidasPorPeriodo/{codigoPeriodo}")
    public ResponseEntity<List<TareaDocenteDocenciaDTO>> listarTodasTareasSubidasPorPeriodo(@PathVariable Integer codigoPeriodo) {
        try {
            List<TareaDocenteDocenciaDTO> tareasDocencia = this.tareaDocenciaService.listarTodasTareasSubidasPorPeriodo(codigoPeriodo);
            return ResponseEntity.ok(tareasDocencia);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /*@GetMapping(path = "/listarTodasTareasSubidasModuloDocencia")
    public ResponseEntity<List<TareaDocenteDocenciaDTO>> listarTodasTareasSubidasModuloDocencia() {
        try {
            List<TareaDocenteDocenciaDTO> tareasDocencia = this.tareaDocenciaService.listarTodasTareasSubidasModuloDocencia();
            return ResponseEntity.ok(tareasDocencia);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }*/

    @PostMapping
    public ResponseEntity<String> crearTarea(@RequestBody TareaDocenciaDTO tareaDocenciaDTO) {
        try {
            this.tareaDocenciaService.crearTarea(tareaDocenciaDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/modificarTarea")
    public ResponseEntity<TareaDocencia> modificar(@RequestBody TareaDocenciaDTO tareaDocenciaDTO) {
        try {
            TareaDocencia tarea = this.tareaDocenciaService.actualizarTarea(tareaDocenciaDTO);
            return ResponseEntity.ok(tarea);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/guardarTareaParaRevisar")
    public ResponseEntity<TareaDocenteDocencia> guardarTareaParaRevisar(@RequestBody TareaDocenteDocencia tareaDocenteDocencia) {
        try {
            TareaDocenteDocencia tarea = this.tareaDocenciaService.guardarTareaParaRevisar(tareaDocenteDocencia);
            return ResponseEntity.ok(tarea);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/guardarTareaComoBorrador/{idTareaDocente}")
    public ResponseEntity<TareaDocenteDocencia> guardarTareaComoBorrador(@PathVariable String idTareaDocente,@RequestBody InformeFinal tareaDocenteDocencia) {
        try {
            TareaDocenteDocencia tarea = this.tareaDocenciaService.guardarTareaComoBorrador(idTareaDocente, tareaDocenteDocencia);
            return ResponseEntity.ok(tarea);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/guardarTareaParaSubir/{idTareaDocente}")
    public ResponseEntity<TareaDocenteDocencia> guardarTareaParaSubir(@PathVariable String idTareaDocente,@RequestBody InformeFinal tareaDocenteDocencia) {
        try {
            TareaDocenteDocencia tarea = this.tareaDocenciaService.guardarTareaParaSubir(idTareaDocente, tareaDocenteDocencia);
            return ResponseEntity.ok(tarea);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/habilitarTareaParaEditar")
    public ResponseEntity<String> habilitarTareaParaEditar(@RequestBody String idTareaDocente) {
        try {
            this.tareaDocenciaService.habilitarTareaParaEditar(idTareaDocente);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /*
    @DeleteMapping("/eliminarTarea/{codigoTarea}")
    public ResponseEntity<String> eliminarTarea(@PathVariable String codigoTarea) {
        try {
            this.tareaDocenteService.eliminarTarea(codigoTarea);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e.getMessage() );
            return ResponseEntity.badRequest().build();
        }
    }
    */

}

