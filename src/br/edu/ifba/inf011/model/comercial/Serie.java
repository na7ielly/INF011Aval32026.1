package br.edu.ifba.inf011.model.comercial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ifba.inf011.avaliacao3.visitor.PlaylistVisitor;
import br.edu.ifba.inf011.model.playlist.PlaylistItem;

/** ConcreteElement composto do Visitor. */
public class Serie implements PlaylistItem {

    private final String titulo;
    private final Integer temporada;
    private final List<Episodio> episodios;

    public Serie(String titulo, Integer temporada) {
        this.titulo = titulo;
        this.temporada = temporada;
        this.episodios = new ArrayList<Episodio>();
    }

    public Serie adicionarEpisodio(Episodio episodio) {
        this.episodios.add(episodio);
        return this;
    }

    public Serie removerEpisodio(Episodio episodio) {
        this.episodios.remove(episodio);
        return this;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public Double getPreco() {
        double soma = this.episodios.stream().mapToDouble(Episodio::getPreco).sum();
        return soma * 0.9;
    }

    public Integer getDuracao() {
        return this.episodios.stream().mapToInt(Episodio::getDuracao).sum();
    }

    public Integer getTemporada() {
        return this.temporada;
    }

    public List<Episodio> getEpisodios() {
        return Collections.unmodifiableList(this.episodios);
    }

    @Override
    public void accept(PlaylistVisitor visitor) {
        visitor.visit(this);
    }
}
