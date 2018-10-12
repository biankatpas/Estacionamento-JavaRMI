/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.estacionamento.rmi;

import java.io.Serializable;

/**
 *
 * @author biankatpas
 */
public class Bicicleta implements Serializable
{
    private int id;
    private String descricao;
    private String dataAluguel;
    private String horaAluguel;
    private String dataDevolucao;
    private String horaDevolucao;
    private boolean alugada;

    public Bicicleta()
    {
    }

    public Bicicleta(int id, String descricao, String data, String hora, boolean alugada)
    {
        this.id = id;
        this.descricao = descricao;
        this.dataAluguel = data;
        this.horaAluguel = hora;
        this.alugada = alugada;
    }

        
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public boolean isAlugada()
    {
        return alugada;
    }

    public void setAlugada(boolean alugada)
    {
        this.alugada = alugada;
    }

    public String getDataDevolucao()
    {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao)
    {
        this.dataDevolucao = dataDevolucao;
    }

    public String getHoraDevolucao()
    {
        return horaDevolucao;
    }

    public void setHoraDevolucao(String horaDevolucao)
    {
        this.horaDevolucao = horaDevolucao;
    }

    public String getDataAluguel()
    {
        return dataAluguel;
    }

    public void setDataAluguel(String dataAluguel)
    {
        this.dataAluguel = dataAluguel;
    }

    public String getHoraAluguel()
    {
        return horaAluguel;
    }

    public void setHoraAluguel(String horaAluguel)
    {
        this.horaAluguel = horaAluguel;
    }
        
}
