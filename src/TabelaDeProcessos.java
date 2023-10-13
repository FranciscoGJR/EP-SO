import java.util.*;

public class TabelaDeProcessos{

    private List<BlocoDeControleDeProcessos> tabela;

    TabelaDeProcessos(){
        tabela = new ArrayList<>();
    }

    public void eliminarDaTabela(BlocoDeControleDeProcessos BCP){
        tabela.remove(BCP);
    }

    public void adicionarNaTabela(BlocoDeControleDeProcessos BCP){
        tabela.add(BCP);
    }

    public List<BlocoDeControleDeProcessos> getTabela() {
        return tabela;
    }

}
