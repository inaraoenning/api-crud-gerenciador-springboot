package br.unipar.gerenciadorcaixas.modulos.cliente

import br.unipar.gerenciadorcaixas.modulos.caixaDaAgua.CaixaDaguaRepository
import org.springframework.stereotype.Service

@Service
class ClienteService(
    // Injeção de dependência direto no construtor primário (sem precisar de @Autowired)
    private val cliente: ClienteRepository
) {


}

