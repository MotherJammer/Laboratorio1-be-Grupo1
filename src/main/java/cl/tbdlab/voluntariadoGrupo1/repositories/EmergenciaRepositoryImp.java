package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.EmergenciaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository {
    @Autowired
    private Sql2o sql2o;
    @Autowired
    InstitucionRepositoryImp institucionRepository;
    @Override
    public int insertEmergencia(String nombre, String estado, String detalles, int volunt, Long id_in, double longitud, double latitud){
        try(Connection conn = sql2o.open()){

            String geom = "POINT (" + longitud + " " + latitud + ")";

            conn.createQuery("INSERT INTO db_emerg.emergencia (nombre, estado_eme, detalles, voluntarios_reg, id_in, point)" +
                    "VALUES (:nombre, :estado_eme, :detalles, :voluntarios_reg, :id_in, ST_GeomFromText(:geom, 4326));")
                    .addParameter("nombre", nombre)
                    .addParameter("estado_eme", estado)
                    .addParameter("detalles", detalles)
                    .addParameter("voluntarios_reg", volunt)
                    .addParameter("id_in", id_in)
                    .addParameter("geom", geom)
                    .executeUpdate()
                    .close();
            return lastRecord();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
    @Override
    public List<EmergenciaModel>readEmergencia(){
        try(Connection conn = sql2o.open()){
            List<EmergenciaModel> emergencia = conn.createQuery("SELECT id, nombre, estado_eme, detalles, voluntarios_reg, id_in, ST_X(ST_ASTEXT(point)) AS longitud, ST_Y(ST_ASTEXT(point)) as latitud FROM db_emerg.emergencia;")
                    .executeAndFetch(EmergenciaModel.class);
            return emergencia;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public EmergenciaModel readEmergencia(int id) {
        try(Connection conn = sql2o.open()){
            EmergenciaModel emergencia = conn.createQuery("SELECT id, nombre, estado_eme, detalles, voluntarios_reg, id_in, ST_X(ST_ASTEXT(point)) AS longitud, ST_Y(ST_ASTEXT(point)) as latitud FROM db_emerg.emergencia AS e WHERE e.id = :id;")
                    .addParameter("id", id)
                    .executeAndFetchFirst(EmergenciaModel.class);
            return emergencia;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public int updateEmergencia(EmergenciaModel emergencia, long id){
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
                    .executeScalar(Integer.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
