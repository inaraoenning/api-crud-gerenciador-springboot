package br.unipar.gerenciadorcaixas.model

import br.unipar.gerenciadorcaixas.enums.CorCaixa
import br.unipar.gerenciadorcaixas.enums.Formato
import br.unipar.gerenciadorcaixas.enums.MarcaCaixa
import br.unipar.gerenciadorcaixas.enums.Material
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity // Indica para o JPA que essa classe representa uma tabela no DB
@Table(name="caixa_da_agua")
data class CaixaDagua(

    @Id // Marca qual atributo é a PK
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Informa que o valor da PK será gerado automaticamente
    val id: Long? = null,
    val marca: MarcaCaixa = MarcaCaixa.Tigre,
    val modelo: String = "",
    val capacidadeLitros: Int = 0,
    val largura: Double = 0.0,
    val altura: Double = 0.0,
    val profundidade: Double = 0.0,
    val cor: CorCaixa = CorCaixa.Azul,
    val material: Material = Material.POLIETILENO,
    val formato: Formato = Formato.Redondo,
    val preco: Double = 0.0,
    val quantidade: Int = 0,

    // @ManyToOne — muitas caixas podem vir do mesmo fornecedor. É aqui que fica a FK.
    // No JSON basta mandar {"fornecedor": {"id": 1}} para referenciar um fornecedor existente.
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    val fornecedor: Fornecedor? = null,

    @CreationTimestamp // preenchido pelo Hibernate no INSERT
    @Column(updatable = false)
    val dataCriacao: LocalDateTime? = null
)
