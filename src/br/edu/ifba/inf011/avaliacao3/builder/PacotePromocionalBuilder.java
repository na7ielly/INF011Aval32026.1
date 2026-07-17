package br.edu.ifba.inf011.avaliacao3.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.edu.ifba.inf011.avaliacao3.composite.ConteudoComponent;
import br.edu.ifba.inf011.model.comercial.Pacote;

public class PacotePromocionalBuilder implements PacoteBuilder {
    private String titulo;
    private Double descontoPercentual;
    private List<ConteudoComponent> conteudos;

    public PacotePromocionalBuilder() {
        this.reset();
    }

    @Override
    public PacoteBuilder reset() {
        this.titulo = null;
        this.descontoPercentual = 0.0;
        this.conteudos = new ArrayList<>();
        return this;
    }

    @Override
    public PacoteBuilder comTitulo(String titulo) {
        this.titulo = Objects.requireNonNull(titulo, "O título do pacote é obrigatório.").trim();
        return this;
    }

    @Override
    public PacoteBuilder comDesconto(Double percentual) {
        Objects.requireNonNull(percentual, "O desconto é obrigatório.");
        if (percentual < 0.0 || percentual > 1.0) {
            throw new IllegalArgumentException("O desconto deve estar entre 0 e 1.");
        }
        this.descontoPercentual = percentual;
        return this;
    }

    @Override
    public PacoteBuilder adicionarConteudo(ConteudoComponent conteudo) {
        this.conteudos.add(Objects.requireNonNull(conteudo, "O conteúdo não pode ser nulo."));
        return this;
    }

    @Override
    public Pacote build() {
        if (this.titulo == null || this.titulo.isBlank()) {
            throw new IllegalStateException("Informe o título antes de construir o pacote.");
        }
        if (this.conteudos.isEmpty()) {
            throw new IllegalStateException("Um pacote deve possuir ao menos um conteúdo.");
        }
        return new Pacote(this.titulo, this.descontoPercentual, this.conteudos);
    }
}
