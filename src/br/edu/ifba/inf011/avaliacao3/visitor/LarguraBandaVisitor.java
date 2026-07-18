package br.edu.ifba.inf011.avaliacao3.visitor;

import br.edu.ifba.inf011.avaliacao3.composite.ConteudoComponent;
import br.edu.ifba.inf011.model.comercial.Episodio;
import br.edu.ifba.inf011.model.comercial.Filme;
import br.edu.ifba.inf011.model.comercial.Pacote;
import br.edu.ifba.inf011.model.comercial.Serie;
import br.edu.ifba.inf011.model.playlist.MP3;
import br.edu.ifba.inf011.model.playlist.Playlist;
import br.edu.ifba.inf011.model.playlist.PlaylistItem;
import br.edu.ifba.inf011.model.playlist.Video;

/** ConcreteVisitor responsável pelo cálculo da largura de banda total. */
public class LarguraBandaVisitor implements PlaylistVisitor {

    private static final Double TAXA_PADRAO_MB_POR_SEGUNDO = 1.5;

    private final Double megabytesPorSegundo;
    private Double totalMegaBytes;

    public LarguraBandaVisitor() {
        this(TAXA_PADRAO_MB_POR_SEGUNDO);
    }

    public LarguraBandaVisitor(Double megabytesPorSegundo) {
        if (megabytesPorSegundo == null || megabytesPorSegundo < 0.0) {
            throw new IllegalArgumentException("A taxa de banda deve ser maior ou igual a zero.");
        }
        this.megabytesPorSegundo = megabytesPorSegundo;
        this.totalMegaBytes = 0.0;
    }

    @Override
    public void visit(Playlist playlist) {
        this.totalMegaBytes = 0.0;
        for (PlaylistItem item : playlist.getItems()) {
            item.accept(this);
        }
    }

    @Override
    public void visit(MP3 mp3) {
        this.totalMegaBytes += mp3.getTamanhoMegaBytes();
    }

    @Override
    public void visit(Video video) {
        this.totalMegaBytes += video.getTamanhoMegaBytes();
    }

    @Override
    public void visit(Filme filme) {
        this.totalMegaBytes += filme.getDuracao() * this.megabytesPorSegundo;
    }

    @Override
    public void visit(Episodio episodio) {
        this.totalMegaBytes += episodio.getDuracao() * this.megabytesPorSegundo;
    }

    @Override
    public void visit(Serie serie) {
        for (Episodio episodio : serie.getEpisodios()) {
            episodio.accept(this);
        }
    }

    @Override
    public void visit(Pacote pacote) {
        for (ConteudoComponent conteudo : pacote.getConteudos()) {
            conteudo.accept(this);
        }
    }

    public Double getBandaTotal() {
        return this.totalMegaBytes;
    }
}
