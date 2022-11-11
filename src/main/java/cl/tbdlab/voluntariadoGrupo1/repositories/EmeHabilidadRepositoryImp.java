package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.EmeHabilidadModel;
import cl.tbdlab.voluntariadoGrupo1.models.EmergenciaModel;
import cl.tbdlab.voluntariadoGrupo1.models.HabilidadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmeHabilidadRepositoryImp implements EmeHabilidadRepository{

    @Autowired
    Sql2o sql2o;

    @Autowired
    EmergenciaRepository emergenciaRepository;

    @Autowired
    HabilidadRepository habilidadRepository;

    @Override
    public int createEmeHabilidadInDB(EmeHabilidadModel emeHabilidad){
        try (Connection connection = sql2o.open()){
            connection.createQuery("INSERT INTO db_emerg.eme_habilidad (id_em, id_ha)" +
                            "VALUES (:id_em, :id_ha);")
                    .addParameter("id_em", emeHabilidad.getEmergencia().getId())
                    .addParameter("id_ha", emeHabilidad.getHabilidadModel().getId())
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }
    public int createEmeHabilidad(List<Long> idHabilidades){
        int lastRecord = emergenciaRepository.lastRecord();
        EmergenciaModel emergency = emergenciaRepository.readEmergenciaId(lastRecord);
        for (int i=0;i<idHabilidades.size();i++){
            HabilidadModel habilidad = habilidadRepository.readHabilidad(idHabilidades.get(i));
            EmeHabilidadModel emeHabilidad = new EmeHabilidadModel(emergency,habilidad);
            createEmeHabilidadInDB(emeHabilidad);
        }
        return 1;
    }

    @Override
    public EmeHabilidadModel readEmeHabilidad(Long id){
        try (Connection connection = sql2o.open()){
            EmeHabilidadModel emeHabilidad = connection.createQuery("SELECT * FROM db_emerg.eme_habilidad AS eh WHERE eh.id = :id;")
                    .addParameter("id", id)
                    .executeAndFetchFirst(EmeHabilidadModel.class);
            return emeHabilidad;
        }
        catch (Exception err){
            return null;
        }
    }

    @Override
    public int updateEmeHabilidad(EmeHabilidadModel emeHabilidad, Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("UPDATE db_emerg.eme_habilidad AS eh SET id_em = :id_em, id_ha = :id_ha WHERE eh.id = :id;")
                    .addParameter("id_em", emeHabilidad.getEmergencia().getId())
                    .addParameter("id_ha", emeHabilidad.getHabilidadModel().getId())
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public int deleteEmeHabilidad(Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.eme_habilidad AS eh WHERE eh.id = :id;")
                    .addParameter("id", id)
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public List<EmeHabilidadModel> readAllEmeHabilidad(){
        try (Connection connection = sql2o.open()){
            List<EmeHabilidadModel> emeHabilidad = connection.createQuery("SELECT * FROM db_emerg.eme_habilidad;")
                    .executeAndFetch(EmeHabilidadModel.class);
            return emeHabilidad;
        }
        catch (Exception err){
            return null;
        }
    }

    @Override
    public int deleteAllEmeHabilidad(){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.eme_habilidad")
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }
}
