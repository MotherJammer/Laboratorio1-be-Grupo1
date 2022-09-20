package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.VolHabilidadModel;

import java.util.List;

public interface VolHabilidadRepository {
    public int createVolHabilidad(VolHabilidadModel vol_ha);
    public VolHabilidadModel readVolHabilidad(Long id);
    public int updateVolHabilidad(VolHabilidadModel vol_ha, Long id);
    public int deleteVolHabilidad(Long id);
    public List<VolHabilidadModel> readAllVolHabilidad();
    public int deleteAllVolHabilidad();
}
