package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.EmeHabilidadModel;
import cl.tbdlab.voluntariadoGrupo1.models.InstitucionModel;

import java.util.List;

public interface EmeHabilidadRepository {
    public int createEmeHabilidad(EmeHabilidadModel emeHabilidadModel);
    public EmeHabilidadModel readEmeHabilidad(Long id);
    public int updateEmeHabilidad(EmeHabilidadModel emeHabilidadModel, Long id);
    public int deleteEmeHabilidad(Long id);
    public List<EmeHabilidadModel> readAllEmeHabilidad();
    public int deleteAllEmeHabilidad();
}
