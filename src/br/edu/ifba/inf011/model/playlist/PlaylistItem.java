package br.edu.ifba.inf011.model.playlist;

import br.edu.ifba.inf011.avaliacao3.visitor.PlaylistVisitor;

/** Element do padrão Visitor. */
public interface PlaylistItem {

    void accept(PlaylistVisitor visitor);
}
