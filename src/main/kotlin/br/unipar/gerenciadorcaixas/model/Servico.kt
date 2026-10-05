package br.unipar.gerenciadorcaixas.model
import jakarta.persistence.Entity
import jakarta.persistence.Table
// Representa um servico oferecido pela loja, como manutencao ou instalacao.
// Bate com a tabela SERVICO do banco de dados.

@Entity
@Table(name="servicos")
data class Servico(
    val id: Long = 0,
    val nome: String,
    val descricao: String,
    val preco: Double
)