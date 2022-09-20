package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.TareaHabilidadModel;
import cl.tbdlab.voluntariadoGrupo1.models.VolHabilidadModel;

import java.util.List;
public interface TareaHabilidadRepository {
    int createTareaHabilidad(TareaHabilidadModel vol_ha);
    TareaHabilidadModel readTareaHabilidad(Long id);
    int updateTareaHabilidad(TareaHabilidadModel vol_ha, Long id);
    int deleteTareaHabilidad(Long id);
    List<TareaHabilidadModel> readAllTareaHabilidad();
    int deleteAllTareaHabilidad();
}
