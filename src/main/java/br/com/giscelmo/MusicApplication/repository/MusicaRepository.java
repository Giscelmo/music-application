package br.com.giscelmo.MusicApplication.repository;

import br.com.giscelmo.MusicApplication.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicaRepository extends JpaRepository <Musica, Long> {
    @Query("""
            SELECT m FROM Musica m
            JOIN FETCH m.artista
            """)
    List<Musica> buscarMusicas();

    @Query("""
            SELECT m FROM Musica m JOIN FETCH m.artista WHERE LOWER(m.artista.nome)  = LOWER(:nome)
            """)
    List<Musica> buscarMusicasPorArtista(String nome);
}
