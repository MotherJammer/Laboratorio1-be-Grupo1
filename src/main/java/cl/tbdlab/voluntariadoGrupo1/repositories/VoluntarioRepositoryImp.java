package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.CercanoModel;
import cl.tbdlab.voluntariadoGrupo1.models.EmergenciaModel;
import cl.tbdlab.voluntariadoGrupo1.models.VoluntarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int createVoluntario(String nombre, Boolean disponibilidad, double longitud, double latitud){
        try (Connection connection = sql2o.open()){
            String geom = "POINT (" + longitud + " " + latitud + ")";
            connection.createQuery("INSERT INTO db_emerg.voluntario (nombre, disponibilidad, point)" +
                            " VALUES (:nombre, :disponibilidad, ST_GeomFromText(:point, 4326));")
                    .addParameter("nombre", nombre)
                    .addParameter("disponibilidad", disponibilidad)
                    .addParameter("point", geom)
                    .executeUpdate();
            return (lastRecord());
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public VoluntarioModel readVoluntario(int id){
        try (Connection connection = sql2o.open()){
            VoluntarioModel voluntario = connection.createQuery("SELECT id, nombre, disponibilidad, ST_X(ST_ASTEXT(point)) AS longitud, ST_Y(ST_ASTEXT(point)) as latitud FROM db_emerg.voluntario AS v WHERE v.id = :id;")
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

            String point = "POINT(" + voluntario.getLongitud() + " " + voluntario.getLatitud() + ")";

            connection.createQuery("UPDATE db_emerg.voluntario AS v" +
                            " SET nombre = :nombre, disponibilidad = :disponibilidad, point = ST_GeomFromText(:point, 4326)" +
                            " WHERE v.id = :id;")
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("disponibilidad", voluntario.getDisponibilidad())
                    .addParameter("point", point)
                    .executeUpdate();
            return (id.intValue());
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
            List<VoluntarioModel> voluntarios = connection.createQuery("SELECT id, nombre, disponibilidad, ST_X(ST_ASTEXT(point)) AS longitud, ST_Y(ST_ASTEXT(point)) as latitud FROM db_emerg.voluntario AS v;")
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

    @Override
    public int lastRecord(){
        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT  MAX(id) FROM db_emerg.emergencia")
                    .executeScalar(Integer.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public List<VoluntarioModel> getVoluntariosByEmergencia(int idEm) {
        final String query = "SELECT v.id, v.nombre, v.disponibilidad, ST_X(ST_ASTEXT(v.point)) AS longitud, ST_Y(ST_ASTEXT(v.point)) as latitud"+
                " FROM db_emerg.voluntario as v, db_emerg.vol_tarea as vt "+
                "WHERE vt.id_em = :idEm AND v.id = vt.id_vo "+
                "GROUP BY v.id, v.nombre, v.disponibilidad;";
        try (Connection conn = sql2o.open()) {
            List<VoluntarioModel> voluntarios = conn.createQuery(query)
                    .addParameter("idEm", idEm)
                    .executeAndFetch(VoluntarioModel.class);
            return voluntarios;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<CercanoModel> distanciasVoluntariosEmergencia(List<VoluntarioModel> voluntarios, EmergenciaModel emergencia, int cantidad){

        List<CercanoModel> temp = new ArrayList<>();
        List<CercanoModel> finalVol = new ArrayList<>();

        for (VoluntarioModel voluntario : voluntarios) {
            double distanciaTemp = 0;
            double longitude1 = Math.toRadians(emergencia.getLongitud());
            double longitude2 = Math.toRadians(voluntario.getLongitud());
            double latitude1 = Math.toRadians(emergencia.getLatitud());
            double latitude2 = Math.toRadians(voluntario.getLatitud());

            double dlon = longitude2 - longitude1;
            double dlat = latitude2 - latitude1;
            double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(latitude1) * Math.cos(latitude2) * Math.pow(Math.sin(dlon / 2),2);
            double c = 2 * Math.asin(Math.sqrt(a));
            double r = 6371;
            distanciaTemp = r*c;
            temp.add(new CercanoModel(voluntario.getNombre(), distanciaTemp));
        }

        return finalVol;
    }
}
