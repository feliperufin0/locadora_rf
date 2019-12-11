/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Felipe Rufino
 */
public class DVDDAO {
    private int codigo;
    private int cod_filme;
    private String situacao;
    private double preco;
    private String data_compra;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCod_filme() {
        return cod_filme;
    }

    public void setCod_filme(int cod_filme) {
        this.cod_filme = cod_filme;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getData_compra() {
        return data_compra;
    }

    public void setData_compra(String data_compra) {
        this.data_compra = data_compra;
    }
    
    
    
    public boolean Testar_DVD (int cod){    
        boolean teste = false;
        
        try{
            String sql = "select iddvd from where iddvd=" + cod+ "";
            PreparedStatement ps = getCon().preparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs !=null){
               while (rs.next()) {
                   teste = true;
               }
            }
        }catch (SQLException ex) {
           ex.getMessage();
            }
            return teste;
        
           
    }
              
     public boolean Testar_Situacao(int cod) {
        boolean teste = false;
        
        try{
            String sql = "select iddvd from where iddvd=" + cod+ ""+"and situacao='disponivel'";
            PreparedStatement ps = getCon().preparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs !=null){
               while (rs.next()) {
                   teste = true;
               }
            }
        }catch (SQLException ex) {
           ex.getMessage();
            }
            return teste;
          
     }   
        public void AtualizarDate(){
           Date date = new Date();
           SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
           SimpleDateFormat hora = new SimpleDateFormat("hh:mm");
           jTF_DataLocacao.setText(data.format(date));
           jTF_Horas.setText(horas.format(date));
           
           
           
        }     
}
    

