/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe Rufino
 */
public class ClienteDAO extends ExecuteSQL{

    public ClienteDAO(Connection con) {
        super(con);
    }
    
   public String Inserir_Cliente(Cliente a){
       String sql = "insert into cliente values(0,?,?,?,?,?,?,?,?,?,?)";
       try{
           PreparedStatement ps = getCon().prepareStatement(sql);
           
           ps.setString(1, a.getNome());
           ps.setString(2, a.getNascimento());
           ps.setString(3, a.getRG());
           ps.setString(4, a.getCPF());
           ps.setString(5, a.getEmail());
           ps.setString(6, a.getTelefone());
           ps.setString(7, a.getBairro());
           ps.setString(8, a.getRua());
           ps.setInt(9, a.getNumero());
           ps.setString(10, a.getCPF());
           
           if (ps.executeUpdate() > 0){
               return "Inserido com sucesso.";
           }else{
               return "Erro ao inserir";
           }
       }catch (SQLException e){
           return e.getMessage();
           
           }
       
       
   
   }
  
   public List<Cliente> ListarCliente(){
    String sql = "select idcliente,nome,rg,cpf,telefone,email from cliente";
    List<Cliente> lista = new ArrayList<>();
    try{
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while (rs.next()){
                Cliente a = new Cliente();
                a.setCodigo(rs.getInt(1));
                a.setNome(rs.getString(2));
                a.setRG(rs.getString(3));
                a.setCPF(rs.getString(4));
                a.setTelefone(rs.getString(5));
                a.setEmail(rs.getString(6));
                
                lista.add(a);
            }
            return lista;
        }else {
            return null;
        }
    }catch (SQLException e){
        return null;
        }
        

   }
   public List<Cliente> Pesquisar_Nome_Cliente(String nome){
       String sql = "select idcliente, nome, RG, CPF, Telefone, Email" 
               + "from cliente where nome Like'"+ nome +"'";
   return null;
   }
   
   
   public boolean Testar_Cliente(int cod){
       boolean Resultado = false;
       try{
           
           String sql = "select * from cliente where idcliente = "+ cod + "";
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs !=null){
               while (rs.next()) {
                   Resultado = true;
               }
           }
       }catch (SQLException ex) {
           ex.getMessage();
       }
       return Resultado;
               }
           }
       
   

