package br.com.ecoenergy.energia.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tbl_dispositivos")
public class Dispositivo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "DISPOSITIVOS_SEQ"
    )
    @SequenceGenerator(
            name = "DISPOSITIVOS_SEQ",
            sequenceName = "DISPOSITIVOS_SEQ",
            allocationSize = 1
    )
    private Long id;

    private String nome;

    @Column(name = "ultima_atualizacao")
    private LocalDate ultimaAtualizacao;

    private boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDate ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dispositivo that)) return false;
        return isAtivo() == that.isAtivo() && Objects.equals(getId(), that.getId()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getUltimaAtualizacao(), that.getUltimaAtualizacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getUltimaAtualizacao(), isAtivo());
    }
}
