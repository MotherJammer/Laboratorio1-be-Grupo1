package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.TareaModel;

import java.util.List;

public interface TareaRepository {
    public int createTarea(TareaModel tarea);
    public TareaModel readTarea(Long id);
    public int updateTarea(TareaModel tareaModel, Long id);
    public int deleteTarea(Long id);
    public List<TareaModel> readAllTareas();
    public int deleteAllTareas();
}
