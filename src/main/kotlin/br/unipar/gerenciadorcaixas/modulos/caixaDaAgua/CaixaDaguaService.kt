package br.unipar.gerenciadorcaixas.modulos.caixaDaAgua

import br.unipar.gerenciadorcaixas.model.CaixaDagua
import org.springframework.stereotype.Service

@Service // Marca a classe como um componente de serviço gerenciado pelo Spring
class CaixaDaguaService(
    // Injeção de dependência direto no construtor primário (sem precisar de @Autowired)
    private val caixaDAguaRepository: CaixaDaguaRepository
) {

    // Método para salvar um novo registro
    fun salvar(capacidadeLitros: Int, marca: String): CaixaDagua {
        val novaCaixa = CaixaDagua(
            capacidadeLitros = capacidadeLitros,
            marca = marca
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