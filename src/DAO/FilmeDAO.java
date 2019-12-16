/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.DVD;
import Modelo.Filme;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe Rufino
 */
public class FilmeDAO {
    private int codigo;
    private String  titulo;
    private int ano;
    private String duracao;
    private int cod_categoria;
    private int cod_classificacao;
    private String capa;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public int getCod_classificacao() {
        return cod_classificacao;
    }

    public void setCod_classificacao(int cod_classificacao) {
        this.cod_classificacao = cod_classificacao;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }
    public List<DVD> ListarCodFilme(int cod){
        String sql = "select idfilme from dvd where iddvd = "+ cod +"";
        List<DVD> lista = new ArrayList<>();
        try{
        PreparedStatement ps = getCon().preparedStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while (rs.next()){
                DVD a = new DVD();
                a.setcCod_filme(rs.getInt(1));
                
                lista.add(a);
            }
            return lista;
        }else{
            return null;
        }
        }catch (SQLException e){
            return null;
        }
    }
    public List<Filme> Pesquisar_Cod_Filme(int cod){
        String sql = "select idfilme,titulo,ano,duracao,idcategoria,idclassificacao,"
                    +"capa from filme where idfilme = '"+ cod +"'";
        List<Filme> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().preparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()){
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificacao(rs.getInt(6));
                    a.setCapa(rs.getString(7));
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
        }catch (SQLException e){
            return null;
        }
    }
    private void InserirDados(int cod){
        
        Connection con = Conexao.AbrirConexao();
        DVDDAO dvd = new DVDDAO(con); 
        FilmeDAO filme = new FilmeDAO(con);
        List<DVD> listaDVD = new ArrayList<>();
        List<Filme> listaFIL = new ArrayList<>;
        listaDVD = dvd.ListarCodFilme(cod);
        for (DVD a : listaDVD){
            int codigo = a.getCod_Filme();
            listaFIL = filme.Pesquisar_Cod_Filme(codigo);
        }
        for (Filme a : listaFIL){
            jTF_Titulo.setText(a.getTitulo());
            jTF_Categoria.setText(""+ a.getCod_categoria());
            jTF_Classificacao.setText("" + a.getCod_classificacao());
            jLbFoto.setIcon(new ImageIcon("/C:/Video Locadora/Pictures"
            + a.getCapa() + "/"));  
        }
        ClassificacaoDAO cla = new ClassificacaoDAO(con);
        List<Classificacao> listaCLA = new ArrayList<>();
        String b = jTF_Classificacao.getText();
        int codigo = Integer.parseInt(b);
        listaCLA = cla.ListarPrecoClassificacao(codigo);
        for (Classificacao a : listaCLA){
            double preco = a.getPreco();
            jTF_Valor.setText("" + preco + "0");
        }
        Conexao.FecharConexao(con);
    }
}
   
    

