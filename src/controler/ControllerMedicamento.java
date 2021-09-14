/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.DaoMedicamento;
import dao.DaoMedicamentoImp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import model.Medicamento;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Garcia
 */
public class ControllerMedicamento {
          List<Medicamento> lista = new ArrayList<Medicamento>();
         DaoMedicamento dao= new DaoMedicamentoImp();
    
    public void salvarMedicamento(Medicamento n){
        if(n!=null && !n.getNome_med().equals("") && !n.getCod_barras().equals("") && !n.getFabricante().equals("")&& n.getClasse_med()>0){
            dao.salvarMed(n);
            JOptionPane.showMessageDialog(null,"Medicamento salvo com sucesso");
        }else{
             JOptionPane.showMessageDialog(null,"Existem campos vazios");
        }
    }
        public void salvarVenda(Medicamento n){
           dao.salvarVenda(n);
    }
     public Medicamento buscaMedicamento(String n){
            Medicamento m = new Medicamento();
            m= dao.buscaMed(n);
       
            return m;
  
    }public void alterarMedicamento(int id, int quant){
           dao.alterarestoque(id, quant);
         
    }
    
     public void alterarMedicamento(Medicamento n){
          if(n!=null && !n.getNome_med().equals("") && !n.getCod_barras().equals("") && !n.getFabricante().equals("")&& n.getClasse_med()>0){
            dao.alterarMed(n);
            JOptionPane.showMessageDialog(null,"Medicamento alterardo com sucesso");
        }else{
             JOptionPane.showMessageDialog(null,"Existem campos vazios");
        }
    }
    public void excluirMedicamento(int id){
        int opcao = JOptionPane.showConfirmDialog(null,"Excluir o Medicamento de id "+id,"excluir", JOptionPane.YES_NO_OPTION);
    if (opcao ==0){
        JOptionPane.showMessageDialog(null,"Exclusão efetivada");
        dao.excluirMed(id);
    }else{
        JOptionPane.showMessageDialog(null,"Exclusão não efetivada");
    }
    }
    
    public List<Medicamento> recarregaLista(){
        lista.clear();
        lista=dao.getMedicamentos();
        return lista;
    }
    public void GerarRelatorioEstoqueMedicamentos(){
        try{
            HashMap filtro= new HashMap();
            JRBeanCollectionDataSource colecao= new JRBeanCollectionDataSource(getMedicamentos(),false);
            
            JasperPrint imprimir =JasperFillManager.fillReport("C:\\Users\\Garcia\\Documents\\NetBeansProjects\\Comercial_Farmacia\\src\\relatorio\\relatorio_medicamentos.jasper", filtro,colecao);
            JasperViewer visualizar = new JasperViewer(imprimir, false);
            visualizar.setVisible(true);
            
        }catch(JRException erro){
            JOptionPane.showMessageDialog(null,"Erro ao gerar o relatório"+erro);
            erro.printStackTrace();
        }
    }
    public void GerarRelatorioVenda(){
        try{
            HashMap filtro= new HashMap();
            JRBeanCollectionDataSource colecao= new JRBeanCollectionDataSource(getMedicamentosVendas(),false);
            
            JasperPrint imprimir =JasperFillManager.fillReport("C:\\Users\\Garcia\\Documents\\NetBeansProjects\\Comercial_Farmacia\\src\\relatorio\\relatorio_vendas.jasper", filtro,colecao);
            JasperViewer visualizar = new JasperViewer(imprimir, false);
            visualizar.setVisible(true);
            
        }catch(JRException erro){
            JOptionPane.showMessageDialog(null,"Erro ao gerar o relatório"+erro);
            erro.printStackTrace();
        }
    }

    private List<Medicamento> getMedicamentos() {
      List<Medicamento> m = dao.getMedicamentos();
      return m;
    }
      private List<Medicamento> getMedicamentosVendas() {
      List<Medicamento> m = dao.getMedicamentosVendas();
      return m;
    }
}
