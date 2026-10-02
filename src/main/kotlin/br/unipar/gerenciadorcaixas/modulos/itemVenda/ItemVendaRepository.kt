package br.unipar.gerenciadorcaixas.modulos.itemVenda

import br.unipar.gerenciadorcaixas.model.ItemVenda
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemVendaRepository: JpaRepository<ItemVenda, Int> {
}