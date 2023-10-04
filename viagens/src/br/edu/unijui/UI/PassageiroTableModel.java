/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unijui.UI;

import br.edu.unijui.model.Passageiro;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lucas
 */
public class PassageiroTableModel extends AbstractTableModel {

    private List<Passageiro> passageiros;
    private String[] colunas = {"ID", "Nome", "Passaporte"};
    
    
    public PassageiroTableModel(List<Passageiro> listPassageiros) {
        
        this.passageiros = listPassageiros;
        fireTableStructureChanged();
    }
     
    @Override
    public int getRowCount() {
        return passageiros.size();    
    }

    @Override
    public int getColumnCount() {
         return colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Passageiro passageiro = passageiros.get(rowIndex);
        switch (columnIndex) {
            case 0: return passageiro.getId(); 
            case 1: return passageiro.getNome();
            case 2: return passageiro.getPassaporte();
            default: return null;
        }
    }
     
}
