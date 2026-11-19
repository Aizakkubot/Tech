package br.com.bugnacio.techos.exception;

//Classe responsavel por criar uma execeção personalizada
//para representar erros relacionados as regras de negocio do sistema

// construtor que recebe uma mensagem esxplicando o motivo do erro
public class RegraDeNegocioException extends RuntimeException{


    public RegraDeNegocioException (String mensagem) {

    super (mensagem);
    }
    
        
    }
