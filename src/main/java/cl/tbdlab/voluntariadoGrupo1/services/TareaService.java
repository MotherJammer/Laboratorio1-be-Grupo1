package cl.tbdlab.voluntariadoGrupo1.services;

import cl.tbdlab.voluntariadoGrupo1.models.TareaModel;
import cl.tbdlab.voluntariadoGrupo1.repositories.TareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TareaService {

    private final TareaRepository tareaRepository;

    TareaService(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

    @PostMapping("/tareas")
    public int createTarea(@RequestBody TareaModel tarea){
        return tareaRepository.createTarea(tarea);
    }

    @GetMapping("/tareas/{id}")
    public TareaModel getTarea(@PathVariable("id") Long id){
        return tareaRepository.readTarea(id);
    }

    @GetMapping("/tareas")
    public List<TareaModel> getAllTareas(){
        return tareaRepository.readAllTareas();
    }

    @PutMapping("/tareas/{id}")
    public int updateTarea(@PathVariable("id") Long id, @RequestBody TareaModel tarea){
        tarea.setId(id);
        return tareaRepository.updateTarea(tarea, id);
    }

    @DeleteMapping("/tareas/{id}")
    public int deleteTarea(@PathVariable ("id") Long id){
        return tareaRepository.deleteTarea(id);
    }

    @DeleteMapping("/tareas")
    public int deleteAllTarea(){
        return tareaRepository.deleteAllTareas();
    }
}
