public class TabelaDeProcessos{

    private BlocoDeControleDeProcessos[] tabela;
    private int numProcessos;

    TabelaDeProcessos(int numProcessos){
        this.numProcessos = numProcessos;
        this.tabela = new BlocoDeControleDeProcessos[numProcessos];
    }

    public int getNumProcessos() {
        return numProcessos;
    }

    public void setNumProcessos(int numProcessos) {
        this.numProcessos = numProcessos;
    }

    public BlocoDeControleDeProcessos[] getTabela() {
        return tabela;
    }

    public void setTabela(BlocoDeControleDeProcessos[] tabela) {
        this.tabela = tabela;
    }
}
