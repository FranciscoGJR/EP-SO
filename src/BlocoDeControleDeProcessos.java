import java.nio.file.*;
import java.util.*;

public class BlocoDeControleDeProcessos{

    private int PC; //Program Counter
    private EstadoDoProcesso estadoDoProcesso;
    private int x;
    private int y;
    private List<String> programa;
    private String nomeDoPrograma;

    BlocoDeControleDeProcessos(PATH arquivo){ //Adicionar path mais genérico
        this.PC = 1;
        this.x = 0;
        this.y = 0;
        this.programa = Files.readAllLines(arquivo);
        this.nomeDoPrograma = programa.getFirst();
        //Escrever no log ("Carregando TESTE-" + this.nomeDoPrograma");
        this.estadoDoProcesso = PRONTO;
    }

    public List<String> getPrograma() {
        return programa;
    }
    
    public String getNomeDoPrograma() {
        return nomeDoPrograma;
    }

    public int getPC() {
            return PC;
    }

    public void incrementarPC() {
        this.PC++;
    }

    public EstadoDoProcesso getEstadoDoProcesso() {
        return estadoDoProcesso;
    }

    public void setEstadoDoProcesso(EstadoDoProcesso estadoDoProcesso) {
        this.estadoDoProcesso = estadoDoProcesso;
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

}