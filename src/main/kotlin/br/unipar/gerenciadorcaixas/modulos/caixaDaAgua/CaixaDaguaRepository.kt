package br.unipar.gerenciadorcaixas.modulos.caixaDaAgua
import br.unipar.gerenciadorcaixas.model.CaixaDagua
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CaixaDaguaRepository: JpaRepository<CaixaDagua, Long> {
    // O Spring Data JPA já implementa métodos prontos como save(), findById(), findAll(), delete(), etc.

    // também pode criar queries customizadas apenas declarando a assinatura do método:
    fun findByMaterial(material: String): List<CaixaDagua>
}