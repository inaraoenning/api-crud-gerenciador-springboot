package br.unipar.gerenciadorcaixas.modulos.fornecedor

import br.unipar.gerenciadorcaixas.model.Fornecedor
import br.unipar.gerenciadorcaixas.model.ItemVenda
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FornecedorRepository: JpaRepository<Fornecedor, Int> {
}