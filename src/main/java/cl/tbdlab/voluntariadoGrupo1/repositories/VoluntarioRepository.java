package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.VoluntarioModel;

import java.util.List;

public interface VoluntarioRepository {
    public int createVoluntario(VoluntarioModel tarea);
    public VoluntarioModel readVoluntario(Long id);
    public int updateVoluntario(VoluntarioModel tareaModel, Long id);
    public int deleteVoluntario(Long id);
    public List<VoluntarioModel> readAllVoluntarios();
    public int deleteAllVoluntarios();
}
