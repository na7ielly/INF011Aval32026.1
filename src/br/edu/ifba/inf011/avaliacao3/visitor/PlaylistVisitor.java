package br.edu.ifba.inf011.avaliacao3.visitor;

import br.edu.ifba.inf011.model.comercial.Episodio;
import br.edu.ifba.inf011.model.comercial.Filme;
import br.edu.ifba.inf011.model.comercial.Pacote;
import br.edu.ifba.inf011.model.comercial.Serie;
import br.edu.ifba.inf011.model.playlist.MP3;
import br.edu.ifba.inf011.model.playlist.Playlist;
import br.edu.ifba.inf011.model.playlist.Video;

/** Visitor: declara uma operação para cada ConcreteElement. */
public interface PlaylistVisitor {

    void visit(Playlist playlist);

    void visit(MP3 mp3);

    void visit(Video video);

    void visit(Filme filme);

    void visit(Episodio episodio);

    void visit(Serie serie);

    void visit(Pacote pacote);
}
