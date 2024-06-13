package mk.ukim.finki.vb.repository.emt;


import mk.ukim.finki.vb.model.emt.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country,Long> {
}
