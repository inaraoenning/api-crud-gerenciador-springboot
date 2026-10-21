package br.unipar.gerenciadorcaixas.modulos.caixaDaAgua

import br.unipar.gerenciadorcaixas.enums.CorCaixa
import br.unipar.gerenciadorcaixas.enums.Formato
import br.unipar.gerenciadorcaixas.enums.MarcaCaixa
import br.unipar.gerenciadorcaixas.enums.Material

class CaixaDaguaDTO {

    data class CaixaDaguaRequest(
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
        val fornecedorId: Long,
    )
}
