/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.estacionamento.rmi.server;

/**
 *
 * @author biankatpas
 */
import br.univali.estacionamento.rmi.EstacionamentoDistribuido;
import java.rmi.RemoteException;

public class Estacionamento implements EstacionamentoDistribuido{

    @Override
    public void registraAluguel() throws RemoteException
    {
        System.out.println("Registro aluguel");
    }

    @Override
    public void registraDevolucao() throws RemoteException
    {
        System.out.println("Registro de devolução");
    }

    @Override
    public int consultaValorAluguel() throws RemoteException
    {
        System.out.println("Consulta de valor");
        return 0;
    }

    @Override
    public int consultaBicicletasAlugadas() throws RemoteException
    {
        System.out.println("Consulta de bicicletas alugadas");
        return 0;
    }

    @Override
    public int consultaBicicletasEstacionadas() throws RemoteException
    {
        System.out.println("Consulta de bicicletas no estacionamento");
        return 0;
    }

}