package kennyboateng.GestioneEventi_02.Repositories;

import kennyboateng.GestioneEventi_02.Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
