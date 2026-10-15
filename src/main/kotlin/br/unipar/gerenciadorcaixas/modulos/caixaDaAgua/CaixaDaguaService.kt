package br.unipar.gerenciadorcaixas.modulos.caixaDaAgua

import br.unipar.gerenciadorcaixas.enums.Material
import br.unipar.gerenciadorcaixas.model.CaixaDagua
import kotlin.Long
import org.springframework.stereotype.Service

@Service // Marca a classe como um componente de serviço gerenciado pelo Spring
class CaixaDaguaService(
    // Injeção de dependência direto no construtor primário (sem precisar de @Autowired)
    private val caixaDAguaRepository: CaixaDaguaRepository
) {

    // Método para salvar um novo registro
    fun salvar(caixa: CaixaDagua): CaixaDagua = caixaDAguaRepository.save(caixa)

    // Método para buscar todas as caixas cadastradas
    fun listarTodas(): List<CaixaDagua> {
        return caixaDAguaRepository.findAll()
    }

    // Método para buscar por ID (retornando nulo se não encontrar, aproveitando o null-safety do
    // Kotlin)
    fun buscarPorId(id: Long): CaixaDagua? {
        return caixaDAguaRepository.findById(id).orElse(null)
    }

    // Método usando a query customizada que criamos no Repository
    fun buscarPorMaterial(material: Material): List<CaixaDagua> {
        return caixaDAguaRepository.findByMaterial(material)
    }

    // Método atualizar
    fun atualizar(id: Long, dados: CaixaDagua): CaixaDagua? {
        if (!caixaDAguaRepository.existsById(id)) return null
        // copy() vem de graça pq caixaDagua é data class
        // forçamos id = id para o JPA fazer UPDATE (merge) ao invés de INSERT.
        return caixaDAguaRepository.save(dados.copy(id = id))
    }

    // Método Deletar
    fun deletar(id: Long): Boolean {
        if (!caixaDAguaRepository.existsById(id)) return false
        caixaDAguaRepository.deleteById(id)
        return true
    }
}
