# Nome Diagrama de Sequência

## Classe1 - nomeFuncao(nomeVariavel {tipoVariavel}) : tipoRetorno > Classe2
< resposta -

## Exibir Detalhes do Restaurante (Cliente)

: Cliente - exibirDetalhesRestaurante(nomeRestaurante {string}) : void > ControladorRestaurante < exibe dados do restaurante ao usuário -

: ControladorRestaurante - restaurante = buscarPorNome(nomeRestaurante {string}) : Restaurante > CatalogoRestaurante < retorna o restaurante selecionado -

: ControladorRestaurante - getDetalhes() : ArrayList\<string> > restaurante : Restaurante < retorna os dados do restaurante -













## Adicionar Item ao Cardapio

: Restaurante - exibirDetalhesRestaurante(nomeRestaurante {string}) : void > ControladorRestaurante < exibe dados do restaurante ao usuário -

: ControladorRestaurante - restaurante = buscarPorNome(nomeRestaurante {string}) : Restaurante > CatalogoRestaurante < retorna o restaurante selecionado -

: ControladorRestaurante - getDetalhes() : ArrayList\<string> > restaurante : Restaurante < retorna os dados do restaurante -