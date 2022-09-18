package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository {
    @Autowired
    private Sql2o sql2o;
    @Override
    public int insertEmergencia(Emergencia em){
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO db_emerg.emergencia (nombre, estado_eme, detalles, voluntarios_reg, id_in)" +
                    "VALUES (:nombre, :estado_eme, :detalles, :voluntarios_reg, :id_in);")
                    .addParameter("nombre", em.getNombre())
                    .addParameter("estado_eme", em.getEstado_eme())
                    .addParameter("detalles", em.getDetalles())
                    .addParameter("voluntarios_reg", em.getVoluntarios_reg())
                    .addParameter("id_in", em.getId_in())
                    .executeUpdate();
            return 1;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
    @Override
    public List<Emergencia>readEmergencia(){
        try(Connection conn = sql2o.open()){
            List<Emergencia> emergencia = conn.createQuery("SELECT * FROM db_emerg.emergencia;")
                    .executeAndFetch(Emergencia.class);
            return emergencia;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public Emergencia readEmergencia(Long id) {
        try(Connection conn = sql2o.open()){
            Emergencia emergencia = conn.createQuery("SELECT * FROM db_emerg.emergencia as e WHERE e.id = :id;")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Emergencia.class);
            return emergencia;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public int updateEmergencia(Emergencia emergencia, long id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE db_emerg.emergencia as e SET nombre = :nombre, estado_eme = :estado," +
                    "detalles = :detalles, voluntarios_reg = :voluntarios_reg, id_in = :id_in WHERE e.id = :id;")
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("estado",emergencia.getEstado_eme())
                    .addParameter("detalles", emergencia.getDetalles())
                    .addParameter("voluntarios_reg",emergencia.getVoluntarios_reg())
                    .addParameter("id_in", emergencia.getId_in())
                    .addParameter("id", id)
                    .executeUpdate();
            return 1;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
    @Override
    public int deleteEmergencia(Long id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM db_emerg.emergencia as e WHERE e.id = :id;")
                    .addParameter("id", id)
                    .executeUpdate();
            return 1;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
    @Override
    public int deleteEmergencia(){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM db_emerg.emergencia")
                    .executeUpdate();
            return 1;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    //me obtiene el ultimo id de la tabla emergencia
    public int lastRecord (){
        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT  MAX(id) FROM db_emerg.emergencia")
                    .executeScalar(int.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
