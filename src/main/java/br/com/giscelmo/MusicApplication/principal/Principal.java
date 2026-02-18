package br.com.giscelmo.MusicApplication.principal;

import br.com.giscelmo.MusicApplication.model.Artista;
import br.com.giscelmo.MusicApplication.model.GeneroMusical;
import br.com.giscelmo.MusicApplication.model.Musica;
import br.com.giscelmo.MusicApplication.model.TipoArtista;
import br.com.giscelmo.MusicApplication.repository.ArtistaRepository;
import br.com.giscelmo.MusicApplication.repository.MusicaRepository;
import br.com.giscelmo.MusicApplication.service.OpenAIService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Principal {
    private ArtistaRepository artistaRepository;
    private MusicaRepository musicaRepository;
    private final OpenAIService consultaChatGPT;



    public Principal(ArtistaRepository artistaRepository, MusicaRepository musicaRepository, OpenAIService consultaChatGPT) {
        this.artistaRepository = artistaRepository;
        this.musicaRepository = musicaRepository;
        this.consultaChatGPT = consultaChatGPT;
    }

    private Scanner leitura = new Scanner(System.in);

    public void executar() {
        var opcao = -1;

        while (opcao != 0) {
            String menu = ("""
                *** Screen Sound Music *** 
                1 - Cadastrar artista
                2 - Cadastrar músicas
                3 - Listar músicas
                4 - Buscar músicas por artistas
                5 - Pesquisar dados sobre um artista
                
                0 - Sair""");
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo");
                    break;
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    buscarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    return;
            }
        }
    }

    private void cadastrarArtista() {

        String resposta = "S";

        while (resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("SIM")){
            System.out.println("Digite o nome do Artista: ");
            String nome = leitura.nextLine();
            System.out.println("""
                    1 - Solo
                    2 - Dupla
                    3 - Banda""");
            int opcaoArtista = leitura.nextInt();
            leitura.nextLine();

            TipoArtista tipo = null;

            switch (opcaoArtista) {
                case 1:
                    tipo = TipoArtista.SOLO;
                    break;
                case 2:
                    tipo = TipoArtista.DUPLA;
                    break;
                case 3:
                    tipo = TipoArtista.BANDA;
                    break;
                default:
                    System.out.println("Tipo inválido");
                    continue;

            }

            Optional<Artista> artistaExistente = artistaRepository.buscarArtistaPorNome(nome);

            if(artistaExistente.isPresent()){
                System.out.println("Artista já existe");
            } else {
                Artista artista = new Artista(nome, tipo);
                artistaRepository.save(artista);
                System.out.println("Artista cadastrado com sucesso!");
            }

            resposta = pergutarContinuar();
        }
    }

    private String pergutarContinuar() {
        while (true) {
            System.out.println("Cadastrar outro Artista? (S/N)");
            String resposta = leitura.nextLine();
            if(resposta.equalsIgnoreCase("S") ||
                    resposta.equalsIgnoreCase("SIM") ||
                    resposta.equalsIgnoreCase("N") ||
                    resposta.equalsIgnoreCase("NAO") ||
                    resposta.equalsIgnoreCase("NÃO")){
                return resposta;
            }
            System.out.println("Opção inválida!");
        }
    }

    private void cadastrarMusica() {
        System.out.println("""
               ****** Cadastrar música ******
               Digite o nome do Artisa/Dupla/Banda: """);
        String nomeArtista = leitura.nextLine();
        Optional<Artista> buscarArtistaPorNome = artistaRepository.buscarArtistaPorNome(nomeArtista);

        if (buscarArtistaPorNome.isPresent()) {
            System.out.println("Artista presente");
            System.out.println("Digite o nome da musica: ");
            String nomeMusica = leitura.nextLine();
            System.out.println("Digita o album: ");
            String album = leitura.nextLine();


            GeneroMusical genero = null;
            while (genero == null) {
                System.out.println("""
                        Genero músical
                        1  - BLUES
                        2  - CLASSICO
                        3  - ELETRONICO
                        4  - FORRO
                        5  - FUNK_CARIOCA
                        6  - HIP_HOP
                        7  - JAZZ
                        8  - MPB
                        9  - POP
                        10 - RAP
                        11 - ROCK
                        12 - SAMBA
                        13 - SERTANEJO
                        14 - SOUL""");
                int opcaoGenero = leitura.nextInt();
                leitura.nextLine();

                switch (opcaoGenero) {
                    case 1:
                        genero = GeneroMusical.BLUES;
                        break;
                    case 2:
                        genero = GeneroMusical.CLASSICO;
                        break;
                    case 3:
                        genero = GeneroMusical.ELETRONICO;
                        break;
                    case 4:
                        genero = GeneroMusical.FORRO;
                        break;
                    case 5:
                        genero = GeneroMusical.FUNK_CARIOCA;
                        break;
                    case 6:
                        genero = GeneroMusical.HIP_HOP;
                        break;
                    case 7:
                        genero = GeneroMusical.JAZZ;
                        break;
                    case 8:
                        genero = GeneroMusical.MPB;
                        break;
                    case 9:
                        genero = GeneroMusical.POP;
                        break;
                    case 10:
                        genero = GeneroMusical.RAP;
                        break;
                    case 11:
                        genero = GeneroMusical.ROCK;
                        break;
                    case 12:
                        genero = GeneroMusical.SAMBA;
                        break;
                    case 13:
                        genero = GeneroMusical.SERTANEJO;
                        break;
                    case 14:
                        genero = GeneroMusical.SOUL;
                        break;
                    default:
                        System.out.println("Opção inválida");
                        continue;
                }
            }

            System.out.println("Digite o tempo em segundos: ");
            int tempo = leitura.nextInt();
            leitura.nextLine();

            Artista artista = buscarArtistaPorNome.get();
            Musica musica = new Musica(nomeMusica, album, genero, tempo, artista);
            musicaRepository.save(musica);

            System.out.println("Musica salva com sucesso!");

        } else {
            System.out.println("Não tem o artista no BD");
            cadastrarArtista();
        }
    }

    private void buscarMusicas() {

        List<Musica> buscarMusicas = musicaRepository.buscarMusicas();
        buscarMusicas.forEach(m ->
                System.out.println("""
                        Nome: %s - Artista: %s """.formatted(m.getNomeMusica(), m.getArtista().getNome())));
    }

    private void buscarMusicaPorArtista() {
        System.out.println("Digite o nome do Artista: ");
        String nome = leitura.nextLine();
        List<Musica> musicasEncontrads = musicaRepository.buscarMusicasPorArtista(nome);
        if (musicasEncontrads.isEmpty()) {
            System.out.println("Nenhuma musica encontrada para este artista");
        } else {
            System.out.println("""
                    %s
                    ****** Musicas ******""".formatted(nome));
            musicasEncontrads.forEach(m ->
                    System.out.println("""
                       %s""".formatted(m.getNomeMusica())));

        }
    }

    private void pesquisarDadosDoArtista() {
        System.out.println("Digite o artista:");
        String nome = leitura.nextLine();
        String resposta = consultaChatGPT.obterInformacaoArtista(nome);
        System.out.println(resposta);
    }

}
