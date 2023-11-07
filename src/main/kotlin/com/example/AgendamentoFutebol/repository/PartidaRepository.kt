package com.example.AgendamentoFutebol.repository


import com.example.AgendamentoFutebol.model.Partida
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PartidaRepository : JpaRepository<Partida, Long> {
    abstract fun findByNomePartidaContainingIgnoreCase(nomePartida: String): List<Partida>
} 