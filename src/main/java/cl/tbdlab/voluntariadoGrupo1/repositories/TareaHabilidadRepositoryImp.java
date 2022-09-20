package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.TareaHabilidadModel;
import cl.tbdlab.voluntariadoGrupo1.models.VolHabilidadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class TareaHabilidadRepositoryImp implements  TareaHabilidadRepository {
    @Autowired
    private Sql2o sql2o;
    public int createTareaHabilidad(TareaHabilidadModel ta_ha){
        try (Connection connection = sql2o.open()){
            connection.createQuery("INSERT INTO db_emerg.tarea_habilidad (id_ta, id_ha) VALUES (:id_ta, :id_ha);")
                    .addParameter("id_ta", ta_ha.getId_ta())
                    .addParameter("id_ha", ta_ha.getId_ha())
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public TareaHabilidadModel readTareaHabilidad(Long id){
        try (Connection connection = sql2o.open()){
            TareaHabilidadModel ta_ha = connection.createQuery("SELECT * FROM db_emerg.tarea_habilidad AS t WHERE t.id = :id;")
                    .addParameter("id", id)
                    .executeAndFetchFirst(TareaHabilidadModel.class);
            return ta_ha;
        }
        catch (Exception err){
            return null;
        }
    }

    @Override
    public int updateTareaHabilidad(TareaHabilidadModel vol_ha, Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("UPDATE db_emerg.vol_habilidad AS v SET id_ta = :id_vo, id_ha = :id_ha WHERE v.id = :id;")
                    .addParameter("id_ha", vol_ha.getId_ha())
                    .addParameter("id_ta", vol_ha.getId_ta())
                    .addParameter("id", id)
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public int deleteTareaHabilidad(Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.tarea_habilidad AS v WHERE v.id = :id;")
                    .addParameter("id", id)
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public List<TareaHabilidadModel> readAllTareaHabilidad(){
        try (Connection connection = sql2o.open()){
            List<TareaHabilidadModel> ta_hab = connection.createQuery("SELECT * FROM db_emerg.tarea_habilidad;")
                    .executeAndFetch(TareaHabilidadModel.class);
            return ta_hab;
        }
        catch (Exception err){
            return null;
        }
    }

    @Override
    public int deleteAllTareaHabilidad(){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.tarea_habilidad")
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }
}
