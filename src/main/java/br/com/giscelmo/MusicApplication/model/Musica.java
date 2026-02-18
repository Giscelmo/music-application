package br.com.giscelmo.MusicApplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_musica", nullable = false)
    private String nomeMusica;
    private String album;
    @Enumerated(EnumType.STRING)
    @Column(name = "genero_musical", nullable = false)
    private GeneroMusical generoMusical;
    @Column(name = "tempo_musica", nullable = false)
    private int tempoMusica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artista_id")
    private Artista artista;

    public Musica() {}

    public Musica(String nomeMusica, String album, GeneroMusical generoMusical, int tempoMusica, Artista artista) {
        this.nomeMusica = nomeMusica;
        this.album = album;
        this.generoMusical = generoMusical;
        this.tempoMusica = tempoMusica;
        this.artista = artista;
    }


    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public GeneroMusical getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(GeneroMusical generoMusical) {
        this.generoMusical = generoMusical;
    }

    public int getTempoMusica() {
        return tempoMusica;
    }

    public void setTempoMusica(int tempoMusica) {
        this.tempoMusica = tempoMusica;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "nomeMusica='" + nomeMusica + '\'' +
                ", album='" + album + '\'' +
                ", generoMusical=" + generoMusical +
                ", tempoMusica=" + tempoMusica +
                ", artista=" + artista +
                '}';
    }
}
