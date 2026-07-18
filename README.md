# IFBA INF011 Aval3 2026.1
Equipe: Mateus Matos, Natielly Bomfim, Yuri Mascarenhas

## Padrões escolhidos

### Builder

#### 1. Motivação
Conforme enunciado: "a primeira versão do processo de instanciar esses
pacotes aninhados resultou em **construtores gigantescos, repetitivos e ilegíveis**". O Builder permite resolver 
esse problema ao mover o processo de construção para uma nova classe **builder**, segmentada em etapas.

#### 2. Participantes
- 2.1. `PacoteBuilder`: É a interface `Builder` que define as etapas de construção de um `Pacote`. 
No caso do nosso domínio, as etapas são o título do pacote, o desconto aplicado, e os `ConteudoComponent` presentes nele
  (ver Composite a seguir).
- 2.2. PacotePromocionalBuilder: Trata-se do `ConcreteBuilder` que implementa a interface
- Não foi adicionado o `Director`, pois entende-se que o problema não requer sua utilização

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

#### 1. Motivação
Conforme enunciado: "A cada nova requisição da equipe de dados **é necessário modificar as
classes originais**, o que já gerou a injeção de erros como efeitos colaterais". Nesse caso, as novas operações 
analíticas podem ser entendidas como algoritmos. O padrão Visitor permite desacoplar o algoritmo do objeto, permitindo 
que novas operações possam ser adicionadas em novos visitors, minimizando efeitos colaterais.

#### 2. Participantes
- 2.1. `PlaylistVisitor`: Cumpre o papel de `Visitor`, definindo um método `visit` para cada item de playlist
- 2.2. `PlaylistItem`: Interface `Element`, que permite aos itens concretos aceitarem o PlaylistVisitor
- 2.3. `LarguraBandaVisitor`, `RelatorioNomesVisitor` e `XmlPlaylistVisitor`: `PlaylistVisitor`s concretos
- 2.4. `MP3`, `VideoClipe`, `Episodio`, e implementações de `ConteudoComponent`: `PlaylistItem`s concretos
- `Playlist` serve como uma classe estrutural que agrupa os diversos `PlaylistItem`

---
A classe `ClienteAval3` representa o Client para todos os padrões