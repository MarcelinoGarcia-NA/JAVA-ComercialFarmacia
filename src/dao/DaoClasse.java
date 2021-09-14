/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Classe;

/**
 *
 * @author Garcia
 */
public interface DaoClasse {
  
   public void salvarClasse(Classe classe);
   public void alterarClasse(Classe classe);
   public void excluirClasse(int id);
   public List<Classe> getClasses(); 


}
