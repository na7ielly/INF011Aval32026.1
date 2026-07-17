package br.edu.ifba.inf011.avaliacao3.visitor;

import br.edu.ifba.inf011.avaliacao3.composite.ConteudoComponent;
import br.edu.ifba.inf011.model.comercial.Episodio;
import br.edu.ifba.inf011.model.comercial.Filme;
import br.edu.ifba.inf011.model.comercial.Pacote;
import br.edu.ifba.inf011.model.comercial.Serie;
import br.edu.ifba.inf011.model.playlist.MP3;
import br.edu.ifba.inf011.model.playlist.Playlist;
import br.edu.ifba.inf011.model.playlist.PlaylistItem;
import br.edu.ifba.inf011.model.playlist.VideoClipe;

/** ConcreteVisitor responsável pelo relatório hierárquico de nomes. */
public class RelatorioNomesVisitor implements PlaylistVisitor {

    private final StringBuilder relatorio;
    private int nivel;

    public RelatorioNomesVisitor() {
        this.relatorio = new StringBuilder();
    }

    @Override
    public void visit(Playlist playlist) {
        this.relatorio.setLength(0);
        this.nivel = 0;
        this.adicionarLinha("Playlist");
        this.nivel++;
        for (PlaylistItem item : playlist.getItems()) {
            item.accept(this);
        }
        this.nivel--;
    }

    @Override
    public void visit(MP3 mp3) {
        this.adicionarLinha("MP3: " + mp3.getNome());
    }

    @Override
    public void visit(VideoClipe videoClipe) {
        this.adicionarLinha("Videoclipe: " + videoClipe.getNome());
    }

    @Override
    public void visit(Filme filme) {
        this.adicionarLinha("Filme: " + filme.getTitulo());
    }

    @Override
    public void visit(Episodio episodio) {
        this.adicionarLinha("Episódio " + episodio.getNumero() + ": " + episodio.getTitulo());
    }

    @Override
    public void visit(Serie serie) {
        this.adicionarLinha("Série: " + serie.getTitulo() + " - temporada " + serie.getTemporada());
        this.nivel++;
        for (Episodio episodio : serie.getEpisodios()) {
            episodio.accept(this);
        }
        this.nivel--;
    }

    @Override
    public void visit(Pacote pacote) {
        this.adicionarLinha("Pacote: " + pacote.getTitulo());
        this.nivel++;
        for (ConteudoComponent conteudo : pacote.getConteudos()) {
            conteudo.accept(this);
        }
        this.nivel--;
    }

    private void adicionarLinha(String texto) {
        this.relatorio.append("  ".repeat(this.nivel))
                .append(texto)
                .append(System.lineSeparator());
    }

    public String getRelatorio() {
        return this.relatorio.toString();
    }
}
