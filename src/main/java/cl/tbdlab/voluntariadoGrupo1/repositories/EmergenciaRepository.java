package cl.tbdlab.voluntariadoGrupo1.repositories;
import cl.tbdlab.voluntariadoGrupo1.models.Emergencia;

import java.util.List;

public interface EmergenciaRepository {
    public int insertEmergencia(String nombre, String estado, String detalles, int volunt, String nombre_in);
    public Emergencia readEmergencia(Long id);
    public List<Emergencia> readEmergencia();
    public int updateEmergencia(Emergencia emergencia, long id);
    public int deleteEmergencia(Long id);
    public int deleteEmergencia();

    public int lastRecord();
}
