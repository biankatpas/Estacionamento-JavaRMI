/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res;

/**
 *
 * @author biankatpas
 */
import res.ContadorDistribuido;
import java.rmi.RemoteException;

public class Contador implements ContadorDistribuido{

    private int valor = 0;

    @Override
    public void incrementa() throws RemoteException {
        this.valor++;
    }

    @Override
    public int obtemValorAtual() throws RemoteException {
        return this.valor;
    }
}