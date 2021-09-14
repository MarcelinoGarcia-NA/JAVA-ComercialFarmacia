/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Usuario;

/**
 *
 * @author Garcia
 */
public interface DaoUsuario {
    public void salvarUsuario(Usuario usuario);
    public void alterarUsuario(Usuario usuario);
    public void excluirUsuario(int id);
    public List<Usuario> getUsuarios();
}
