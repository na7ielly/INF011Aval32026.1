package br.edu.ifba.inf011.model.comercial;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;

public class Filme {
	private String titulo;
    private Double preco;
    private Timeline timeline;

	public Filme(String titulo, Double preco, Timeline timeline) {
    	this.titulo = titulo;
        this.preco = preco;
        this.timeline = timeline;
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


	public String toXML() {
		String xml = "<filme titulo=\"" + this.getTitulo() + "\"/>\n";
		return xml;
	}   	
}