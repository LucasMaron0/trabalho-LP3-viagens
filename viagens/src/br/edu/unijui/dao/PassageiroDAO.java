package br.edu.unijui.dao;


import br.edu.unijui.model.Passageiro;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lucas.maron
 */
public interface PassageiroDAO {
    public boolean inserirPassageiro(Passageiro passageiro);
    public  List<Passageiro> getAllPassageiros();
    public boolean updatePassageiro(Passageiro passageiro);
}
