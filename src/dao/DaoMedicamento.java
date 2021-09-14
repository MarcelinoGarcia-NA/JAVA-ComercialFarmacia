/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Medicamento;

/**
 *
 * @author Garcia
 */
public interface DaoMedicamento {
    public void salvarMed(Medicamento m);
    public void alterarMed(Medicamento m);
    public void excluirMed(int id);
    public void alterarestoque(int valor, int id);
    public Medicamento buscaMed(String cod_barras);
    public List<Medicamento> getMedicamentos();
    public List<Medicamento> getMedicamentosVendas();
    public void salvarVenda(Medicamento m);
}
