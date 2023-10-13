import java.util.List;

public class ListaDeProcessosProntos extends ListaDeProcessos {
    
    ListaDeProcessosProntos(){

    }


    public void carregarProcessos(List<BlocoDeControleDeProcessos> tabela){
        for (BlocoDeControleDeProcessos bcp : tabela) {
            ElementoDaLista novoElemento = new ElementoDaLista(bcp);
            novoElemento.setTempoDeEspera(0);
            adicionarNoFinal(novoElemento);
        }
        
    }

}