package mk.ukim.finki.vb.repository.emt;

import mk.ukim.finki.vb.model.emt.Smestuvanje;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmestuvanjeRepo extends JpaRepository<Smestuvanje,Long> {
//    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
//            attributePaths = {"korisnici"})
//    @Query("select u from Smestuvanje u")
//    List<Smestuvanje> fetchAll();
//
//    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
//            attributePaths = {"korisnici"})
//    @Query("select u from Smestuvanje u")
//    List<Smestuvanje> loadAll();
}
