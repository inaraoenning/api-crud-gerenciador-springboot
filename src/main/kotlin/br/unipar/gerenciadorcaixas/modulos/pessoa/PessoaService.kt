package br.unipar.gerenciadorcaixas.modulos.pessoa

import br.unipar.gerenciadorcaixas.enums.TipoPessoa
import br.unipar.gerenciadorcaixas.model.CaixaDagua
import br.unipar.gerenciadorcaixas.model.Pessoa
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class PessoaService(

    private val pessoaRepository: PessoaRepository
) {
    // Método para cadastrar uma nova pessoa
    fun cadastrar(pessoa: Pessoa): Pessoa = pessoaRepository.save(pessoa)

    // Método Buscar
    fun listarTodas(mostrarinativo: Boolean): List<Pessoa>{
      return if(mostrarinativo){
          pessoaRepository.findAll()
      } else {
          pessoaRepository.findByAtivoTrue()
      }
    }

    // Método Buscar por ID e Nome
    fun buscarIdNome(id: Long, nome: String): List<Pessoa> {
        return pessoaRepository.findByIdAndNome(id, nome)
    }

    // Método Atualizar
    @Transactional
    fun atualizar(id:Long, dados: Pessoa): Pessoa{
        val pessoa = pessoaRepository.findById(id).orElseThrow { NoSuchElementException("Pessoa com ID: $id não encontrar") }
        pessoa.nome = dados.nome
        pessoa.documento = dados.documento
        pessoa.telefone = dados.telefone
        pessoa.tipo = dados.tipo
        return pessoaRepository.save(pessoa)
    }

    // Método Inativar
    @Transactional
    fun inativar(id:Long): String {
        val pessoa = pessoaRepository.findById(id).orElseThrow { NoSuchElementException("Pessoa nao encontrada") }

        pessoa.ativo = false
        pessoaRepository.save(pessoa)
        return "ID:$id inativado com sucesso!"
    }

}
