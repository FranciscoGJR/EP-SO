import java.util.List;

public class ListaDeProcessosProntos extends ListaDeProcessos {
    
    ListaDeProcessosProntos(){

    }


    public void carregarProcessos(List<BlocoDeControleDeProcessos> tabela, Log log){
        for (BlocoDeControleDeProcessos bcp : tabela) {
            ElementoDaLista novoElemento = new ElementoDaLista(bcp);
            log.carregando(novoElemento.bpc.getNomeDoPrograma());
            novoElemento.setTempoDeEspera(0);
            adicionarNoFinal(novoElemento);
        }
        
    }

}