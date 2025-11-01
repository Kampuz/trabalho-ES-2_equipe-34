# Nome Diagrama de Sequência

Classe1 - nomeFuncao(nomeVariavel {tipoVariavel}) : tipoRetorno > Classe2 < resposta -

## Exibir Detalhes do Restaurante (Cliente)

: Cliente - exibirDetalhesRestaurante(nomeRestaurante {string}) : ArrayList\<string> > ControladorRestaurante < exibe dados do restaurante ao usuário -

: ControladorRestaurante - restaurante = buscarPorNome(nomeRestaurante {string}) : Restaurante > CatalogoRestaurante < retorna o restaurante selecionado -

: ControladorRestaurante - getDetalhes() : ArrayList\<string> > restaurante : Restaurante < retorna os dados do restaurante -

## Exibir Histórico de Pedidos(Cliente)

: Cliente - listarHistoricoPedidos("id" {string}) : ArrayList\<string> > ControladorPedido < exibe pedidos entregues -

: ControladorPedido - pedidos = buscarPorUsuarioEStatus("id" {string}, "Entregue") : ArrayList\<Pedido> > CatalogoPedido < retorna os pedidos entregues -

for pedido in pedidos
: ControladorPedido - detalhes = getDetalhes() : ArrayList\<string> > pedido : Pedido < retorna os dados do pedido -

## Pesquisar Item (Cliente)

: Cliente - pesquisarItem(nomeItem {string}) : ArrayList\<string> > ControladorItem < exibe resultados da pesquisa -

: ControladorItem - buscarPorNome(nomeItem {string}) : ArrayList\<Item> > CatalogoItem < retorna itens correspondentes -

## Pesquisar Restaurante (Cliente)

: Cliente - pesquisarRestaurante(nomeRestaurante {string}) : ArrayList\<string> > ControladorRestaurnate < exibe resultados da pesquisa -

: ControladorRestaurante - buscarPorNome(nomeRestaurante {string}) : ArrayList\<Restaurante> > CatalogoRestaurante < retorna restaurantes correspondentes -

## Realizar Pagamento (Cliente)

: Cliente - realizarPagamento("idPedido" {string}, formaPagamento {string}) : ArrayList\<string> > ControladorPedido < exibe resulatado do pagamento -

alt pagamento aprovado

: ControladorPagamento - atualizarStatus("pago") : boolean > Pedido < confirmação  de pagamento-
ArrayList = "Pagamento concluído"

alt pagamento rejeitado
ArrayList = "Pagamento recusado"

## Realizar Pedido (Cliente)

: Cliente - pesquisarRestaurante("id" {string}) : ArrayList\<string> > ControladorPedido < exibe resultados da pesquisa ao usuário -

alt status = "pago"

alt status != "Pago"
: ControladorRestaurante - buscarPorNome(nomeItem {string}) : ArrayList\<Restaurante> > CatalogoRestaurante < retorna todos os restaurantes que possuem o nome -

## Remover Item do Pedido (Cliente)

: Cliente - removerItem("idItem" {string}) : void > ControladorPedido < exibe resultados da pesquisa ao usuário -

: ControladorPedido - removerItem("idItem" {string}) : void > Pedido < remove o item do pedido -
: Pedido - atualizarTotal() : void > Pedido < atualiza o total -














## Funções do Restaurante:

## Adicionar Item ao Cardapio (Restaurante)

: ControladorPrincipal - adicionarItem(nome {string}, descricao {string}, valor {int}, ingredientes {Arraylist\<string>}, adicionaveis {ArrayList\<string>}) : void > ControladorRestaurante

: ControladorRestaurante - adicionarItem(nome {string}, descricao {string}, valor {int}, ingredientes {Arraylist\<string>}, adicionaveis {ArrayList\<string>}) : void > ControladorCardapio

: ControladorCardapio - item = buscaPorNome(nome {string}) > Cardapio : Item \
se já existir item \
< retorna erro \
 se não existir cria item e depois \
: ControladorCardapio - adicionarItem(novoItem\<Item>) : void > Cardapio

## Remover Item do Cardápio (Restaurante)

: ControladorPrincipal - removerItem(nome {string}) : void > ControladorRestaurante

: ControladorRestaurante - removerItem(nome {string}) : void > ControladorCardapio

: ControladorCardapio - item = buscaPorNome(nome {string}) > Cardapio : Item \
se não existir item \
< retorna erro \
 se existir item \
: ControladorCardapio - removerItem(item\<Item>) : void > Cardapio

## Atualizar Item do Cardápio (Restaurante)

: ControladorPrincipal - atualizarItem(nomeAntigo {string}, nomeNovo {string}, descricao {string}, valor {int}, ingredientes {Arraylist\<string>}, adicionaveis {ArrayList\<string>}) : void > ControladorRestaurante

: ControladorRestaurante - atualizarItem(nomeAntigo {string}, nomeNovo {string}, descricao {string}, valor {int}, ingredientes {Arraylist\<string>}, adicionaveis {ArrayList\<string>}) : void > ControladorCardapio

: ControladorCardapio - item = buscaPorNome(nomeAntigo {string}) > Cardapio : Item \
se já não existir item \
< retorna erro \
 se existir item \
: ControladorCardapio - atualizarItem(item\<Item>, nomeNovo {string}, descricao {string}, valor {int}, ingredientes {Arraylist\<string>}, adicionaveis {ArrayList\<string>}) : void > Cardapio

## Alterar Status do Pedido (Restaurante) ***

: ControladorPrincipal - atualizarStatusPedido(pedido {Pedido}, novoStatus {string}) : void > ControladorPedido\
: ControladorPedido - atualizarStatus(novoStatus {string}) : void > Pedido

## Exibir Histórico de Pedidos (Restaurante)

: ControladorPrincipal - exibirHistoricoPedidos(nomeRestaurante {string}) : void > ControladorPedido

: ControladorPedido - exibirHistoricoPedidos(nomeRestaurante {string}) : void > CatalogoPedido

: CatalogoPedidos -> -> - return o historico de pedidos > Restaurante

## Receber Pedidos (Restaurante)

: ControladorPrincipal - receberPedido() : ArrayList\<string> > ControladorPedido

: ControladorPedido - receberPedidos(restaurante {Restaurante}) : ArrayList\<string> > CatalogoPedido

: CatalogoPedido - buscarPedidosDoRestaurante(restaurante {Restaurante}) : ArrayList\<Pedido> > -> -> ControladorGeral

alt: Se aceitar o pedido

: ControladorPrincipal - aceitarPedido(pedido {Pedido}) : void > ControladorPedido

: ControladorPedido - aceitarPedido(pedido {Pedido}) : void > CatalogoPedido

: CatalogoPedido - atualizarPedido(pedido {Pedido}) : void > return pedido aceito

alt: Se recusar o pedido

: ControladorPrincipal - recusarPedido(pedido {Pedido}) : void > ControladorPedido

: ControladorPedido - recusarPedido(pedido {Pedido}) : void > CatalogoPedido

: CatalogoPedido - atualizarPedido(pedido {Pedido}) : void > return pedido recusado
