package br.edu.ifba.inf011.model.comercial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ifba.inf011.avaliacao3.composite.ConteudoComponent;
import br.edu.ifba.inf011.avaliacao3.visitor.PlaylistVisitor;

/** Composite do padrão Composite e ConcreteElement do Visitor. */
public class Pacote implements ConteudoComponent {

    protected String titulo;
    protected Double desconto;
    protected List<ConteudoComponent> conteudos;

    public Pacote(String titulo) {
        this.titulo = titulo;
        this.conteudos = new ArrayList<ConteudoComponent>();
    }

    public Pacote(String titulo, Double desconto, List<ConteudoComponent> conteudos) {
        this.titulo = titulo;
        this.desconto = desconto;
        this.conteudos = conteudos;
    }

    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public Double getPreco() {
        double soma = this.conteudos.stream().mapToDouble(ConteudoComponent::getPreco).sum();
        return soma * (1 - desconto);
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
