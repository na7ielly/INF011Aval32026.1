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

/** ConcreteVisitor responsável pela exportação da playlist para XML. */
public class XmlPlaylistVisitor implements PlaylistVisitor {

    private final StringBuilder xml;
    private int nivel;

    public XmlPlaylistVisitor() {
        this.xml = new StringBuilder();
    }

    @Override
    public void visit(Playlist playlist) {
        this.xml.setLength(0);
        this.nivel = 0;
        this.adicionarLinha("<playlist>");
        this.nivel++;
        for (PlaylistItem item : playlist.getItems()) {
            item.accept(this);
        }
        this.nivel--;
        this.adicionarLinha("</playlist>");
    }

    @Override
    public void visit(MP3 mp3) {
        this.adicionarLinha("<mp3 nome=\"" + this.escapar(mp3.getNome())
                + "\" tamanhoMB=\"" + mp3.getTamanhoMegaBytes() + "\"/>");
    }

    @Override
    public void visit(VideoClipe videoClipe) {
        this.adicionarLinha("<videoclipe nome=\"" + this.escapar(videoClipe.getNome())
                + "\" tamanhoMB=\"" + videoClipe.getTamanhoMegaBytes()
                + "\" link=\"" + this.escapar(videoClipe.getLink()) + "\"/>");
    }

    @Override
    public void visit(Filme filme) {
        this.adicionarLinha("<filme titulo=\"" + this.escapar(filme.getTitulo())
                + "\" preco=\"" + filme.getPreco()
                + "\" duracao=\"" + filme.getDuracao() + "\"/>");
    }

    @Override
    public void visit(Episodio episodio) {
        this.adicionarLinha("<episodio titulo=\"" + this.escapar(episodio.getTitulo())
                + "\" numero=\"" + episodio.getNumero()
                + "\" preco=\"" + episodio.getPreco()
                + "\" duracao=\"" + episodio.getDuracao() + "\"/>");
    }

    @Override
    public void visit(Serie serie) {
        this.adicionarLinha("<serie titulo=\"" + this.escapar(serie.getTitulo())
                + "\" temporada=\"" + serie.getTemporada() + "\">");
        this.nivel++;
        for (Episodio episodio : serie.getEpisodios()) {
            episodio.accept(this);
        }
        this.nivel--;
        this.adicionarLinha("</serie>");
    }

    @Override
    public void visit(Pacote pacote) {
        this.adicionarLinha("<pacote titulo=\"" + this.escapar(pacote.getTitulo()) + "\">");
        this.nivel++;
        for (ConteudoComponent conteudo : pacote.getConteudos()) {
            conteudo.accept(this);
        }
        this.nivel--;
        this.adicionarLinha("</pacote>");
    }

    private void adicionarLinha(String texto) {
        this.xml.append("  ".repeat(this.nivel))
                .append(texto)
                .append(System.lineSeparator());
    }

    private String escapar(String valor) {
        if (valor == null) {
            return "";
        }
        return valor.replace("&", "&amp;")
                .replace("\"", "&quot;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("'", "&apos;");
    }

    public String getXml() {
        return this.xml.toString();
    }
}
