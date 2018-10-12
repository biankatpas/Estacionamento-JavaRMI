/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.estacionamento.rmi.client;

/**
 *
 * @author biankatpas
 */
import br.univali.estacionamento.rmi.EstacionamentoDistribuido;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    // Constantes que indicam onde está sendo executado o serviço de registro,
    // qual porta e qual o nome do objeto distribuído
    private static final String IPSERVIDOR = "127.0.0.1";
    private static final int PORTA = 1234;
    private static final String NOMEOBJDIST = "MeuEstacionamento";

    public static void main(String args[]) {
        try {
            // Obtendo referência do serviço de registro
            Registry registro = LocateRegistry.getRegistry(IPSERVIDOR, PORTA);

            // Procurando pelo objeto distribuído registrado previamente com o NOMEOBJDIST
            EstacionamentoDistribuido stub = (EstacionamentoDistribuido) registro.lookup(NOMEOBJDIST);

            // Invocando métodos do objeto distribuído
            System.out.println("Registrando o aluguel no servidor.");    
            stub.registraAluguel();
            System.out.println("Registrando a devolução no servidor.");    
            stub.registraDevolucao();
            System.out.println("Solicitando ao servidor o valor a ser pago pelo aluguel.");
            stub.consultaValorAluguel();
            System.out.println("Solicitando ao servidor quais bicicletas estão alugadas.");
            stub.consultaBicicletasAlugadas();
            System.out.println("Solicitando ao servidor quais bicicletas estão no estacionamento.");
            stub.consultaBicicletasEstacionadas();
            System.out.println("Fim da execução do cliente!");

        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
