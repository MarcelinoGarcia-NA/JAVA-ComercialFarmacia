/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Classe;

/**
 *
 * @author Garcia
 */
public class DaoClasseImp implements DaoClasse{
     Connection con = null;
     PreparedStatement pstm= null;
      public List<String> getNomeClasses() {
         ResultSet rs= null;
         List<String> lista = new ArrayList<String>();
         con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("SELECT nome FROM classe ORDER BY nome ASC");
       
       
       rs=this.pstm.executeQuery();
       if(rs.first()){
           do{
               lista.add(rs.getString("nome"));
               
           }while(rs.next());
       }
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro na lista!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e lista!"+errofechar);
           }
       }return lista;
    }
      public int getIdByClasse(String classe) {
         ResultSet rs= null;
         int id=0;
         con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("SELECT id FROM classe WHERE nome=?");
       pstm.setString(1,classe);
       
       
       rs=this.pstm.executeQuery();
       if(rs.first()){
          id=rs.getInt("id");
       }
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro na lista!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e lista!"+errofechar);
           }
       }return id;
    }
       public String getClasseById(int id) {
         ResultSet rs= null;
         String classe="";
         con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("SELECT nome FROM classe WHERE id=?");
       pstm.setInt(1,id);
       
       
       rs=this.pstm.executeQuery();
       if(rs.first()){
          classe=rs.getString("nome");
       }
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro na lista!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e lista!"+errofechar);
           }
       }return classe;
       
    }
         public void salvarClasse(Classe classe) {
       con= new Conexao().getConnection();
       try{
           
       pstm = con.prepareStatement("INSERT INTO classe (nome) VALUES ( ?)");
       this.pstm.setString(1,classe.getNome());
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro ao inserir uma marca!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e inserir uma marca!"+errofechar);
           }
       }
      
    } 

  
    @Override
    public List<Classe> getClasses() {
         ResultSet rs= null;
         List<Classe> lista = new ArrayList<Classe>();
         con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("SELECT * FROM classe");
       
       
       rs=this.pstm.executeQuery();
       if(rs.first()){
           do{
               Classe n= new Classe();
               n.setId(rs.getInt("id"));
               n.setNome(rs.getString("nome"));
               lista.add(n);
           }while(rs.next());
       }
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro na lista!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e lista!"+errofechar);
           }
       }return lista;
    }

    @Override
    public void alterarClasse(Classe classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluirClasse(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
