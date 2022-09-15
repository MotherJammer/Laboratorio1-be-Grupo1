package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.VoluntarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int createVoluntario(VoluntarioModel voluntario){
        try (Connection connection = sql2o.open()){
            connection.createQuery("INSERT INTO db_emerg.voluntario (nombre, disponibilidad) VALUES (:nombre, :disponibilidad);")
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("disponibilidad", voluntario.getDisponibilidad())
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public VoluntarioModel readVoluntario(Long id){
        try (Connection connection = sql2o.open()){
            VoluntarioModel voluntario = connection.createQuery("SELECT * FROM db_emerg.voluntario AS v WHERE v.id = :id;")
                    .addParameter("id", id)
                    .executeAndFetchFirst(VoluntarioModel.class);
            return voluntario;
        }
        catch (Exception err){
            return null;
        }
    }

    @Override
    public int updateVoluntario(VoluntarioModel voluntario, Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("UPDATE db_emerg.voluntario AS v SET nombre = :nombre, disponibilidad = :disponibilidad WHERE v.id = :id;")
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("disponibilidad", voluntario.getDisponibilidad())
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public int deleteVoluntario(Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.voluntario AS v WHERE v.id = :id;")
                    .addParameter("id", id)
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public List<VoluntarioModel> readAllVoluntarios(){
        try (Connection connection = sql2o.open()){
            List<VoluntarioModel> voluntarios = connection.createQuery("SELECT * FROM db_emerg.voluntario;")
                    .executeAndFetch(VoluntarioModel.class);
            return voluntarios;
        }
        catch (Exception err){
            return null;
        }
    }

    @Override
    public int deleteAllVoluntarios(){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.voluntario")
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }
}
