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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Medicamento;

/**
 *
 * @author Garcia
 */
public class DaoMedicamentoImp implements DaoMedicamento {
      Connection con = null;
      PreparedStatement pstm= null;
    
    @Override
    public void salvarMed(Medicamento m) {
       con= new Conexao().getConnection();
       try{
           
       pstm = con.prepareStatement("INSERT INTO medicamento (nome_med, cod_barras, fabricante, classe_med, quant, valor_med) VALUES ( ?, ?, ?,?, ?, ?)");
       this.pstm.setString(1,m.getNome_med());
       this.pstm.setString(2,m.getCod_barras());
       this.pstm.setString(3,m.getFabricante());
       this.pstm.setInt(4,m.getClasse_med());
       this.pstm.setInt(5,m.getQuant()); 
       this.pstm.setDouble(6,m.getValor_med()); 
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro ao inserir na tabela!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e inserir na tabela!"+errofechar);
           }
       }
      
    }
      
    @Override
    public void salvarVenda(Medicamento m) {
       con= new Conexao().getConnection();
       try{
           
       pstm = con.prepareStatement("INSERT INTO venda_medicamento (nome_med, cod_barras, fabricante, classe_med, quant, valor_med) VALUES ( ?, ?, ?,?, ?, ?)");
       this.pstm.setString(1,m.getNome_med());
       this.pstm.setString(2,m.getCod_barras());
       this.pstm.setString(3,m.getFabricante());
       this.pstm.setInt(4,m.getClasse_med());
       this.pstm.setInt(5,m.getQuant()); 
       this.pstm.setDouble(6,m.getValor_med()); 
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro ao inserir na tabela!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e inserir na tabela!"+errofechar);
           }
       }
      
    }

    @Override
    public void alterarMed(Medicamento m) {
       con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("UPDATE medicamento SET nome_med=?, cod_barras=?, fabricante=?, classe_med=?, quant=?, valor_med=? where id=?");
       this.pstm.setString(1,m.getNome_med());
       this.pstm.setString(2,m.getCod_barras());
       this.pstm.setString(3,m.getFabricante());
       this.pstm.setInt(4,m.getClasse_med());
       this.pstm.setInt(5,m.getQuant());
       this.pstm.setDouble(6,m.getValor_med()); 
       this.pstm.setInt(7,m.getId());       
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro ao alterar na tabela!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e alterar na tabela!"+errofechar);
           }
       }
    }

    @Override
    public void excluirMed(int id) {
         con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("DELETE FROM medicamento WHERE id=?");
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

    @Override
    public List<Medicamento> getMedicamentos() {
       ResultSet rs= null;
         List<Medicamento> lista = new ArrayList<Medicamento>();
         con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("SELECT * FROM medicamento");
       
       
       rs=this.pstm.executeQuery();
       if(rs.first()){
           do{
               Medicamento n= new Medicamento();
               n.setId(rs.getInt("id"));
               n.setNome_med(rs.getString("nome_med"));
               n.setFabricante(rs.getString("fabricante"));
               n.setCod_barras(rs.getString("cod_barras"));
               n.setClasse_med(rs.getInt("classe_med"));
               n.setQuant(rs.getInt("quant"));
               n.setValor_med(rs.getDouble("valor_med"));
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
    public Medicamento buscaMed(String cod_barras) {
       con= new Conexao().getConnection();
        Medicamento n= new Medicamento(); 
       String consulta="Select *from medicamento where cod_barras=?";
       try{
          pstm = con.prepareStatement(consulta); 
          pstm.setString(1,cod_barras);
          ResultSet rs = this.pstm.executeQuery();
       if(rs.first()){
           do{
              
               n.setId(rs.getInt("id"));
               n.setNome_med(rs.getString("nome_med"));
               n.setFabricante(rs.getString("fabricante"));
               n.setCod_barras(rs.getString("cod_barras"));
               n.setClasse_med(rs.getInt("classe_med"));
               n.setQuant(rs.getInt("quant"));
               n.setValor_med(rs.getDouble("valor_med"));
           }while(rs.next());
       }
        pstm.execute();
        pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"Medicamento não encontrado!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e excluir na tabela!"+errofechar);
           }
       }
        
          return n;
    }

    @Override
    public void alterarestoque(int quant, int id) {
        con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("UPDATE medicamento SET quant=? where id=?");
       this.pstm.setInt(1,id);
       this.pstm.setInt(2,quant);
        
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro ao alterar na tabela!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e alterar na tabela!"+errofechar);
           }
       }
    }

    @Override
    public List<Medicamento> getMedicamentosVendas() {
  ResultSet rs= null;
         List<Medicamento> lista = new ArrayList<Medicamento>();
         con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("SELECT * FROM venda_medicamento");
       
       
       rs=this.pstm.executeQuery();
       if(rs.first()){
           do{
               Medicamento n= new Medicamento();
               n.setId(rs.getInt("id"));
               n.setNome_med(rs.getString("nome_med"));
               n.setFabricante(rs.getString("fabricante"));
               n.setCod_barras(rs.getString("cod_barras"));
               n.setClasse_med(rs.getInt("classe_med"));
               n.setQuant(rs.getInt("quant"));
               n.setValor_med(rs.getDouble("valor_med"));
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
       }return lista;    }

  
}
