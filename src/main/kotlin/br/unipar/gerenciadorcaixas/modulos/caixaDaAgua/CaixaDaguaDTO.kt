package br.unipar.gerenciadorcaixas.modulos.caixaDaAgua

import br.unipar.gerenciadorcaixas.enums.CorCaixa
import br.unipar.gerenciadorcaixas.enums.Formato
import br.unipar.gerenciadorcaixas.enums.MarcaCaixa
import br.unipar.gerenciadorcaixas.enums.Material
import io.swagger.v3.oas.annotations.media.Schema

class CaixaDaguaDTO {

    data class CaixaDaguaRequest(
        @field:Schema(description = "Marca do fabricante", example = "Tigre")
        val marca: MarcaCaixa,
        @field:Schema(description = "Nome do modelo", example = "Calha 1500L")
        val modelo: String,
        @field:Schema(description = "Capacidade em litros", example = "1500")
        val capacidadeLitros: Int,
        @field:Schema(description = "Largura em metros", example = "1.0")
        val largura: Double,
        @field:Schema(description = "Altura em metros", example = "1.2")
        val altura: Double,
        @field:Schema(description = "Profundidade em metros", example = "1.0")
        val profundidade: Double,
        @field:Schema(description = "Cor do produto")
        val cor: CorCaixa,
        @field:Schema(description = "Material de fabricação")
        val material: Material,
        @field:Schema(description = "Formato do reservatório")
        val formato: Formato,
        @field:Schema(description = "Preço unitário", example = "350.00")
        val preco: Double,
        @field:Schema(description = "Quantidade em estoque", example = "10")
        val quantidade: Int,
        @field:Schema(description = "ID de um fornecedor já cadastrado (opcional)", example = "1")
        val fornecedorId: Long? = null,
    )
}