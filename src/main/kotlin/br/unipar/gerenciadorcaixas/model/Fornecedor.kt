package br.unipar.gerenciadorcaixas.model

import br.unipar.gerenciadorcaixas.enums.MarcaCaixa
import br.unipar.gerenciadorcaixas.enums.TipoPessoa
import jakarta.persistence.Entity
import jakarta.persistence.Table

// Fornecedor herda de Pessoa e adiciona razao social e a marca que ele fornece.
// Heranca permite tratar funcionario, cliente e fornecedor como Pessoa quando necessario.
// Os campos herdados (id, nome, documento, telefone) vem da classe mae — declarar 'val'
// aqui criaria colunas duplicadas na tabela.

@Entity
class Fornecedor(
    val razaoFornecedor: String = "",
    val marca: MarcaCaixa = MarcaCaixa.Tigre,
    idFornecedor: Long = 0,
    nomeFornecedor: String = "",
    documentoFornecedor: String = "",
    telefoneFornecedor: String = "",
) :
    Pessoa(
        id = idFornecedor,
        nome = nomeFornecedor,
        documento = documentoFornecedor,
        telefone = telefoneFornecedor,
        tipo = TipoPessoa.FORNECEDOR,
    )
