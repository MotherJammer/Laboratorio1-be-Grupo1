package cl.tbdlab.voluntariadoGrupo1.repositories;

import cl.tbdlab.voluntariadoGrupo1.models.RankingModel;

import java.util.List;

public interface RankingRepository {
    public int createRanking(RankingModel ranking);
    public RankingModel readRanking(Long id);
    public int updateRanking(RankingModel rankingModel, Long id);
    public int deleteRanking(Long id);
    public List<RankingModel> readAllRankings();
    public int deleteAllRankings();
}
