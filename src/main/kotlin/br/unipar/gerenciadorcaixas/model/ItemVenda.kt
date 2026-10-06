package br.unipar.gerenciadorcaixas.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

// Representa um item dentro de uma venda.
// Pode ser uma caixa d'agua (produto) OU um servico, nunca os dois ao mesmo tempo.
// O campo caixaDaguaId ou servicoId fica nulo dependendo do tipo do item.

@Entity
@Table(name = "item_venda")
data class ItemVenda(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = 0, // @ManyToOne — muitos itens pertencem a uma venda. É aqui que fica a FK.

    @ManyToOne
    @JoinColumn(name = "venda_id")
    val venda: Venda? = null,

    val caixaDaguaId: Int? = null,
    val servicoId: Int? = null,
    val quantidade: Int,
    val precoUnitario: Double,
    val valorTotal: Double = quantidade * precoUnitario
)