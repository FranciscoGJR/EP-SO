import java.nio.file.*;
import java.util.*;
import java.io.IOException;

public class BlocoDeControleDeProcessos{

    private int PC; //Program Counter
    private EstadoDoProcesso estadoDoProcesso;
    private int x;
    private int y;
    private List<String> programa;
    private String nomeDoPrograma;

    BlocoDeControleDeProcessos(String nomeArquivo){
        this.PC = 1;
        this.x = 0;
        this.y = 0;

        String diretorioAtual = System.getProperty("user.dir");
        Path arquivo = Paths.get(diretorioAtual, nomeArquivo);
        try{
            this.programa = Files.readAllLines(arquivo);
            this.nomeDoPrograma = programa.get(0);

            for(String linha: programa){    //Imprimindo linhas para teste
                System.out.println(linha);
            }
            
        } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler o arquivo.");
        }

        //Escrever no log ("Carregando TESTE-" + this.nomeDoPrograma");
        this.estadoDoProcesso = EstadoDoProcesso.PRONTO;
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