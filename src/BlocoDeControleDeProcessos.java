import java.nio.file.*;
import java.util.*;

public class BlocoDeControleDeProcessos{

    private int PC; //Program Counter
    private int estadoDoProcesso;
    private int x;
    private int y;
    private List<String> programa;
    private String nomeDoPrograma;

    BlocoDeControleDeProcessos(Path arquivo){ //Adicionar path mais genérico
        this.PC = 1;
        this.x = 0;
        this.y = 0;
        this.programa = Files.readAllLines(arquivo);
        this.nomeDoPrograma = programa.getFirst();
        //Escrever no log ("Carregando TESTE-" + this.nomeDoPrograma");
        this.estadoDoProcesso = 2;
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

}