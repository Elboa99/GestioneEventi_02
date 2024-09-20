package kennyboateng.GestioneEventi_02.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "utenti")

public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;


    @Column
    private String ruolo;

    @OneToMany(mappedBy = "organizzatore")
    private List<Evento> eventiOrganizzati;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

}
