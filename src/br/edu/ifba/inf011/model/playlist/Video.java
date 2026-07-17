package br.edu.ifba.inf011.model.playlist;

/**
 * Mantém compatibilidade com o nome usado no código-base.
 * O tipo adotado no enunciado e no Visitor é VideoClipe.
 */
@Deprecated
public class Video extends VideoClipe {

    public Video(String nome, double tamanhoMegaBytes, String link) {
        super(nome, tamanhoMegaBytes, link);
    }
}
