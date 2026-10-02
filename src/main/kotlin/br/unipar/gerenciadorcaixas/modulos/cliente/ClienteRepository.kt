package br.unipar.gerenciadorcaixas.modulos.cliente
import br.unipar.gerenciadorcaixas.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository: JpaRepository<Cliente, Int> {
}