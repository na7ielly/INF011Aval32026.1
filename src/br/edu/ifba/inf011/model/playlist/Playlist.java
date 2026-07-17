package br.edu.ifba.inf011.model.playlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ifba.inf011.avaliacao3.visitor.PlaylistVisitor;

/** ObjectStructure do padrão Visitor. */
public class Playlist {

    private final List<PlaylistItem> items;

    public Playlist() {
        this.items = new ArrayList<PlaylistItem>();
    }

    public void addItem(PlaylistItem item) {
        this.items.add(item);
    }

    public void removeItem(PlaylistItem item) {
        this.items.remove(item);
    }

    public List<PlaylistItem> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public void accept(PlaylistVisitor visitor) {
        visitor.visit(this);
    }
}
