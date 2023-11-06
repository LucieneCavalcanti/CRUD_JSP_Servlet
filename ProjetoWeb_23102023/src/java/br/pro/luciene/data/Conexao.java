/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.pro.luciene.data;

/**
 *
 * @author luciene.rodrigues
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private Connection conexao;
    public Conexao() throws Exception{
        String url="jdbc:sqlserver://localhost:1433;databaseName=bdExemploWeb;encrypt=false;trustServerCertificate=true;";
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String usuarioBanco="UsuarioJava";
        String senhaBanco = "123mudar!";
        Class.forName(driver);
        conexao = DriverManager.getConnection(url, usuarioBanco, senhaBanco);
        System.out.println("Conectado");

    }
    public Connection getConexao(){
        return conexao;
    }
    public boolean fecharConexao() throws SQLException{
        conexao.close();
        return true;
    }
}