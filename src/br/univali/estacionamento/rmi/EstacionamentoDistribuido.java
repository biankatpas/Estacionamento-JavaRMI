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
import java.util.ArrayList;

public interface EstacionamentoDistribuido extends Remote{

    public void registraAluguel(int id, String data, String hora) throws RemoteException;
    public void registraDevolucao(int id, String data, String hora) throws RemoteException;
    public float consultaValorAluguel(int id) throws RemoteException;
    public ArrayList<Bicicleta> consultaBicicletasAlugadas() throws RemoteException;
    public ArrayList<Bicicleta> consultaBicicletasEstacionadas() throws RemoteException;

}
