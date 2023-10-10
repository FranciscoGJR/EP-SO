public class BlocoDeControleDeProcessos{

    private int PC; //Program Counter
    private int estadoDoProcesso;
    private int x;
    private int y;
    private String[] programa;
    private String nomeDoPrograma;
    private int tamPrograma;

    BlocoDeControleDeProcessos(int tamPrograma){ //Adicionar arquivo txt como parâmetro
        this.tamPrograma = tamPrograma;
        this.PC = 1;
        this.x = 0;
        this.y = 0;
        this.programa = new String[tamPrograma];
        //Popular programa com o arquivo txt
        this.nomeDoPrograma = programa[0];
    }

    public int getTamPrograma() {
        return tamPrograma;
    }

    public void setTamPrograma(int tamPrograma) {
        this.tamPrograma = tamPrograma;
    }

    public int getPC() {
            return PC;
    }

    public void setPC(int PC) {
        this.PC = PC;
    }

    public int getEstadoDoProcesso() {
        return estadoDoProcesso;
    }

    public void setEstadoDoProcesso(int estadoDoProcesso) {
        if(estadoDoProcesso >= 1 && estadoDoProcesso <= 3 ){
            this.estadoDoProcesso = estadoDoProcesso;
        }
        else System.out.println("Estado inválido!");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String[] getPrograma() {
        return programa;
    }

    public void setPrograma(String[] programa) {
        this.programa = programa;
    }
    
    public String getNomeDoPrograma() {
        return nomeDoPrograma;
    }

    public void setNomeDoPrograma(String nomeDoPrograma) {
        this.nomeDoPrograma = nomeDoPrograma;
    }
}