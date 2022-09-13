package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.HabilidadModel;
import cl.tbdlab.voluntariadoGrupo1.models.InstitucionModel;

import java.util.List;

public interface HabilidadRepository {
    public int createHabilidad(HabilidadModel habilidad);
    public HabilidadModel readHabilidad(Long id);
    public int updateHabilidad(HabilidadModel habilidadModel, Long id);
    public int deleteHabilidad(Long id);
    public List<HabilidadModel> readAllHabilidades();
    public int deleteAllHabilidades();
}
