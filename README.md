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
- Método `toXML()` adicionado à interface devido ao seu caráter também recursivo
- A adição e remoção de elementos poderia ser definida no Composite, mas entendemos que se trata de operações da criação 
do pacote e, portanto, delegadas ao builder. Adicioná-los ao Composite permitiria a edição de pacotes já fechados

### Visitor