package br.unipar.gerenciadorcaixas.model

import jakarta.persistence.Entity

// Representa um item dentro de uma venda.
// Pode ser uma caixa d'agua (produto) OU um servico, nunca os dois ao mesmo tempo.
// O campo caixaDaguaId ou servicoId fica nulo dependendo do tipo do item.

@Entity
data class ItemVenda(
    val id: Int = 0,
    val vendaId: Int = 0,
    val caixaDaguaId: Int? = null,
    val servicoId: Int? = null,
    val quantidade: Int,
    val precoUnitario: Double,
    val valorTotal: Double = quantidade * precoUnitario
)