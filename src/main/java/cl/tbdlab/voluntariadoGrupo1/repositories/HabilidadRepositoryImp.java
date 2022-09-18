package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.HabilidadModel;
import cl.tbdlab.voluntariadoGrupo1.models.InstitucionModel;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Autowired
    EmergenciaRepositoryImp emergenciaRepositoryImp;

    @Override
    public int createHabilidad(HabilidadModel habilidad){
        try (Connection connection = sql2o.open()){
            connection.createQuery("INSERT INTO db_emerg.habilidad (nombre)" +
                            "VALUES (:nombre);")
                    .addParameter("nombre", habilidad.getNombre())
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }
    @Override
    public HabilidadModel readHabilidad(Long id){
        try (Connection connection = sql2o.open()){
            HabilidadModel habilidad = connection.createQuery("SELECT * FROM db_emerg.habilidad AS h WHERE h.id = :id;")
                    .addParameter("id", id)
                    .executeAndFetchFirst(HabilidadModel.class);
            return habilidad;
        }
        catch (Exception err){
            return null;
        }
    }
    @Override
    public int updateHabilidad(HabilidadModel habilidad, Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("UPDATE db_emerg.habilidad AS h SET nombre = :nombre WHERE h.id = :id;")
                    .addParameter("nombre", habilidad.getNombre())
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public int deleteHabilidad(Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.habilidad AS h WHERE h.id = :id;")
                    .addParameter("id", id)
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public List<HabilidadModel> readAllHabilidades(){
        try (Connection connection = sql2o.open()){
            List<HabilidadModel> habilidades = connection.createQuery("SELECT * FROM db_emerg.habilidad;")
                    .executeAndFetch(HabilidadModel.class);
            return habilidades;
        }
        catch (Exception err){
            return null;
        }
    }

    @Override
    public int deleteAllHabilidades(){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.habilidad")
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public int temporalEme_Habilidad(List<Integer> idHabilidades){
        int lastRecord = emergenciaRepositoryImp.lastRecord() + 1; //le sumo uno ya que me obtiene el ultimo antes del nuevo INSERTE emergencia
        //intente que por cada habilidad seleccionada se itere y se agregue a la db, no pasa de la query
        for (int i=0;i<idHabilidades.size();i++){
            try(Connection conn = sql2o.open().setRollbackOnException(false)){
                System.out.println("Conecto a la DB");
                conn.createQuery("INSERT INTO db.emerg.eme_habilidad (id_em ,id_ha)" +
                        "VALUES (:id_em ,:id_ha);")
                        .addParameter("id_em",lastRecord)
                        .addParameter("id_ha", idHabilidades.get(i).intValue())
                        .executeUpdate();

                System.out.println("termino de insertar");
            }
            catch (Exception err){
                return -1;
            }
        }
        return 1;
    }
}
