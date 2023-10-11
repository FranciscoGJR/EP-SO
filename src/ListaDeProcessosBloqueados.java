public class ListaDeProcessosBloqueados extends ListaDeProcessos {

    ListaDeProcessosBloqueados(){

    }

    public boolean decrementarTempoDeEspera(){
        return false;
    }

    @Override
    public boolean adicionarNoFinal(){
        super.adicionarNoFinal();
        return true;
    }

}