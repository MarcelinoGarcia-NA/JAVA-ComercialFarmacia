/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.DaoUsuarioImp;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Garcia
 */
public class ControllerUsuario {
    DaoUsuarioImp dao = new DaoUsuarioImp();
    List<Usuario> lista = new ArrayList<Usuario>();
    
    
    
    public List<Usuario> retornaUsuario(){
        return dao.getUsuarios();
        
    }
    public void criarUsuarioPadrao(){
        dao.criarUsuarioPadrao();
    }
    public int validaLogin(String u,String s){
        return dao.validaLogin(u, s);
    }
    public void cadastrarUser(Usuario usuario){
        dao.salvarUsuario(usuario);
    }
     public List<Usuario> recarregaLista(){
        lista.clear();
        lista=dao.getUsuarios();
        return lista;
    }        
}
