package cl.tbdlab.voluntariadoGrupo1.servicesMongo;

import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Promedio;
import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Comuna;
import cl.tbdlab.voluntariadoGrupo1.repositoriesMongo.ComunaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromedioService {

    private ComunaRepository comunaRepository;
    public List<Promedio> promediosComuna(List<Comuna> listado){
        List<Promedio> finalPromedio = new ArrayList<>();
        for (Comuna comuna : listado) {
            double promedio = comuna.getHabilidades() / (comuna.getPersonas() * 1.0);
            finalPromedio.add(new Promedio(comuna.get_id(), promedio));
        }

        return finalPromedio;
    }
}
