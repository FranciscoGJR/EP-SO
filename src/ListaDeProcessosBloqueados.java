import java.util.List;

public class ListaDeProcessosBloqueados extends ListaDeProcessos {

    ListaDeProcessosBloqueados(){

    }

    public void decrementarTempoDeEspera(){
        List<ElementoDaLista> listaTemp = getLista();

        for (ElementoDaLista elemento : listaTemp) {
            elemento.tempoDeEspera--;
        }
    }

    @Override
    public boolean adicionarNoFinal(ElementoDaLista elemento){
        elemento.setTempoDeEspera(2);
        super.adicionarNoFinal(elemento);
        return true;
    }

}