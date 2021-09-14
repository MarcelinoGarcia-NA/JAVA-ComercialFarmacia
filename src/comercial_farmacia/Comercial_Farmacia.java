/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comercial_farmacia;

import controler.ControllerUsuario;
import javax.swing.JOptionPane;
import view.Login;

/**
 *
 * @author Garcia
 */
public class Comercial_Farmacia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          ControllerUsuario control= new ControllerUsuario();
        
        if(control.retornaUsuario().isEmpty()){
            JOptionPane.showMessageDialog(null,"entrou");
            control.criarUsuarioPadrao();
            
            
        }
        
        Login l= new Login();
        l.setVisible(true);
    } 
  }
    

