package br.unipar.gerenciadorcaixas.modulos.pessoa

import br.unipar.gerenciadorcaixas.model.CaixaDagua
import br.unipar.gerenciadorcaixas.model.Pessoa
import org.springframework.stereotype.Service

@Service
class PessoaService(

    private val pessoaRepository: PessoaRepository
) {

    // Método Buscar
    fun listarTodas(): List<Pessoa>{
        return pessoaRepository.findAll()
    }

    // Método Buscar por ID e Nome
    fun buscarIdNome(id: Long, nome: String): List<Pessoa> {
        return pessoaRepository.findByIdAndNomeAndId(id, nome)
    }

    // Método para salvar uma nova pessoa
    fun adicionar(pessoa: Pessoa): Pessoa = pessoaRepository.save(pessoa)

    // Método Deletar

    // Método Atualizar nome
}
