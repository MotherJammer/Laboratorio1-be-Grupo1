package cl.tbdlab.voluntariadoGrupo1.repositories;
import cl.tbdlab.voluntariadoGrupo1.models.Emergencia;

import java.util.List;

public interface EmergenciaRepository {
    public int insertEmergencia(Emergencia emergencia);
    public Emergencia readEmergencia(int id);
    public List<Emergencia> readEmergencia();
    public int updateEmergencia(Emergencia id);
    public int deleteEmergencia(int id);
    public int deleteEmergencia();
}
