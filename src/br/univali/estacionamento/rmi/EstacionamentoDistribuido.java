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
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EstacionamentoDistribuido extends Remote{

    public void registraAluguel() throws RemoteException;
    public void registraDevolucao() throws RemoteException;
    public int consultaValor() throws RemoteException;
    public int consultaBicicletasAlugadas() throws RemoteException;
    public int consultaBicicletasEstacionamento() throws RemoteException;

}
