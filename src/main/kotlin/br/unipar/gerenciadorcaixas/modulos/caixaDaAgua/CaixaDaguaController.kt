package br.unipar.gerenciadorcaixas.modulos.caixaDaAgua

import br.unipar.gerenciadorcaixas.enums.CorCaixa
import br.unipar.gerenciadorcaixas.enums.Formato
import br.unipar.gerenciadorcaixas.enums.MarcaCaixa
import br.unipar.gerenciadorcaixas.enums.Material
import br.unipar.gerenciadorcaixas.model.CaixaDagua
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/caixas-dagua")
class CaixaDaguaController(
    private val service: CaixaDaguaService // Inj de dependencia no construtor
) {

    @GetMapping // GET /api/caixas-dagua
    fun listar(): List<CaixaDagua> = service.listarTodas()

    @GetMapping("/{id}") // GET /api/caixas-dagua/5
    fun buscar(@PathVariable id: Long): ResponseEntity<CaixaDagua> =
        service.buscarPorId(id)?.let { ResponseEntity.ok(it) } // 200+corpo
        ?: ResponseEntity.notFound().build() // 404

    @PostMapping("/salvar")
    fun salvar(){
        CaixaDagua(
            id = 0,
            marca = MarcaCaixa.Agualimp,
            modelo = "modelo",
            capacidadeLitros = 1000,
            largura = 10.0,
            altura = 1.0,
            profundidade = 5.0,
            cor = CorCaixa.Azul,
            material = Material.FIBRA_DE_VIDRO,
            formato = Formato.Conico,
            preco = 500.00,
            quantidade = 1,
            fornecedorId = 0,
            nomeFornecedor = "Joao da Caixa",
        )
    }


}
