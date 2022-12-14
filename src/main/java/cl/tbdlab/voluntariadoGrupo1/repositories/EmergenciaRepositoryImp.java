package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.EmergenciaModel;
import cl.tbdlab.voluntariadoGrupo1.models.FinishedEmergencyModel;
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
    public EmergenciaModel readEmergenciaId(int id) {
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
    public int updateEmergencia(EmergenciaModel emergencia, Long id){
        try(Connection conn = sql2o.open()){

            String point = "POINT(" + emergencia.getLongitud() + " " + emergencia.getLatitud() + ")";

            conn.createQuery("UPDATE db_emerg.emergencia as e SET nombre = :nombre, estado_eme = :estado," +
                    "detalles = :detalles, voluntarios_reg = :voluntarios_reg, id_in = :id_in, point = ST_GeomFromText(:point, 4326)" +
                            " WHERE e.id = :id;")
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("estado",emergencia.getEstado_eme())
                    .addParameter("detalles", emergencia.getDetalles())
                    .addParameter("voluntarios_reg",emergencia.getVoluntarios_reg())
                    .addParameter("id_in", emergencia.getId_in())
                    .addParameter("point", point)
                    .executeUpdate();
            return id.intValue();
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
    public List<FinishedEmergencyModel> getFinishedEmergencies(){
        try (Connection conn = sql2o.open()){
            return conn.createQuery
                    ("SELECT e.id, e.nombre, b.vol_reg, count(*) AS tareas" +
                            " FROM db_emerg.emergencia e JOIN db_emerg.tarea t ON t.id_em = e.id" +
                            " JOIN db_emerg.estado_tarea et ON et.id = t.id_es" +
                            " JOIN (" +
                                "SELECT e.id AS id_emerg, count(*) AS vol_reg FROM db_emerg.emergencia e" +
                                " JOIN db_emerg.tarea t ON t.id_em = e.id" +
                                " JOIN db_emerg.ranking r ON r.id_ta = t.id" +
                                " JOIN db_emerg.voluntario v ON v.id = r.id_vo" +
                                " JOIN db_emerg.estado_tarea et ON et.id = t.id_es" +
                                " WHERE e.estado_eme = 'Finalizada' and et.estado_actual = 'Finalizada'" +
                                " GROUP BY e.id" +
                            ") AS b ON b.id_emerg = e.id" +
                            " WHERE e.estado_eme = 'Finalizada' AND et.estado_actual = 'Finalizada'" +
                            " GROUP BY e.id, b.vol_reg").executeAndFetch(FinishedEmergencyModel.class);
        }
    }
}
