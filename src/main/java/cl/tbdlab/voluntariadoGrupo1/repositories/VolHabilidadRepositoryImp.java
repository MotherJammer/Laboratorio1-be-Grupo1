package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.VolHabilidadModel;
import cl.tbdlab.voluntariadoGrupo1.models.VoluntarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class VolHabilidadRepositoryImp implements VolHabilidadRepository{
    @Autowired
    private Sql2o sql2o;
    public int createVolHabilidad(VolHabilidadModel vol_ha){
        try (Connection connection = sql2o.open()){
            connection.createQuery("INSERT INTO db_emerg.vol_ha (id_vo, id_ha) VALUES (:id_vo, :id_ha);")
                    .addParameter("id_vo", vol_ha.getId_vo())
                    .addParameter("id_ha", vol_ha.getId_ha())
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public VolHabilidadModel readVolHabilidad(Long id){
        try (Connection connection = sql2o.open()){
            VolHabilidadModel vol_ha = connection.createQuery("SELECT * FROM db_emerg.vol_ha AS v WHERE v.id = :id;")
                    .addParameter("id", id)
                    .executeAndFetchFirst(VolHabilidadModel.class);
            return vol_ha;
        }
        catch (Exception err){
            return null;
        }
    }

    @Override
    public int updateVolHabilidad(VolHabilidadModel vol_ha, Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("UPDATE db_emerg.vol_habilidad AS v SET id_vo = :id_vo, id_ha = :id_ha WHERE v.id = :id;")
                    .addParameter("id_ha", vol_ha.getId_ha())
                    .addParameter("id_vo", vol_ha.getId_vo())
                    .addParameter("id", id)
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public int deleteVolHabilidad(Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.vol_habilidad AS v WHERE v.id = :id;")
                    .addParameter("id", id)
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public List<VolHabilidadModel> readAllVolHabilidad(){
        try (Connection connection = sql2o.open()){
            List<VolHabilidadModel> vol_hab = connection.createQuery("SELECT * FROM db_emerg.vol_habilidad;")
                    .executeAndFetch(VolHabilidadModel.class);
            return vol_hab;
        }
        catch (Exception err){
            return null;
        }
    }

    @Override
    public int deleteAllVolHabilidad(){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.vol_habilidad")
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }
}
