package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.TareaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaRepositoryImp implements TareaRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int createTarea(TareaModel tarea){
        try (Connection connection = sql2o.open()){
            connection.createQuery("INSERT INTO db_emerg.tarea (nombre, id_es, id_em) VALUES (:nombre, :id_es, :id_em);")
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("id_es", tarea.getId_es())
                    .addParameter("id_em", tarea.getId_em())
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public TareaModel readTarea(Long id){
        try (Connection connection = sql2o.open()){
            TareaModel tarea = connection.createQuery("SELECT * FROM db_emerg.tarea AS t WHERE t.id = :id;")
                    .addParameter("id", id)
                    .executeAndFetchFirst(TareaModel.class);
            return tarea;
        }
        catch (Exception err){
            return null;
        }
    }

    @Override
    public int updateTarea(TareaModel tarea, Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("UPDATE db_emerg.tarea AS t SET nombre = :nombre, id_es = :id_es, id_em = :id_em WHERE t.id = :id;")
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("id_es", tarea.getId_es())
                    .addParameter("id_em", tarea.getId_em())
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public int deleteTarea(Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.tarea AS t WHERE t.id = :id;")
                    .addParameter("id", id)
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public List<TareaModel> readAllTareas(){
        try (Connection connection = sql2o.open()){
            List<TareaModel> tareas = connection.createQuery("SELECT * FROM db_emerg.tarea;")
                    .executeAndFetch(TareaModel.class);
            return tareas;
        }
        catch (Exception err){
            return null;
        }
    }

    @Override
    public int deleteAllTareas(){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.tarea")
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }
}
