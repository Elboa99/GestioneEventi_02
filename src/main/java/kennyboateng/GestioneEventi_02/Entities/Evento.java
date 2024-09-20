package kennyboateng.GestioneEventi_02.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eventi")

public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titolo;

    @Column
    private String descrizione;

    @Column
    private Date dataEvento;

    @Column
    private String luogo;

    @Column
    private int postiDisponibili;

    @ManyToOne
    @JoinColumn(name = "organizzatore_id", nullable = false)
    private Utente organizzatore;

    @OneToMany(mappedBy = "evento")
    private List<Prenotazione> prenotazioni;


}
