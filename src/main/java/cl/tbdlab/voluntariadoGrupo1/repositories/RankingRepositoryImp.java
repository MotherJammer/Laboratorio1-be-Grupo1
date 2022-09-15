package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.RankingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepositoryImp implements RankingRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int createRanking(RankingModel ranking){
        try (Connection connection = sql2o.open()){
            connection.createQuery("INSERT INTO db_emerg.ranking (id_vo, id_ta) VALUES (:id_vo, :id_ta);")
                    .addParameter("id_vo", ranking.getId_vo())
                    .addParameter("id_ta", ranking.getId_ta())
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public RankingModel readRanking(Long id){
        try (Connection connection = sql2o.open()){
            RankingModel ranking = connection.createQuery("SELECT * FROM db_emerg.ranking AS r WHERE r.id = :id;")
                    .addParameter("id", id)
                    .executeAndFetchFirst(RankingModel.class);
            return ranking;
        }
        catch (Exception err){
            return null;
        }
    }

    @Override
    public int updateRanking(RankingModel ranking, Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("UPDATE db_emerg.ranking AS r SET id_vo = :id_vo, id_ta = :id_ta WHERE r.id = :id;")
                    .addParameter("id_vo", ranking.getId_vo())
                    .addParameter("id_ta", ranking.getId_ta())
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public int deleteRanking(Long id){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.ranking AS r WHERE r.id = :id;")
                    .addParameter("id", id)
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }

    @Override
    public List<RankingModel> readAllRankings(){
        try (Connection connection = sql2o.open()){
            List<RankingModel> rankings = connection.createQuery("SELECT * FROM db_emerg.ranking;")
                    .executeAndFetch(RankingModel.class);
            return rankings;
        }
        catch (Exception err){
            return null;
        }
    }

    @Override
    public int deleteAllRankings(){
        try (Connection connection = sql2o.open()){
            connection.createQuery("DELETE FROM db_emerg.ranking")
                    .executeUpdate();
            return (1);
        }
        catch (Exception err){
            return (-1);
        }
    }
}
