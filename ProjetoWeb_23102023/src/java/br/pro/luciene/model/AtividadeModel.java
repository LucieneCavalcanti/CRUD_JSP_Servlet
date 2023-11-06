/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.pro.luciene.model;

/**
 *
 * @author luciene.rodrigues
 */
public class AtividadeModel {
    private int id;
    private String descricao;
    private String data;
    private String status;

    public AtividadeModel(int id, String descricao, String data, String status) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.status = status;
    }

    public AtividadeModel() {
        id =0;
        descricao = new String();
        data = new String();
        status = "Aberto"; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
