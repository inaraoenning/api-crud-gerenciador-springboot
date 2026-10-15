package br.unipar.gerenciadorcaixas.modulos.caixaDaAgua

import br.unipar.gerenciadorcaixas.enums.Material
import br.unipar.gerenciadorcaixas.model.CaixaDagua
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @GetMapping("/material/{material}") // buscar por material
    fun buscarPorMaterial(@PathVariable material: Material): List<CaixaDagua> =
        service.buscarPorMaterial(material)

    @PostMapping("/salvar")
    fun salvar(@RequestBody caixa: CaixaDagua): ResponseEntity<CaixaDagua> =
        ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(caixa))

    @PutMapping("/{id}")
    fun atualizar(
        @PathVariable id: Long,
        @RequestBody caixa: CaixaDagua,
    ): ResponseEntity<CaixaDagua> =
        service.atualizar(id, caixa)?.let { ResponseEntity.ok(it) } // 200 + objeto atualizado
        ?: ResponseEntity.notFound().build() // 404

    //  ?.let { } — "se não for nulo, executa este bloco com it = o objeto"
    // ?: — "se tudo à esquerda deu nulo, usa este valor alternativo"

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> =
        if (service.deletar(id)) ResponseEntity.noContent().build() // 204 sem corpo
        else ResponseEntity.notFound().build() // 404
}
