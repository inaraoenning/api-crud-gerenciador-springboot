package br.unipar.gerenciadorcaixas.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.time.LocalDateTime
import jakarta.persistence.Table
// Representa uma venda completa feita na frente de caixa.
// Uma venda tem um funcionario, um cliente, data/hora e uma lista de itens.
// O valor total e calculado somando os itens.

@Entity
@Table(name="venda")
data class Venda(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = 0,
    val funcionarioId: Int,
    val clienteId: Int,
    val dataHora: LocalDateTime = LocalDateTime.now(),
    val valorTotal: Double,

    //@OneToMany — uma venda tem muitos itens.
    @OneToMany(mappedBy = "venda", cascade = [CascadeType.ALL])
    val itens: List<ItemVenda> = emptyList()
)