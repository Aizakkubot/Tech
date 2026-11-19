package br.com.bugnacio.techos.service;

import br.com.bugnacio.techos.exception.RegraDeNegocioException;
import br.com.bugnacio.techos.model.Equipamento;
import br.com.bugnacio.techos.repository.ClienteRepository;
import br.com.bugnacio.techos.repository.EquipamentoRepository;

//@Service informa ao Spring que esta classe contem regras de negocio
public class ClienteService {


    private final ClienteRepository clienteRepo;
    private final EquipamentoRepository equipRepo;

    public ClienteService(ClienteRepository clienteRepo,
        EquipamentoRepository equipRepo){

            //Guarda o repositorio de cliente no atributo da classe
            this.clienteRepo = clienteRepo;

            //guarda o repositorio de equipamento no atributo da classe
            this.equipRepo = equipRepo;
        }

        // metodo responsavel por excluir o cliente pelo ID
        public void excluir(Long id){

            if (equipRepo.existsByClienteId(id)) {
                
                throw new RegraDeNegocioException(null"Este cliente tem equipamentos");
            }
            clienteRepo.deleteById(id);
        }
}
