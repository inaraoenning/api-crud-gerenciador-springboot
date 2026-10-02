package br.unipar.gerenciadorcaixas.model

import br.unipar.gerenciadorcaixas.enums.MarcaCaixa
import br.unipar.gerenciadorcaixas.enums.TipoPessoa
import jakarta.persistence.Entity
import jakarta.persistence.Table

// Fornecedor herda de Pessoa e adiciona razao social e a marca que ele fornece.
// Heranca permite tratar funcionario, cliente e fornecedor como Pessoa quando necessario.

@Entity
@Table(name="fornecedor")
data class Fornecedor(
    val idFornecedor: Int,
    val nomeFornecedor: String,
    val razaoFornecedor: String,
    val documentoFornecedor: String,
    val telefoneFornecedor: String,
    val marca: MarcaCaixa,
) :
    Pessoa(
        id = idFornecedor,
        nome = nomeFornecedor,
        documento = documentoFornecedor,
        telefone = telefoneFornecedor,
        tipo = TipoPessoa.FORNECEDOR,
    )