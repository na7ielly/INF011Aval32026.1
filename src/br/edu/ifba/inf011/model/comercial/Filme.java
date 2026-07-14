package br.edu.ifba.inf011.model.comercial;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;
import br.edu.ifba.inf011.avaliacao3.composite.ConteudoComponent;

public class Filme implements ConteudoComponent {
	private String titulo;
    private Double preco;
    private Timeline timeline;

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
	public String toXML() {
		return "<filme titulo=\"" + this.getTitulo() + "\"/>\n";
	}
}