/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.estacionamento.rmi;

/**
 *
 * @author biankatpas
 */
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
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
//****************************************************************************************************************************************************************************************************************************
            System.out.println("Registrando o 1o aluguel no servidor.");    
            stub.registraAluguel(0, "12/10/2018", "16:00");
//****************************************************************************************************************************************************************************************************************************
            System.out.println("Registrando o 2o aluguel no servidor.");    
            stub.registraAluguel(3, "12/10/2018", "18:00");            
//****************************************************************************************************************************************************************************************************************************
            System.out.println("Solicitando ao servidor quais bicicletas estão alugadas.");
            ArrayList<Bicicleta> alugadas = stub.consultaBicicletasAlugadas();
            System.out.println("Id\tDescrição\tDataAluguel\tHoraAluguel");
            for (int i=0;i<alugadas.size();i++)
            {
                System.out.println(alugadas.get(i).getId() + "\t" + alugadas.get(i).getDescricao() + "\t" + alugadas.get(i).getDataAluguel() + "\t" + alugadas.get(i).getHoraAluguel());
            }
//****************************************************************************************************************************************************************************************************************************
            System.out.println("Solicitando ao servidor quais bicicletas estão no estacionamento.");
            ArrayList<Bicicleta> estacionadas = stub.consultaBicicletasEstacionadas();
            System.out.println("Id\tDescrição");
            for (int i=0;i<estacionadas.size();i++)
            {
                System.out.println(estacionadas.get(i).getId() + "\t" + estacionadas.get(i).getDescricao());
            }
//****************************************************************************************************************************************************************************************************************************
            System.out.println("Registrando a 1a devolução no servidor.");    
            stub.registraDevolucao(0, "12/10/2018", "19:00");
//****************************************************************************************************************************************************************************************************************************
            System.out.println("Solicitando ao servidor o valor a ser pago pelo 1o aluguel.");
            float valor = stub.consultaValorAluguel(0);
            System.out.println("----" + valor + "-----");
//****************************************************************************************************************************************************************************************************************************
            System.out.println("Solicitando ao servidor quais bicicletas estão alugadas.");
            alugadas.clear();
            alugadas = stub.consultaBicicletasAlugadas();
            System.out.println("Id\tDescrição\tDataAluguel\tHoraAluguel");
            for (int i=0;i<alugadas.size();i++)
            {
                System.out.println(alugadas.get(i).getId() + "\t" + alugadas.get(i).getDescricao() + "\t" + alugadas.get(i).getDataAluguel() + "\t" + alugadas.get(i).getHoraAluguel());
            }
//****************************************************************************************************************************************************************************************************************************
            System.out.println("Solicitando ao servidor quais bicicletas estão no estacionamento.");
            estacionadas.clear();
            estacionadas = stub.consultaBicicletasEstacionadas();
            System.out.println("Id\tDescrição");
            for (int i=0;i<estacionadas.size();i++)
            {
                System.out.println(estacionadas.get(i).getId() + "\t" + estacionadas.get(i).getDescricao());
            }
//****************************************************************************************************************************************************************************************************************************
            System.out.println("Fim da execução do cliente!");
//****************************************************************************************************************************************************************************************************************************

        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
