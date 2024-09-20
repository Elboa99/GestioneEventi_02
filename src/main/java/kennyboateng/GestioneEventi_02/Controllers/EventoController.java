package kennyboateng.GestioneEventi_02.Controllers;

import kennyboateng.GestioneEventi_02.Services.EventoService;
import kennyboateng.GestioneEventi_02.Entities.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventi")
public class EventoController {

    @Autowired
    private EventoService eventoService;


    @GetMapping
    public List<Evento> getAllEventi() {
        return eventoService.trovaTuttiEventi();
    }


    @GetMapping("/{id}")
    public Evento getEventoById(@PathVariable Long id) {
        return eventoService.trovaEventoById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Evento createEvento(@RequestBody Evento evento) {
        return eventoService.salvaEvento(evento);
    }


    @PutMapping("/{id}")
    public Evento updateEvento(@PathVariable Long id, @RequestBody Evento evento) {
        Evento eventoEsistente = eventoService.trovaEventoById(id);

        eventoEsistente.setTitolo(evento.getTitolo());
        eventoEsistente.setDescrizione(evento.getDescrizione());
        eventoEsistente.setDataEvento(evento.getDataEvento());
        eventoEsistente.setLuogo(evento.getLuogo());
        eventoEsistente.setPostiDisponibili(evento.getPostiDisponibili());
        return eventoService.salvaEvento(eventoEsistente);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvento(@PathVariable Long id) {
        eventoService.cancellaEventoById(id);
    }
}