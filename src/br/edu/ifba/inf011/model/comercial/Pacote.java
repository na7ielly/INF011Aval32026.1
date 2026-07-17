package br.edu.ifba.inf011.model.comercial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ifba.inf011.avaliacao3.composite.ConteudoComponent;
import br.edu.ifba.inf011.avaliacao3.visitor.PlaylistVisitor;

/** Composite do padrão Composite e ConcreteElement do Visitor. */
public class Pacote implements ConteudoComponent {

    protected String titulo;
    protected List<ConteudoComponent> conteudos;

    public Pacote(String titulo) {
        this.titulo = titulo;
        this.conteudos = new ArrayList<ConteudoComponent>();
    }

    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public Double getPreco() {
        double soma = this.conteudos.stream().mapToDouble(ConteudoComponent::getPreco).sum();
        return soma * 0.9;
    }

    @Override
    public Integer getDuracao() {
        return this.conteudos.stream().mapToInt(ConteudoComponent::getDuracao).sum();
    }

    public List<ConteudoComponent> getConteudos() {
        return Collections.unmodifiableList(this.conteudos);
    }

    @Override
    public void accept(PlaylistVisitor visitor) {
        visitor.visit(this);
    }
}
