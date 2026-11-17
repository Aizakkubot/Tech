package br.com.bugnacio.techos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bugnacio.techos.model.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    boolean existsByClienteId(Long clienteId);
    
    List<Equipamento> findByMarcaContainingIgnoreCase(String marca);

    List<Equipamento> findByModeloContainingIgnoreCase(String modelo);

     boolean existsByNumeroSerie(String numeroSerie);

     boolean existsByNumeroSerieAndIdNot(String numeroSerie, Long id);

}