package kennyboateng.GestioneEventi_02.Controllers;

import kennyboateng.GestioneEventi_02.Services.UtenteService;
import kennyboateng.GestioneEventi_02.Entities.Utente;
import kennyboateng.GestioneEventi_02.Excepitions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public List<Utente> getAllUtenti() {
        return utenteService.findAllUtenti();
    }

    @GetMapping("/{id}")
    public Utente getUtenteById(@PathVariable Long id) {
        return utenteService.trovaUtenteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Utente createUtente(@RequestBody @Validated Utente utente, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            throw new BadRequestException("Dati non validi.");
        }
        return utenteService.salvaUtente(utente);
    }

    @PutMapping("/{id}")
    public Utente updateUtente(@PathVariable Long id, @RequestBody Utente utente) {
        Utente utenteEsistente = utenteService.trovaUtenteById(id);

        
        utenteEsistente.setEmail(utente.getEmail());
        utenteEsistente.setPassword(utente.getPassword());
        utenteEsistente.setRuolo(utente.getRuolo());
        return utenteService.salvaUtente(utenteEsistente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUtente(@PathVariable Long id) {
        utenteService.cancellaUtenteById(id);
    }
}
