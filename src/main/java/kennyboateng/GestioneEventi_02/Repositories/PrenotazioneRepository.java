package kennyboateng.GestioneEventi_02.Repositories;

import kennyboateng.GestioneEventi_02.Entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
}
