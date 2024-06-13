package mk.ukim.finki.vb.repository.emt;

import mk.ukim.finki.vb.model.emt.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepo  extends JpaRepository<Host,Long>{

}
