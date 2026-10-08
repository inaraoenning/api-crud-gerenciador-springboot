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
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import kotlin.time.Instant

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
    fun salvar(@RequestBody caixa: CaixaDagua){

        service.salvar(caixa)
    }


}
