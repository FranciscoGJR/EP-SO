import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.text.DecimalFormat;
import java.util.*;

public class Log {

    private double trocas;
    private double instrucoes;
    private double es;
    private Path arquivo;
    Log(){
        es = 0;
        this.trocas = -1;
        instrucoes = 0;
        String diretorioAtual = System.getProperty("user.dir");
        arquivo = Paths.get(diretorioAtual, "log.txt");
        try{
            if(Files.notExists(arquivo)){
                Files.createFile(arquivo);
            }
            else {
                Files.writeString(arquivo, "");
            }
            
        } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Erro no log.txt");
        }


    }

    public void carregando(String nomePrograma){
        try{
            List<String> linhas = Files.readAllLines(arquivo);
            linhas.add("Carregando " + nomePrograma);           
            Files.write(arquivo, linhas);
        }   catch(IOException e){
            e.printStackTrace();
        }
    }

    public void executando(String nomePrograma){
        
        try{
            List<String> linhas = Files.readAllLines(arquivo);
            linhas.add("Executando " + nomePrograma);           
            Files.write(arquivo, linhas);
        }   catch(IOException e){
            e.printStackTrace();
        }


        //Escrever Executando TESTE-1
    }

    public void interrompendo(String nomePrograma, Integer numInstrucoes){
        trocas++;
        instrucoes = instrucoes+numInstrucoes;
        try{
            List<String> linhas = Files.readAllLines(arquivo);
            linhas.add("Interrompendo " + nomePrograma + " após " + numInstrucoes + " instruções");           
            Files.write(arquivo, linhas);
        }   catch(IOException e){
            e.printStackTrace();
        }
        //Escrever Interrompendo Teste-1 após n instruções
    }

    public void entradaSaida(String nomePrograma){
        es++;
        try{
            List<String> linhas = Files.readAllLines(arquivo);
            linhas.add("E/S iniciada em " + nomePrograma);           
            Files.write(arquivo, linhas);
        }   catch(IOException e){
            e.printStackTrace();
        }
        //E/S iniciada em TESTE-9
    }

    public void terminandoProcesso(String nomePrograma, Integer x, Integer y){
        try{
            List<String> linhas = Files.readAllLines(arquivo);
            linhas.add(nomePrograma + " terminado " + "X=" + x + ". Y=" +y);           
            Files.write(arquivo, linhas);
        }   catch(IOException e){
            e.printStackTrace();
        }
    }

    public void terminandoEscalonador(Integer quantum){
        double mediaInstrucoes = instrucoes/trocas;
        double mediaTrocas = trocas/quantum;

        DecimalFormat df = new DecimalFormat("#.##");
        String mediaTrocasFormatada = df.format(mediaTrocas);
        String mediaInstrucoesFormatada = df.format(mediaInstrucoes);

        try{
            List<String> linhas = Files.readAllLines(arquivo);
            linhas.add("MEDIA DE TROCAS: " + mediaTrocasFormatada);
            linhas.add("MEDIA DE INSTRUCOES: " + mediaInstrucoesFormatada);
            linhas.add("Quantum: " + quantum);
            Files.write(arquivo, linhas);
        }   catch(IOException e){
            e.printStackTrace();
        }
    }

    public double getEs() {
        return es;
    }
}