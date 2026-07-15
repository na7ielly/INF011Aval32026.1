package br.edu.ifba.inf011.avaliacao3.builder;

import br.edu.ifba.inf011.avaliacao3.composite.ConteudoComercial;
import br.edu.ifba.inf011.model.comercial.Pacote;

public interface PacoteBuilder {

    PacoteBuilder reset();
    PacoteBuilder comTitulo(String titulo);
    PacoteBuilder comDesconto(Double percentual);
    PacoteBuilder adicionarConteudo(ConteudoComercial conteudo);
    Pacote build();
}
