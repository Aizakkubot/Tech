package br.com.bugnacio.techos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bugnacio.techos.Cliente;

//Interface (Não é classe): Não escrevemos o corpo da classe, o Spring Data JPA faz isso para nós.
// A interface JpaRepository ja possui métodos prontos para salvar, buscar, atualizar e deletar registros do banco.
public interface ClienteRepository {

}
