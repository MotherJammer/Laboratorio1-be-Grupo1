package cl.tbdlab.voluntariadoGrupo1.services;

import cl.tbdlab.voluntariadoGrupo1.models.RankingModel;
import cl.tbdlab.voluntariadoGrupo1.repositories.RankingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RankingService {

    private final RankingRepository rankingRepository;

    RankingService(RankingRepository rankingRepository){
        this.rankingRepository = rankingRepository;
    }

    @PostMapping("/rankings")
    public int createRanking(@RequestBody RankingModel ranking){
        return rankingRepository.createRanking(ranking);
    }

    @GetMapping("/rankings/{id}")
    public RankingModel getRanking(@PathVariable("id") Long id){
        return rankingRepository.readRanking(id);
    }

    @GetMapping("/rankings")
    public List<RankingModel> getAllRankings(){
        return rankingRepository.readAllRankings();
    }

    @PutMapping("/rankings/{id}")
    public int updateRanking(@PathVariable("id") Long id, @RequestBody RankingModel ranking){
        ranking.setId(id);
        return rankingRepository.updateRanking(ranking, id);
    }

    @DeleteMapping("/rankings/{id}")
    public int deleteRanking(@PathVariable ("id") Long id){
        return rankingRepository.deleteRanking(id);
    }

    @DeleteMapping("/rankings")
    public int deleteAllRanking(){
        return rankingRepository.deleteAllRankings();
    }
}
