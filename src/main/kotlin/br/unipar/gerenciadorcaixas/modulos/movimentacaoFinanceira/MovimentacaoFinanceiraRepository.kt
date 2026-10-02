package br.unipar.gerenciadorcaixas.modulos.movimentacaoFinanceira
import br.unipar.gerenciadorcaixas.model.MovimentacaoFinanceira
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MovimentacaoFinanceiraRepository: JpaRepository<MovimentacaoFinanceira, Int> {
}