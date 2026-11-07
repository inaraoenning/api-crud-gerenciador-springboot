package br.unipar.gerenciadorcaixas.model

import br.unipar.gerenciadorcaixas.enums.TipoPessoa
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

// Classe base (superclasse) para todas as pessoas do sistema.
// Usamos 'open' para permitir que Funcionario, Cliente e Fornecedor herdem dela.
// A heranca evita repetir campos comuns (id, nome, documento, telefone) em cada classe filha.

@Entity
@Table(name="pessoa")
open class Pessoa(
    @Id @GeneratedValue(GenerationType.SEQUENCE)
    val id: Long = 0,
    var nome: String = "",
    var documento: String,
    var telefone: String,
    var tipo: TipoPessoa,
    var ativo: Boolean = true,
)