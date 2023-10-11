public class ElementoDaLista {
    
    public BlocoDeControleDeProcessos bpc;
    public Integer tempoDeEspera;

    ElementoDaLista(BlocoDeControleDeProcessos bcp){
        this.bpc = bcp;
    }

    public BlocoDeControleDeProcessos getBpc() {
        return bpc;
    }

    public void setBpc(BlocoDeControleDeProcessos bpc) {
        this.bpc = bpc;
    }

    public Integer getTempoDeEspera() {
        return tempoDeEspera;
    }

    public void setTempoDeEspera(Integer tempoDeEspera) {
        this.tempoDeEspera = tempoDeEspera;
    }
    
}
