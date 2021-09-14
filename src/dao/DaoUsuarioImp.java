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
import model.Usuario;

/**
 *
 * @author Garcia
 */
public class DaoUsuarioImp implements DaoUsuario{
    
    Connection con = null;
    PreparedStatement pstm= null;
   
    
    public void salvarUsuario(Usuario usuario) {
       con= new Conexao().getConnection();
       try{
           
       pstm = con.prepareStatement("INSERT INTO usuario (nome, senha, email, status) VALUES ( ?, ?, ?,?)",ResultSet.TYPE_SCROLL_SENSITIVE);
       this.pstm.setString(1,usuario.getNome());
       this.pstm.setString(2,usuario.getSenha());
       this.pstm.setString(3,usuario.getEmail());  
       this.pstm.setInt(4,usuario.getStatus()); 
       JOptionPane.showMessageDialog(null,"Usuário Cadastrado!");
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro ao inserir o usuario!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e inserir o usuario!"+errofechar);
           }
       }
      
    } 

    @Override
    public void alterarUsuario(Usuario usuario) {
       con= new Conexao().getConnection();
       try{
           
       pstm = con.prepareStatement("UPDATE usuario SET nome=?, senha=?, email=?, status=? where id=?");
       this.pstm.setString(1,usuario.getNome());
       this.pstm.setString(2,usuario.getSenha());
       this.pstm.setString(3,usuario.getEmail());
       this.pstm.setInt(3,usuario.getStatus()); 
       this.pstm.setInt(4,usuario.getId());
              
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro ao inserir o usuario!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e inserir o usuario!"+errofechar);
           }
       }
        
        
          }

    @Override
    public void excluirUsuario(int id) {
       con= new Conexao().getConnection();
       try{
           
       pstm = con.prepareStatement("DELETE FROM usuario WHERE id=?");
       this.pstm.setInt(1,id);
       
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro ao excluir na tabela!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e excluir na tabela!"+errofechar);
           }
       }
    }


    public int validaLogin (String u, String s) {
       int resposta= 0;
        ResultSet rs= null;
         
         con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("SELECT status FROM usuario WHERE nome=? AND senha=?");
       this.pstm.setString(1,u);
       this.pstm.setString(2,s);
       
       rs=this.pstm.executeQuery();
       if(rs.first()){
           resposta = rs.getInt("status");
       }
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro ao buscar!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e buscar usuario!"+errofechar);
           }
       }return resposta; 
    }
    public void criarUsuarioPadrao() {
       con= new Conexao().getConnection();
       try{
           
       pstm = con.prepareStatement("INSERT INTO usuario (nome, senha, email, status) VALUES ( ?, ?, ?,?)",ResultSet.TYPE_SCROLL_SENSITIVE);
       this.pstm.setString(1,"admin");
       this.pstm.setString(2,"admin");
       this.pstm.setString(3,"admin@ifms.edu.br");
       this.pstm.setInt(4,1);  
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro ao inserir o usuario!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro na conexão e inserir o usuario!"+errofechar);
           }
       }
      
    } 

   
    



    @Override
    public List<Usuario> getUsuarios() {
         ResultSet rs= null;
         List<Usuario> lista = new ArrayList<Usuario>();
         con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("SELECT * FROM usuario");
       
       
       rs=this.pstm.executeQuery();
       if(rs.first()){
           do{
               Usuario u= new Usuario();
               u.setId(rs.getInt("id"));
               u.setNome(rs.getString("nome"));
               u.setSenha(rs.getString("senha"));
               u.setEmail(rs.getString("email"));
               u.setStatus(rs.getInt("status"));
               lista.add(u);
           }while(rs.next());
       }
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro na consulta da tabela!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e alterar na tabela!"+errofechar);
           }
       }return lista; 
    }
    
    
}
