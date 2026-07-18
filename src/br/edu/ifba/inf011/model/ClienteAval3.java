package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.CinemaTimelineBuilder;
import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;
import br.edu.ifba.inf011.avaliacao1.timeline.builder.TimelineBuilder;
import br.edu.ifba.inf011.avaliacao3.builder.PacoteBuilder;
import br.edu.ifba.inf011.avaliacao3.builder.PacotePromocionalBuilder;
import br.edu.ifba.inf011.avaliacao3.visitor.LarguraBandaVisitor;
import br.edu.ifba.inf011.avaliacao3.visitor.RelatorioNomesVisitor;
import br.edu.ifba.inf011.avaliacao3.visitor.XmlPlaylistVisitor;
import br.edu.ifba.inf011.model.comercial.Episodio;
import br.edu.ifba.inf011.model.comercial.Filme;
import br.edu.ifba.inf011.model.comercial.Pacote;
import br.edu.ifba.inf011.model.comercial.Serie;
import br.edu.ifba.inf011.model.playlist.MP3;
import br.edu.ifba.inf011.model.playlist.Playlist;
import br.edu.ifba.inf011.model.playlist.Video;

public class ClienteAval3 {

	public void run() {
		
		TimelineBuilder timelineBuilder = new CinemaTimelineBuilder();
	    Timeline cinemaTimeline = timelineBuilder
                .reset()
                .addClassAdapterVideo("MainShot_4K.mov")
                .build();
        Timeline episodioTimeline = timelineBuilder
                .reset()
                .addClassAdapterVideo("EpisodeShot_4K.mov")
                .build();

        PacoteBuilder pacoteBuilder = new PacotePromocionalBuilder();

        Pacote matrixPacote = pacoteBuilder
                .reset()
                .comTitulo("Trilogia Matrix")
                .adicionarConteudo(new Filme("Matrix", 20.0, cinemaTimeline))
                .adicionarConteudo(new Filme("Matrix Reloaded", 25.0, cinemaTimeline))
                .adicionarConteudo(new Filme("Matrix Revolutions", 15.0, cinemaTimeline))
                .build();

	    Serie blackMirrorSerie = new Serie("Black Mirror", 1)
                .adicionarEpisodio(new Episodio("The National Anthem", 10.0, 1, episodioTimeline))
                .adicionarEpisodio(new Episodio("Fifteen Million Merits", 10.0, 2, episodioTimeline))
                .adicionarEpisodio(new Episodio("The Entire History of You", 10.0, 3, episodioTimeline));

        double blackFridayDesconto = 0.1;
	    Pacote sciFiPacote = pacoteBuilder
                .reset()
                .comTitulo("SciFi")
                .comDesconto(blackFridayDesconto)
                .adicionarConteudo(matrixPacote)
                .adicionarConteudo(blackMirrorSerie)
                .adicionarConteudo(new Filme("2001: A Space Odyssey", 18.0, cinemaTimeline))
                .build();

		System.out.println("Preço da Super Coleção: " + sciFiPacote.getPreco());
		System.out.println("Duração da Super Coleção: " + sciFiPacote.getDuracao());
        
        Playlist playlist = new Playlist();
        playlist.addItem(sciFiPacote);
        playlist.addItem(new MP3("Son Of A Gun", 8.5));
        playlist.addItem(new Video(
                "Making of Matrix",
                42.0,
                "https://stream.local/making-of-matrix"));

        LarguraBandaVisitor larguraBandaVisitor = new LarguraBandaVisitor();
        playlist.accept(larguraBandaVisitor);
        double largura = larguraBandaVisitor.getBandaTotal();
        System.out.println("Consumo de Largura de Banda: " + largura);

        RelatorioNomesVisitor relatorioNomesVisitor = new RelatorioNomesVisitor();
        playlist.accept(relatorioNomesVisitor);
        String relatorioNomes = relatorioNomesVisitor.getRelatorio();
        System.out.println("Relatório com o Nome dos Elementos da Playlist:\n" + relatorioNomes);

        XmlPlaylistVisitor xmlPlaylistVisitor = new XmlPlaylistVisitor();
        playlist.accept(xmlPlaylistVisitor);
        String xml = xmlPlaylistVisitor.getXml();
        System.out.println("Exportador para XML:\n" + xml);
    }

    public static void main(String[] args) {
        new ClienteAval3().run();
    }
}
