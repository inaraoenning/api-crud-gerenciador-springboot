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
// O campo caixaDagua ou servico fica nulo dependendo do tipo do item.
// Nao e data class: toString()/equals() de data class entrariam em loop infinito
// por causa da referencia bidirecional com Venda.

@Entity
@Table(name = "item_venda")
class ItemVenda(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = 0, // @ManyToOne — muitos itens pertencem a uma venda. É aqui que fica a FK.

    // 'var' porque o service precisa preencher o item com a venda antes de salvar
    @ManyToOne
    @JoinColumn(name = "venda_id")
    var venda: Venda? = null,

    @ManyToOne
    @JoinColumn(name = "caixa_dagua_id")
    val caixaDagua: CaixaDagua? = null,

    @ManyToOne
    @JoinColumn(name = "servico_id")
    val servico: Servico? = null,

    val quantidade: Int = 0,
    val precoUnitario: Double = 0.0,
    val valorTotal: Double = quantidade * precoUnitario
)
