package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.CinemaTimelineBuilder;
import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;
import br.edu.ifba.inf011.avaliacao1.timeline.builder.TimelineBuilder;
import br.edu.ifba.inf011.avaliacao3.visitor.LarguraBandaVisitor;
import br.edu.ifba.inf011.avaliacao3.visitor.RelatorioNomesVisitor;
import br.edu.ifba.inf011.avaliacao3.visitor.XmlPlaylistVisitor;
import br.edu.ifba.inf011.model.comercial.Episodio;
import br.edu.ifba.inf011.model.comercial.Filme;
import br.edu.ifba.inf011.model.comercial.Serie;
import br.edu.ifba.inf011.model.playlist.MP3;
import br.edu.ifba.inf011.model.playlist.Playlist;
import br.edu.ifba.inf011.model.playlist.VideoClipe;

public class ClienteAval3 {

	public void run() {
		
		TimelineBuilder builder = new CinemaTimelineBuilder();
	    Timeline cinemaTimeline = builder.reset().addClassAdapterVideo("MainShot_4K.mov").build();
	    
	    List<Filme> filmes = new ArrayList<Filme>();
	    filmes.add(new Filme("Matrix", 20.0, cinemaTimeline));
	    filmes.add(new Filme("Matrix Reloaded", 25.0, cinemaTimeline));
	    filmes.add(new Filme("Matrix Revolutions", 15.0, cinemaTimeline));

	    Pacote pacote = new Pacote("Trilogia Matrix");

		System.out.println("Preço da Super Coleção: " + pacote.getPreco());
		System.out.println("Duração da Super Coleção: " + pacote.getDuracao());
        
        Playlist playlist = new Playlist();
        playlist.addItem(filme);
        playlist.addItem(serie);
        playlist.addItem(new MP3("Son Of A Gun", 8.5));
        playlist.addItem(new VideoClipe(
                "Making of Matrix",
                42.0,
                "https://stream.local/making-of-matrix"));

        LarguraBandaVisitor larguraBandaVisitor = new LarguraBandaVisitor();
        playlist.accept(larguraBandaVisitor);

        RelatorioNomesVisitor relatorioNomesVisitor = new RelatorioNomesVisitor();
        playlist.accept(relatorioNomesVisitor);

        XmlPlaylistVisitor xmlPlaylistVisitor = new XmlPlaylistVisitor();
        playlist.accept(xmlPlaylistVisitor);

        System.out.printf("Consumo de Largura de Banda: %.2f MB%n",
                larguraBandaVisitor.getTotalMegaBytes());
        System.out.println();
        System.out.println(relatorioNomesVisitor.getRelatorio());
        System.out.println(xmlPlaylistVisitor.getXml());
    }

    public static void main(String[] args) {
        new ClienteAval3().run();
    }
}
