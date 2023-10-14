import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Log {

    private Integer trocas;
    private Integer instrucoes;
    private Integer es;
    private Path diretorio;

    Log() throws IOException{
        this.trocas = -1;
        instrucoes = 0;
        //diretorio = Path do log.txt
        if(Files.notExists(diretorio)){
            Files.createFile(diretorio);
        }
        else {
            //Apagar texto contido
        }
    }

    public void executando(String nomePrograma){
        //Escrever Executando TESTE-1
    }

    public void interrompendo(String nomePrograma, Integer numInstrucoes){
        trocas++;
        instrucoes = instrucoes+numInstrucoes;
        //Escrever Interrompendo Teste-1 após n instruções

    }

    public void es(String nomePrograma){
        es++;
        //E/S iniciada em TESTE-9
    }

    public void terminandoProcesso(String nomePrograma, Integer X, Integer Y){
        //TESTE-1 terminado. X=3. Y=1
    }

    public void terminandoEscalonador(Integer quantum){
        Integer mediaInstrucoes = instrucoes/trocas;
        Integer mediaTrocas = trocas/quantum;

        //MEDIA DE TROCAS: 5
        //MEDIA DE INSTRUCOES: 2.5   
        //QUANTUM: 3

    }

}
