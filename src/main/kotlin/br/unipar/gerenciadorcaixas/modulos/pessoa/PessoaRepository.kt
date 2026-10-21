package br.unipar.gerenciadorcaixas.modulos.pessoa
import br.unipar.gerenciadorcaixas.model.CaixaDagua
import br.unipar.gerenciadorcaixas.model.Pessoa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PessoaRepository: JpaRepository<Pessoa, Long> {

    // também pode criar queries customizadas apenas declarando a assinatura do método:
    fun findByIdAndNome(id: Long, nome: String): List<Pessoa>
}