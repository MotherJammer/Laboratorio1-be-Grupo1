package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.InstitucionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class InstitucionRepositoryImp implements InstitucionRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int createInstitucion(InstitucionModel institucion){
        try (Connection connection = sql2o.open()){
            connection.createQuery("INSERT INTO db_emerg.institucion (nombre, coordinador)" +
                    "VALUES (:nombre, :coordinador);")
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("coordinador", institucion.getCoordinador())
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public InstitucionModel readInstitucion(Long id){
        try (Connection connection = sql2o.open()){
            InstitucionModel institucion = connection.createQuery("SELECT * FROM db_emerg.institucion AS i WHERE i.id = :id;")
                    .addParameter("id", id)
                    .executeAndFetchFirst(InstitucionModel.class);
            return institucion;
        }
        catch (Exception err){
            return null;
        }
    }

    public Long readInstitucionByName(String name){
        try (Connection connection = sql2o.open()){
            Long id_institucion = connection.createQuery("select id from db_emerg.institucion as i where i.nombre = :name")
                    .addParameter("name", name)
                    .executeAndFetchFirst(Long.class);
            return id_institucion;
        }
        catch (Exception err){
            return 0L;
        }
    }

    @Override
    public int updateInstitucion(InstitucionModel institucion, Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("UPDATE db_emerg.institucion AS i SET nombre = :nombre, coordinador = :coordinador WHERE i.id = :id;")
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("coordinador", institucion.getCoordinador())
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public int deleteInstitucion(Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.institucion AS i WHERE i.id = :id;")
                    .addParameter("id", id)
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public List<InstitucionModel> readAllInstituciones(){
        try (Connection connection = sql2o.open()){
            List<InstitucionModel> instituciones = connection.createQuery("SELECT * FROM db_emerg.institucion;")
                    .executeAndFetch(InstitucionModel.class);
            return instituciones;
        }
        catch (Exception err){
            return null;
        }
    }

    @Override
    public int deleteAllInstituciones(){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.institucion")
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }
}
