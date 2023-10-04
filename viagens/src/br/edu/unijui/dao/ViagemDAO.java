/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.unijui.dao;

import br.edu.unijui.model.Aviao;
import br.edu.unijui.model.Viagem;
import java.util.List;

/**
 *
 * @author lucas.maron
 */
public interface ViagemDAO {
    public boolean inserirViagem(Viagem viagem);
    public List<Viagem> getAllViagens();
    public boolean updateViagem(Viagem viagem);
}
