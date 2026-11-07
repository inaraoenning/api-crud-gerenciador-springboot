package br.unipar.gerenciadorcaixas.modulos.caixaDaAgua

import br.unipar.gerenciadorcaixas.enums.Material
import br.unipar.gerenciadorcaixas.model.CaixaDagua
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
@RestController
@RequestMapping("/api/caixas-dagua")
@Tag(name = "Caixas d'água", description = "CRUD de caixas d'água")
class CaixaDaguaController(
    private val service: CaixaDaguaService
) {

    @GetMapping
    @Operation(summary = "Listar todas as caixas")
    fun listar(@RequestParam(name="mostrarInativas", defaultValue = "false")
               mostrarInativas: Boolean):  ResponseEntity<List<CaixaDagua>>{
        val lista = service.listarTodas(mostrarInativas)
        return ResponseEntity.ok(lista)
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar caixa por ID")
    fun buscar(@PathVariable id: Long): ResponseEntity<CaixaDagua> =
        service.buscarPorId(id)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @GetMapping("/material/{material}")
    @Operation(summary = "Buscar caixas por material")
    fun buscarPorMaterial(@PathVariable material: Material): List<CaixaDagua> =
        service.buscarPorMaterial(material)

    @PostMapping("/salvar")
    @Operation(summary = "Cadastrar uma caixa d'água")
    fun salvar(@RequestBody request: CaixaDaguaDTO.CaixaDaguaRequest): ResponseEntity<CaixaDagua> =
        ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(request))

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma caixa d'água")
    fun atualizar(
        @PathVariable id: Long,
        @RequestBody request: CaixaDaguaDTO.CaixaDaguaRequest,
    ): ResponseEntity<CaixaDagua> =
        service.atualizar(id, request)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover uma caixa d'água")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> =
        if (service.deletar(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()

    @PatchMapping("/{id}/inativar")
    @Operation(summary = "Inativar uma caixa por ID")
    fun inativar(@PathVariable id:Long): ResponseEntity<Void>{
        service.inativar(id)
        return ResponseEntity.noContent().build()
    }


}
