/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//to aguardando vc mandar a braba
package br.pro.luciene.data;

import br.pro.luciene.model.AtividadeModel;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
create table tbAtividades (
* id int not null identity primary key,
* descricao varchar(200) not null,
* data varchar(10) not null,
* status varchar(20)
* )
 */
public class AtividadeData extends Conexao{
    public AtividadeData() throws Exception{}
    public boolean incluir(AtividadeModel obj) throws Exception{
        String sql = "Insert into tbAtividades (descricao,data,status) values (?,?,?)";
        System.out.println(sql);
        System.out.println(obj.getDescricao());
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getDescricao());
        ps.setString(2, obj.getData());
        ps.setString(3, obj.getStatus());
        if(ps.executeUpdate()>0) return true;
        else return false;
    }
    public boolean atualizar(AtividadeModel obj) throws Exception{
        String sql = "update tbAtividades set descricao=?,data=?,status=?"
                + " where id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getDescricao());
        ps.setString(2, obj.getData());
        ps.setString(3, obj.getStatus());
        ps.setInt(4,obj.getId());
        if(ps.executeUpdate()>0) return true;
        else return false;
    }
    public boolean excluir(int id) throws Exception{
        String sql = "delete from tbAtividades where id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1,id);
        if(ps.executeUpdate()>0) return true;
        else return false;
    }
    public ArrayList<AtividadeModel> pesquisar(String pesquisa)
            throws Exception{
        ArrayList<AtividadeModel> dados = new ArrayList<>();
        String sql = "select * from tbAtividades where descricao like '" 
                + pesquisa + "%' order by data";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            AtividadeModel obj = new AtividadeModel(rs.getInt("id"), 
                rs.getString("descricao"), rs.getString("data"), 
                rs.getString("status"));
            dados.add(obj);
        }
        return dados;
    }
    public AtividadeModel obter(int id) throws Exception{
        String sql = "select * from tbAtividades where id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        AtividadeModel obj = null;
        if(rs.next()){
            obj = new AtividadeModel(rs.getInt("id"), 
                rs.getString("descricao"), rs.getString("data"), 
                rs.getString("status"));
        }
        return obj;
    }
    
}
