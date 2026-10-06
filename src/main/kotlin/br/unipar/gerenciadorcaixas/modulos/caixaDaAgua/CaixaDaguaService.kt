package br.unipar.gerenciadorcaixas.modulos.caixaDaAgua

import br.unipar.gerenciadorcaixas.enums.CorCaixa
import br.unipar.gerenciadorcaixas.enums.Formato
import br.unipar.gerenciadorcaixas.enums.MarcaCaixa
import br.unipar.gerenciadorcaixas.enums.Material
import br.unipar.gerenciadorcaixas.model.CaixaDagua
import org.springframework.stereotype.Service
import kotlin.Long

@Service // Marca a classe como um componente de serviço gerenciado pelo Spring
class CaixaDaguaService(
    // Injeção de dependência direto no construtor primário (sem precisar de @Autowired)
    private val caixaDAguaRepository: CaixaDaguaRepository
) {

    // Método para salvar um novo registro
    fun salvar(
          id: Long,
          marca: MarcaCaixa,
          modelo: String,
          capacidadeLitros: Int,
          largura: Double,
          altura: Double,
          profundidade: Double,
          cor: CorCaixa,
          material: Material,
          formato: Formato,
          preco: Double,
          quantidade: Int,
          fornecedorId: Int,
          nomeFornecedor: String = "",): CaixaDagua {
        val novaCaixa = CaixaDagua(
            id,
            marca,
            modelo,
            capacidadeLitros,
            largura,
            altura,
            profundidade,
            cor,
            material,
            formato,
            preco,
            quantidade,
            fornecedorId,
            nomeFornecedor
        )
        return caixaDAguaRepository.save(novaCaixa)
    }

    // Método para buscar todas as caixas cadastradas
    fun listarTodas(): List<CaixaDagua> {
        return caixaDAguaRepository.findAll()
    }

    // Método para buscar por ID (retornando nulo se não encontrar, aproveitando o null-safety do Kotlin)
    fun buscarPorId(id: Long): CaixaDagua? {
        return caixaDAguaRepository.findById(id).orElse(null)
    }

    // Método usando a query customizada que criamos no Repository
    fun buscarPorMaterial(material: String): List<CaixaDagua> {
        return caixaDAguaRepository.findByMaterial(material)
    }
}