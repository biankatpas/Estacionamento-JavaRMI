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
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Hours;

public class Estacionamento implements EstacionamentoDistribuido{
    
    private ArrayList<Bicicleta> bicicletas = new ArrayList<>();
    private float valor = 0;

    public Estacionamento()
    {
        bicicletas.add(new Bicicleta(0, "Caloi Azul", "00/00/0000", "00:00", false));
        bicicletas.add(new Bicicleta(1, "Caloi Rosa", "00/00/0000", "00:00", false));
        bicicletas.add(new Bicicleta(2, "Masculina Verde", "00/00/0000", "00:00", false));
        bicicletas.add(new Bicicleta(3, "Feminina preta", "00/00/0000", "00:00", false));
        bicicletas.add(new Bicicleta(4, "Infantil vermelha", "00/00/0000", "00:00", false));
    }
        
    @Override
    public void registraAluguel(int id, String data, String hora) throws RemoteException
    {
        if(!bicicletas.get(id).isAlugada())
        {
            System.out.println("Registro de aluguel");
            bicicletas.get(id).setDataAluguel(data);
            bicicletas.get(id).setHoraAluguel(hora);
            bicicletas.get(id).setAlugada(true);
        }
        else
        {
            System.out.println("Bicicleta não está disponível.");
        }
    }

    @Override
    public void registraDevolucao(int id, String data, String hora) throws RemoteException
    {
        if(bicicletas.get(id).isAlugada())
        {
            System.out.println("Registro de devolução");
            bicicletas.get(id).setDataDevolucao(data);
            bicicletas.get(id).setHoraDevolucao(hora);
            bicicletas.get(id).setAlugada(false);
        }
        else
        {
            System.out.println("Bicicleta não estava alugada.");
        }
        
    }

    @Override
    public float consultaValorAluguel(int id) throws RemoteException
    {
        try
        {
            if(!bicicletas.get(id).isAlugada())
            {
                System.out.println("Consulta de valor");
                SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
                Date horaAluguel = formatoHora.parse(bicicletas.get(id).getHoraAluguel());
                Date horaDevolucao = formatoHora.parse(bicicletas.get(id).getHoraDevolucao());
                // -----------------------------------------------------------
                // calculo das horas de aluguel usando a biblioteca JodaTime
                DateTime h1 = new DateTime(horaAluguel);
                DateTime h2 = new DateTime(horaDevolucao);
                Hours diff = Hours.hoursBetween(h2, h1);
                // -----------------------------------------------------------
                // calculo do valor: cada hora custa 5.00, de 4 horas a 24h horas custa 20.00     
                this.valor = 0;
                if(diff.getHours() <= 4)
                    this.valor = 5*diff.getHours();
                else if (this.valor <= 24)
                    this.valor = 20;
                // -----------------------------------------------------------
            }
            else
            {
                System.out.println("Bicicleta ainda esta alugada.");
            }
        } catch (ParseException ex)
        {
            System.out.println("Erro: parse data/hora");
        }
        return this.valor;
    }

    @Override
    public ArrayList<Bicicleta> consultaBicicletasAlugadas() throws RemoteException
    {
        ArrayList<Bicicleta> alugadas = new ArrayList<>();
        System.out.println("Consulta bicicletas alugadas.");
        for (int i=0; i< bicicletas.size(); i++)
        {
            if(bicicletas.get(i).isAlugada())
                alugadas.add(bicicletas.get(i));
        }
        return alugadas;
    }

    @Override
    public ArrayList<Bicicleta> consultaBicicletasEstacionadas() throws RemoteException
    {
        ArrayList<Bicicleta> estacionadas = new ArrayList<>();
        System.out.println("Consulta bicicletas estacionadas.");
        for (int i=0; i< bicicletas.size(); i++)
        {
            if(!bicicletas.get(i).isAlugada())
                estacionadas.add(bicicletas.get(i));
        }
        return estacionadas;
    }

}