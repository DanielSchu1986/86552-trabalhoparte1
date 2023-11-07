package com.example.AgendamentoFutebol.service

import com.example.AgendamentoFutebol.model.Partida
import com.example.AgendamentoFutebol.repository.PartidaRepository
import org.springframework.stereotype.Service

@Service
class PartidaService(private val partidaRepository: PartidaRepository) {
    fun criarPartida(partida: Partida): Partida {
        return partidaRepository.save(partida)
    }

    fun listarPartidas(): List<Partida> {
        return partidaRepository.findAll()
    }

    fun atualizarPartida(id: Long, novaPartida: Partida): Partida {
        if (partidaRepository.existsById(id)) {
            val partidaExistente = partidaRepository.getOne(id)
            partidaExistente.nomePartida = novaPartida.nomePartida
            partidaExistente.local = novaPartida.local
            partidaExistente.data = novaPartida.data
            return partidaRepository.save(partidaExistente)
        } else {
            throw IllegalArgumentException("Partida não encontrada para atualização")
        }
    }

    fun deletarPartida(id: Long) {
        if (partidaRepository.existsById(id)) {
            partidaRepository.deleteById(id)
        } else {
            throw IllegalArgumentException("Partida não encontrada para exclusão")
        }
    }

    fun buscarPartidaPorId(id: Long): Partida {
        return partidaRepository.findById(id).orElseThrow { IllegalArgumentException("Partida não encontrada") }
    }

    fun listarPartidasPorNome(nomePartida: String): List<Partida> {
        return partidaRepository.findByNomePartidaContainingIgnoreCase(nomePartida)
    }
}
