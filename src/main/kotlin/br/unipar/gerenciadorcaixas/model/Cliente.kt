package br.unipar.gerenciadorcaixas.model

import br.unipar.gerenciadorcaixas.enums.TipoPessoa
import jakarta.persistence.Entity
import jakarta.persistence.Table

// Cliente herda de Pessoa.
// Nao adiciona campos novos, so define o tipo como CLIENTE para o sistema diferenciar.

// A classe Cliente não precisa de @Id e @GeneratedValue porque ela herda
// a chave primária e a estratégia de geração diretamente da classe mãe (Pessoa).
// Os parametros tem valor default para o Jackson conseguir desserializar
// referencias parciais como {"id": 3} dentro de uma Venda.

@Entity
 class Cliente(
    idCliente: Long = 0L,
    nomeCliente: String = "",
    documentoCliente: String = "",
    telefoneCliente: String = "",
): Pessoa(
    id = idCliente,
    nomeCliente, documentoCliente,
    telefoneCliente,
    tipo = TipoPessoa.CLIENTE,)
