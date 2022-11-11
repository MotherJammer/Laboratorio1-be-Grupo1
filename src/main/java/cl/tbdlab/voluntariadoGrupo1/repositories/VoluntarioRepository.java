package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.CercanoModel;
import cl.tbdlab.voluntariadoGrupo1.models.EmergenciaModel;
import cl.tbdlab.voluntariadoGrupo1.models.VoluntarioModel;

import java.util.List;

public interface VoluntarioRepository {
    public int createVoluntario(String nombre, Boolean disponibilidad, double longitud, double latitud);
    public VoluntarioModel readVoluntario(int id);
    public int updateVoluntario(VoluntarioModel tareaModel, Long id);
    public int deleteVoluntario(Long id);
    public List<VoluntarioModel> readAllVoluntarios();
    public int deleteAllVoluntarios();
    public int lastRecord();
    public List<VoluntarioModel> getVoluntariosByEmergencia(int emergenciaId);
    public List<CercanoModel> distanciasVoluntariosEmergencia(List<VoluntarioModel> voluntarios, EmergenciaModel emergencia, int cantidad);
    }
