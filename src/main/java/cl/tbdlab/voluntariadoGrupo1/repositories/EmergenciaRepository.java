package cl.tbdlab.voluntariadoGrupo1.repositories;
import cl.tbdlab.voluntariadoGrupo1.models.EmergenciaModel;
import cl.tbdlab.voluntariadoGrupo1.models.FinishedEmergencyModel;

import java.util.List;

public interface EmergenciaRepository {
    public int insertEmergencia(String nombre, String estado, String detalles, int volunt, Long id_in, double longitud, double latitud);
    public EmergenciaModel readEmergenciaId(int id);
    public List<EmergenciaModel> readEmergencia();
    public int updateEmergencia(EmergenciaModel emergencia, Long id);
    public int deleteEmergencia(Long id);
    public int deleteEmergencia();
    public int lastRecord();
    public List<FinishedEmergencyModel> getFinishedEmergencies();
}
