package br.unipar.gerenciadorcaixas.modulos.caixaDaAgua

import br.unipar.gerenciadorcaixas.enums.CorCaixa
import br.unipar.gerenciadorcaixas.enums.MarcaCaixa

class CaixaDaguaDTO {

    data class CaixaDaguaRequest(
        val marca: MarcaCaixa,
        val modelo: String,
        val capacidadeLitros: Int,
        val largura: Int,
        val altura: Int,
        val profundidade: Int,
        val corCaixa: CorCaixa,
        val material: String,
        val formato: String,
        val preco: Double,
        val quantidade: Int,
        val fornecedorId: Int,
        val dataCricacao: String
    )
}