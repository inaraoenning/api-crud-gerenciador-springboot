package br.unipar.gerenciadorcaixas.modulos.pessoa

import br.unipar.gerenciadorcaixas.model.Pessoa
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
@RequestMapping("/api/pessoa")
class PessoaController(val service: PessoaService) {

    @PostMapping
    fun cadastrar(@RequestBody pessoa: Pessoa): ResponseEntity<Pessoa> =
        ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(pessoa))

    @GetMapping
    @Operation(summary = "Listar todas as pessoas")
    fun listar(
        @Parameter(description = "Quando true, inclui também registros inativos na busca")
        @RequestParam(name = "mostrarInativos", defaultValue = "true") mostrarInativos: Boolean
    ): ResponseEntity<List<Pessoa>> {
        return ResponseEntity.ok(service.listarTodas(mostrarInativos))
    }

    @GetMapping("/id/{id}")
    fun buscarPorIdNome(@PathVariable id: Long, nome: String): ResponseEntity<List<Pessoa>> =
        ResponseEntity.ok(service.buscarIdNome(id, nome))

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id:Long, @RequestBody pessoa: Pessoa) : ResponseEntity<Pessoa> =
        ResponseEntity.ok(service.atualizar(id, pessoa))

    @PatchMapping("/{id}/inativar")
    @Operation(summary = "Inativar pessoa por ID")
    fun inativar(@PathVariable id: Long): ResponseEntity<Void> {
        service.inativar(id)
        return ResponseEntity.noContent().build()
    }


}