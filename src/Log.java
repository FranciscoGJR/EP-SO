import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Log {

    private Integer trocas;
    private Integer instrucoes;
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

    private void executando(String nomePrograma){
        //Escrever Executando TESTE-1
    }

    private void interrompendo(String nomePrograma, Integer numInstrucoes){
        trocas++;
        instrucoes = instrucoes+numInstrucoes;
        //Escrever Interrompendo Teste-1 após n instruções

    }

    private void es(String nomePrograma){
        //E/S iniciada em TESTE-9
    }

    private void terminandoProcesso(String nomePrograma, Integer X, Integer Y){
        //TESTE-1 terminado. X=3. Y=1
    }

    private void terminandoEscalonador(Integer quantum){
        Integer mediaInstrucoes = instrucoes/trocas;
        Integer mediaTrocas = trocas/quantum;
        //Calcular media de trocas e intruções

        //MEDIA DE TROCAS: 5
        //MEDIA DE INSTRUCOES: 2.5   
        //QUANTUM: 3

    }

}
