package br.unipar.gerenciadorcaixas.modulos.caixaDaAgua

import br.unipar.gerenciadorcaixas.enums.Material
import br.unipar.gerenciadorcaixas.modulos.fornecedor.FornecedorRepository
import br.unipar.gerenciadorcaixas.model.CaixaDagua
import jakarta.transaction.TransactionScoped
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CaixaDaguaService(
    private val caixaDAguaRepository: CaixaDaguaRepository,
    private val fornecedorRepository: FornecedorRepository,
) {

    fun salvar(request: CaixaDaguaDTO.CaixaDaguaRequest): CaixaDagua {
        val caixa = CaixaDagua(
            marca = request.marca,
            modelo = request.modelo,
            capacidadeLitros = request.capacidadeLitros,
            largura = request.largura,
            altura = request.altura,
            profundidade = request.profundidade,
            cor = request.cor,
            material = request.material,
            formato = request.formato,
            preco = request.preco,
            quantidade = request.quantidade,
            fornecedor = buscarFornecedor(request.fornecedorId),
        )
        return caixaDAguaRepository.save(caixa) // id = null → INSERT
    }

    fun listarTodas(): List<CaixaDagua> = caixaDAguaRepository.findAll()

    fun buscarPorId(id: Long): CaixaDagua? =
        caixaDAguaRepository.findById(id).orElse(null)

    fun buscarPorMaterial(material: Material): List<CaixaDagua> =
        caixaDAguaRepository.findByMaterial(material)

    fun atualizar(id: Long, request: CaixaDaguaDTO.CaixaDaguaRequest): CaixaDagua? {
        if (!caixaDAguaRepository.existsById(id)) return null
        return caixaDAguaRepository.save(
            CaixaDagua(
                id = id, // força UPDATE (merge)
                marca = request.marca,
                // ... mesmos campos do salvar ...
                fornecedor = buscarFornecedor(request.fornecedorId),
            )
        )
    }

    fun deletar(id: Long): Boolean {
        if (!caixaDAguaRepository.existsById(id)) return false
        caixaDAguaRepository.deleteById(id)
        return true
    }

    private fun buscarFornecedor(id: Long?) =
        id?.let { fornecedorRepository.findById(it).orElse(null) }

    @Transactional
    fun inativar(id: Long) {
        val caixa = caixaDAguaRepository.findById(id).orElseThrow{
            NoSuchElementException("Produto com ID $id não existe")
        }

        caixa.inativo = false
        caixaDAguaRepository.save(caixa)
    }
}