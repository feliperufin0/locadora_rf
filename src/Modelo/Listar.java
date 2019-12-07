/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Felipe Rufino
 */
public class Listar {
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
        


