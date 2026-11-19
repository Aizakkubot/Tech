package br.com.bugnacio.techos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bugnacio.techos.model.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

List<Equipamento> findByMarcaContainingIgnoreCaseOrModeloContainingIgnoreCase(String marca, String modelo);

boolean existsByNumeroSerie(String numeroSerie);

boolean existsByNumeroSerieAndIdNot(String numeroSerie, Long id);
      
boolean existexistsByclienteByClienteId(long clienteid);

}