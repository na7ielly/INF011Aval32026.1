package br.edu.ifba.inf011.model.playlist;

import br.edu.ifba.inf011.avaliacao3.visitor.PlaylistVisitor;

/** ConcreteElement que representa um videoclipe enviado pelo usuário. */
public class VideoClipe implements PlaylistItem {

    private final String nome;
    private final double tamanhoMegaBytes;
    private final String link;

    public VideoClipe(String nome, double tamanhoMegaBytes, String link) {
        this.nome = nome;
        this.tamanhoMegaBytes = tamanhoMegaBytes;
        this.link = link;
    }

    public String getNome() {
        return this.nome;
    }

    public double getTamanhoMegaBytes() {
        return this.tamanhoMegaBytes;
    }

    public String getLink() {
        return this.link;
    }

    @Override
    public void accept(PlaylistVisitor visitor) {
        visitor.visit(this);
    }
}
