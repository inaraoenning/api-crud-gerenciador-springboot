package br.unipar.gerenciadorcaixas.model

import br.unipar.gerenciadorcaixas.enums.TipoMovimentacao
import jakarta.persistence.Entity
import java.time.LocalDateTime
import jakarta.persistence.Table

// Representa um item dentro de uma venda.
// Pode ser uma caixa d'agua (produto) OU um servico, nunca os dois ao mesmo tempo.
// O campo caixaDaguaId ou servicoId fica nulo dependendo do tipo do item.

@Entity
@Table(name="movimentacao_financeira")
// Representa uma entrada ou saida de dinheiro do caixa.
// Bate com a tabela MOVIMENTACAO_FINANCEIRA do banco.
data class MovimentacaoFinanceira(
    val id: Long = 0,
    val valor: Double,
    val pagador: String,
    val recebedor: String,
    val dataHora: LocalDateTime = LocalDateTime.now(),
    val motivo: String,
    val responsavel: String,
    val tipo: TipoMovimentacao
)