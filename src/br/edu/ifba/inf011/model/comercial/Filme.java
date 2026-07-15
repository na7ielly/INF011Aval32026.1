package br.edu.ifba.inf011.model.comercial;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;
import br.edu.ifba.inf011.avaliacao3.composite.ConteudoComponent;
import br.edu.ifba.inf011.avaliacao3.visitor.PlaylistVisitor;

/** Leaf do Composite e ConcreteElement do Visitor. */
public class Filme implements ConteudoComponent {

    private final String titulo;
    private final Double preco;
    private final Timeline timeline;

    public Filme(String titulo, Double preco, Timeline timeline) {
        this.titulo = titulo;
        this.preco = preco;
        this.timeline = timeline;
    }

    @Override
    public Double getPreco() {
        return this.preco;
    }

    @Override
    public Integer getDuracao() {
        return this.timeline.getDurationInSeconds();
    }

    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public void accept(PlaylistVisitor visitor) {
        visitor.visit(this);
    }
}
