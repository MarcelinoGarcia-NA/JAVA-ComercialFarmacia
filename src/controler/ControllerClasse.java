/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.DaoClasseImp;
import java.util.ArrayList;
import java.util.List;
import model.Classe;

/**
 *
 * @author Garcia
 */
public class ControllerClasse {
   DaoClasseImp dao = new DaoClasseImp();
     List<Classe> lista = new ArrayList<Classe>();
    public List<String> carregaCombo(){
        return dao.getNomeClasses();
    }
    public int getIdByClasse(String classe){
        return dao.getIdByClasse(classe);
    }
    public String getClasseById(int id){
        return dao.getClasseById(id);
    }
     public void cadadastrarClasse(Classe classe){
        dao.salvarClasse(classe);
    }
      public List<Classe> recarregaLista(){
        lista.clear();
        lista=dao.getClasses();
        return lista;
    }   
}
