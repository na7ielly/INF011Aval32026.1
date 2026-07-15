# IFBAINF011Aval32026.1

## Padrões escolhidos

### Builder

### Composite

#### 1. Motivação
Conforme enunciado: "O carrinho de compras da aplicação precisa calcular o preço total e a duração dos produtos de forma
elegante, extensível e **transparente**, tratando filmes avulsos e pacotes complexos (aninhados)
**exatamente da mesma maneira**". O Composite permite atingir isso ao tratar pacotes e filmes da mesma forma via uma 
interface em comum.

#### 2. Participantes
- 2.1. `ConteudoComponent`: Exerce o papel do Component no Composite. Ele define a interface em comum entre o leaf e o
composite
- 2.2. `Filme`: Exerce o papel do Leaf no Composite. Trata-se da classe que armazena as informações finais; ou seja, que
de fato retorna o preço e a duração que são somados no `Pacote`
- 2.3. `Pacote`: É o Composite. Se utiliza da mesma interface que o `Filme`, mas retorna o preço e a duração conforme soma 
dos valores dos conteúdos internos. Dessa forma, pode armazenar tanto filmes quanto outros pacotes sem necessidade de lógica 
complexa.

#### 3. Observações
- A exportação XML foi concentrada no `XmlPlaylistVisitor`, evitando essa responsabilidade nas classes do domínio.
- A adição e remoção de elementos poderia ser definida no Composite, mas entendemos que se trata de operações da criação 
do pacote e, portanto, delegadas ao builder. Adicioná-los ao Composite permitiria a edição de pacotes já fechados

### Visitor
### Visitor

Na Questão II foi aplicado o padrão Visitor porque o sistema precisa realizar diferentes operações sobre os elementos da playlist, como calcular a largura de banda, gerar um relatório de nomes e exportar os dados para XML, sem inserir essas responsabilidades nas classes de domínio. A interface `PlaylistVisitor` assume o papel de Visitor. As classes `LarguraBandaVisitor`, `RelatorioNomesVisitor` e `XmlPlaylistVisitor` são os ConcreteVisitors. A interface `PlaylistItem` representa o Element. As classes `MP3`, `VideoClipe`, `Filme`, `Episodio`, `Serie` e `Pacote` são os ConcreteElements. A classe `Playlist` representa a ObjectStructure e a classe `ClienteAval3` representa o Client.