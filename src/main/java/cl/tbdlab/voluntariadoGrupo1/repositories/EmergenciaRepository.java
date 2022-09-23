package cl.tbdlab.voluntariadoGrupo1.repositories;
import cl.tbdlab.voluntariadoGrupo1.models.Emergencia;

import java.util.List;

public interface EmergenciaRepository {
    public int insertEmergencia(Emergencia emergencia);
    public Emergencia readEmergencia(Long id);
    public List<Emergencia> readEmergencia();
    public int updateEmergencia(Emergencia emergencia, long id);
    public int deleteEmergencia(Long id);
    public int deleteEmergencia();

    public Long lastRecord();
}
