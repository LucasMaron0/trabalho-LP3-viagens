/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.unijui.dao;

import br.edu.unijui.model.Aviao;
import java.util.List;

/**
 *
 * @author lucas.maron
 */
public interface AviaoDAO {
    public boolean inserirAviao(Aviao aviao);
    public List<Aviao> getAllAvioes();
    public Aviao getAviao(int id);
    public boolean updateAviao(Aviao aviao);
    public boolean setAviaoEmViagem(Aviao aviao);
}
