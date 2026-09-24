package br.unipar.gerenciadorcaixas.model

import br.unipar.gerenciadorcaixas.enums.CorCaixa
import br.unipar.gerenciadorcaixas.enums.Formato
import br.unipar.gerenciadorcaixas.enums.MarcaCaixa
import br.unipar.gerenciadorcaixas.enums.Material
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity // Indica para o JPA que essa classe representa uma tabela no DB
data class CaixaDagua(

    @Id // Marca qual atributo é a PK
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Informa que o valor da PK será gerado automaticamente
    val id: Int,
    val marca: MarcaCaixa,
    val modelo: String,
    val capacidadeLitros: Int,
    val largura: Double,
    val altura: Double,
    val profundidade: Double,
    val cor: CorCaixa,
    val material: Material,
    val formato: Formato,
    val preco: Double,
    val quantidade: Int,
    val fornecedorId: Int,
    val nomeFornecedor: String = "",
)