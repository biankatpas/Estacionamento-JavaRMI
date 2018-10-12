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
public class Bicicleta
{
    private int id;
    private String descricao;
    private String data;
    private String hora;
    private boolean alugada;

    public Bicicleta()
    {
    }

    public Bicicleta(int id, String descricao, String data, String hora, boolean alugada)
    {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
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

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public String getHora()
    {
        return hora;
    }

    public void setHora(String hora)
    {
        this.hora = hora;
    }

    public boolean isAlugada()
    {
        return alugada;
    }

    public void setAlugada(boolean alugada)
    {
        this.alugada = alugada;
    }
        
}
