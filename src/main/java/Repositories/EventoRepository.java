package Repositories;

import kennyboateng.GestioneEventi_02.Entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
