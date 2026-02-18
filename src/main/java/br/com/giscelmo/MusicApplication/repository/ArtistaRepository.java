package br.com.giscelmo.MusicApplication.repository;

import br.com.giscelmo.MusicApplication.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    @Query("SELECT a FROM  Artista a WHERE LOWER(a.nome) = LOWER(:nome) ")
    Optional<Artista> buscarArtistaPorNome(String nome);
//    @Query("""
//            SELECT a FROM Musica a
//            """)
//    List<Artista> buscarMusicas();
}
