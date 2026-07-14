package br.edu.ifba.inf011.model.comercial;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifba.inf011.avaliacao3.composite.ConteudoComponent;
import br.edu.ifba.inf011.model.playlist.PlaylistItem;

public class Pacote implements PlaylistItem, ConteudoComponent {

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
	        return  this.conteudos.stream().mapToInt(ConteudoComponent::getDuracao).sum();
	    }

		@Override
	    public String toXML() {
			String filmesXML = this.conteudos.stream()
                    .map(ConteudoComponent::toXML)
                    .collect(Collectors.joining());
			return "<pacote titulo=\"" + this.getTitulo() + "\">\n" 
				+ filmesXML 
				+ "</pacote>\n";
		}

		public Double getBandwidth(Double bandPerSecond) {
			return this.getDuracao() * bandPerSecond;
		}
	}