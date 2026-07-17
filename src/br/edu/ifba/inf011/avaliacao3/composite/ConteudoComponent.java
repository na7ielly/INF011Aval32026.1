package br.edu.ifba.inf011.avaliacao3.composite;

import br.edu.ifba.inf011.model.playlist.PlaylistItem;

/** Component do Composite e Element do Visitor. */
public interface ConteudoComponent extends PlaylistItem {

    Double getPreco();

    Integer getDuracao();
}
