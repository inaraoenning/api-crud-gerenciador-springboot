package br.unipar.gerenciadorcaixas.modulos.caixaDaAgua
import br.unipar.gerenciadorcaixas.model.CaixaDagua
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CaixaDaguaRepository: JpaRepository<CaixaDagua, Int> {
}