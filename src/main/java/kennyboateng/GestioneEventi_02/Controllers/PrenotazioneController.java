package kennyboateng.GestioneEventi_02.Controllers;

import kennyboateng.GestioneEventi_02.Services.PrenotazioneService;
import kennyboateng.GestioneEventi_02.Entities.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneService.trovaPrenotazioni();
    }

    @GetMapping("/{id}")
    public Prenotazione getPrenotazioneById(@PathVariable Long id) {
        return prenotazioneService.trovaPrenotazioneById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione createPrenotazione(@RequestBody Prenotazione prenotazione) {
        return prenotazioneService.salvaPrenotazione(prenotazione);
    }

    @PutMapping("/{id}")
    public Prenotazione updatePrenotazione(@PathVariable Long id, @RequestBody Prenotazione prenotazione) {
        Prenotazione prenotazioneEsistente = prenotazioneService.trovaPrenotazioneById(id);
        // Aggiorna i campi della prenotazione esistente
        prenotazioneEsistente.setNumeroPosti(prenotazione.getNumeroPosti());
        return prenotazioneService.salvaPrenotazione(prenotazioneEsistente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePrenotazione(@PathVariable Long id) {
        prenotazioneService.cancellaPrenotazioneById(id);
    }
}