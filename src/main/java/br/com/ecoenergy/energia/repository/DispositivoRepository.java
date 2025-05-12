package br.com.ecoenergy.energia.repository;

import br.com.ecoenergy.energia.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {

    public Optional<Dispositivo> findByNome(String nome);

    public List<Dispositivo> findByUltimaAtualizacaoBetween(LocalDate dataInicial, LocalDate dataFinal);
}
