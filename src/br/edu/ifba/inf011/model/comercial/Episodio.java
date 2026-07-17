package br.edu.ifba.inf011.model.comercial;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;
import br.edu.ifba.inf011.avaliacao3.visitor.PlaylistVisitor;
import br.edu.ifba.inf011.model.playlist.PlaylistItem;

/** ConcreteElement do Visitor. */
public class Episodio implements PlaylistItem {

    private final String titulo;
    private final Double preco;
    private final Timeline timeline;
    private final Integer numero;

    public Episodio(String titulo, Double preco, Integer numero, Timeline timeline) {
        this.titulo = titulo;
        this.preco = preco;
        this.timeline = timeline;
        this.numero = numero;
    }

    public Double getPreco() {
        return this.preco;
    }

    public Integer getDuracao() {
        return this.timeline.getDurationInSeconds();
    }

    public String getTitulo() {
        return this.titulo;
    }

    public Integer getNumero() {
        return this.numero;
    }

    @Override
    public void accept(PlaylistVisitor visitor) {
        visitor.visit(this);
    }
}
