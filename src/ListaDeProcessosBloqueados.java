public class ListaDeProcessosBloqueados extends ListaDeProcessos {

    ListaDeProcessosBloqueados(){

    }

    public boolean decrementarTempoDeEspera(){
        return false;
    }

    @Override
    public boolean adicionarNoFinal(ElementoDaLista elemento){
        elemento.setTempoDeEspera(2);
        super.adicionarNoFinal(elemento);
        return true;
    }

}