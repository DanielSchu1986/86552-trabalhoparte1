package com.example.AgendamentoFutebol.controller

import com.example.AgendamentoFutebol.model.Partida
import com.example.AgendamentoFutebol.service.PartidaService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/partidas")
class PartidaController(private val partidaService: PartidaService) {

    @PostMapping
    fun criarPartida(@RequestBody partida: Partida): Partida {
        return partidaService.criarPartida(partida)
    }

    @GetMapping
    fun listarPartidas(): List<Partida> {
        return partidaService.listarPartidas()
    }

    @PutMapping("/{id}")
    fun atualizarPartida(@PathVariable id: Long, @RequestBody novaPartida: Partida): Partida {
        return partidaService.atualizarPartida(id, novaPartida)
    }

    @DeleteMapping("/{id}")
    fun deletarPartida(@PathVariable id: Long) {
        partidaService.deletarPartida(id)
    }

    @GetMapping("/{id}")
    fun buscarPartidaPorId(@PathVariable id: Long): Partida {
        return partidaService.buscarPartidaPorId(id)
    }

    @GetMapping("/buscarPorNomePartida")
    fun buscarPartidasPorNomePartida(@RequestParam nomePartida: String): List<Partida> {
        return partidaService.listarPartidasPorNome(nomePartida)
    }
}
