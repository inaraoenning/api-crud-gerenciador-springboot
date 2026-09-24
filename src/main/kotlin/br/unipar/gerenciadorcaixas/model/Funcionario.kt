package br.unipar.gerenciadorcaixas.model

import br.unipar.gerenciadorcaixas.enums.Setor
import br.unipar.gerenciadorcaixas.enums.TipoPessoa
import jakarta.persistence.Entity
import java.math.BigDecimal

// Funcionario herda de Pessoa e adiciona salario e setor.
// Heranca eh usada porque funcionario, cliente e fornecedor compartilham os mesmos dados basicos.

@Entity
class Funcionario(
    idFuncionario: Int,
    nomeFuncionario: String,
    documentoFuncionario: String,
    telefoneFuncionario: String,
    val salario: BigDecimal,
    val setor: Setor,
) :
    Pessoa(
        id = idFuncionario,
        nome = nomeFuncionario,
        documento = documentoFuncionario,
        telefone = telefoneFuncionario,
        tipo = TipoPessoa.FUNCIONARIO,
    )