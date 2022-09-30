package cl.tbdlab.voluntariadoGrupo1.repositories;


import cl.tbdlab.voluntariadoGrupo1.models.InstitucionModel;

import java.util.List;

public interface InstitucionRepository {
    public int createInstitucion(InstitucionModel institucion);
    public InstitucionModel readInstitucion(Long id);
    public int updateInstitucion(InstitucionModel institucion, Long id);
    public int deleteInstitucion(Long id);
    public List<InstitucionModel> readAllInstituciones();
    public int deleteAllInstituciones();
    public  Long readInstitucionByName(String name);

}
