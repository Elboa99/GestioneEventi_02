package kennyboateng.GestioneEventi_02.Services;

import kennyboateng.GestioneEventi_02.Repositories.PrenotazioneRepository;
import kennyboateng.GestioneEventi_02.Entities.Prenotazione;
import kennyboateng.GestioneEventi_02.Excepitions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;


    public Prenotazione salvaPrenotazione(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> trovaPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public void cancellaPrenotazioneById(Long id) {
        prenotazioneRepository.deleteById(id);
    }
    public Prenotazione trovaPrenotazioneById(Long prenotazioneId) {
        return prenotazioneRepository.findById(prenotazioneId)
                .orElseThrow(() -> new NotFoundException("Prenotazione " + prenotazioneId + " non trovata"));
    }


}
