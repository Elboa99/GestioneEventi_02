package Services;

import Repositories.UtenteRepository;
import kennyboateng.GestioneEventi_02.Entities.Utente;
import kennyboateng.GestioneEventi_02.Excepitions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Utente registraUtente(Utente utente) {
        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        return utenteRepository.save(utente);
    }

    public List<Utente> findAllUtenti() {
        return utenteRepository.findAll();
    }

    public Utente salvaUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public void cancellaUtenteById(Long id) {
        utenteRepository.deleteById(id);
    }

    public Utente trovaUtenteById(Long utenteId) {
        return utenteRepository.findById(utenteId)
                .orElseThrow(() -> new NotFoundException("Utente " + utenteId + " non trovato"));
    }

}