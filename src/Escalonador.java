import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Escalonador{

    /*Valores logs*/
    Integer logValor_total = 0;
    Integer logIteracoes = 0;
    Integer logInstrucoesES = 0;

    public Integer quantum;
    public TabelaDeProcessos tabelaDeProcessos;
    public ListaDeProcessosProntos listaDeProcessoProntos;
    public ListaDeProcessosBloqueados listaDeProcessosBloqueados;
    public Log log;

    Escalonador(){
        this.log = new Log();
        quantum = this.definirQuantum();
        listaDeProcessoProntos = new ListaDeProcessosProntos();
        listaDeProcessosBloqueados = new ListaDeProcessosBloqueados();
        tabelaDeProcessos = criarTabelaDeProcessos();
        listaDeProcessoProntos.carregarProcessos(tabelaDeProcessos.getTabela(), log);
    }


    public void escalonamento(){
    	  	
        while(!tabelaDeProcessos.getTabela().isEmpty()){
        
            if(!listaDeProcessosBloqueados.getLista().isEmpty()) {
                while (listaDeProcessoProntos.estaVazia() && listaDeProcessosBloqueados.getPrimerioElementoDaLista().getTempoDeEspera() !=0){
                listaDeProcessosBloqueados.decrementarTempoDeEspera();
                }
                
                if(listaDeProcessosBloqueados.getPrimerioElementoDaLista().getTempoDeEspera() == 0){
                    ElementoDaLista novoProcessoPronto = listaDeProcessosBloqueados.removerPrimeiroElemento();
                    listaDeProcessoProntos.adicionarNoFinal(novoProcessoPronto);
                }
            }
            
            listaDeProcessosBloqueados.decrementarTempoDeEspera();
            
            BlocoDeControleDeProcessos blocoTemporario = listaDeProcessoProntos.getPrimeiroProcesso();
            log.executando(blocoTemporario.getNomeDoPrograma());
            System.out.println("\n# " + blocoTemporario.getNomeDoPrograma());

            String instrucaoAtual = blocoTemporario.getInstrucaoAtual();
            if(instrucaoAtual.contains("X") || instrucaoAtual.contains("Y"))
                this.atualizarVariaveis(instrucaoAtual, blocoTemporario);
            
            String ultimaInstrucaoES = "";

            int contadorQuantum = 0;
            while(contadorQuantum < quantum && !instrucaoAtual.equals("SAIDA")){
                System.out.println(instrucaoAtual);

                if (instrucaoAtual.equals("E/S") ) {
                    ElementoDaLista elementoTemporario = listaDeProcessoProntos.removerPrimeiroElemento();
                    listaDeProcessosBloqueados.adicionarNoFinal(elementoTemporario);
                
                
                    blocoTemporario.incrementarPC();
                    logInstrucoesES ++;
                    ultimaInstrucaoES = instrucaoAtual;
                    log.entradaSaida(blocoTemporario.getNomeDoPrograma());
                    break;
                }
                
                contadorQuantum++;
                blocoTemporario.incrementarPC();
                instrucaoAtual = blocoTemporario.getInstrucaoAtual();

            }

            if (instrucaoAtual.equals("SAIDA")) {
                System.out.println("SAIDA");
                tabelaDeProcessos.eliminarDaTabela(blocoTemporario);
                listaDeProcessoProntos.removerPrimeiroElemento();

                log.terminandoProcesso(blocoTemporario.getNomeDoPrograma(), blocoTemporario.getX(), blocoTemporario.getY());             
            }
            else{
                log.interrompendo(blocoTemporario.getNomeDoPrograma(), contadorQuantum);
            }

            if (!ultimaInstrucaoES.equals("E/S") && !instrucaoAtual.equals("SAIDA")){
                ElementoDaLista elementoTemporario = listaDeProcessoProntos.getPrimerioElementoDaLista();
                listaDeProcessoProntos.removerPrimeiroElemento();
                listaDeProcessoProntos.adicionarNoFinal(elementoTemporario);
            } 

        }

        log.terminandoEscalonador(quantum);

        System.out.print("\nTabela de Processos: " + tabelaDeProcessos.toString() + "\n");
        System.out.print("Lista de Processos Prontos: " + listaDeProcessoProntos.toString() + "\n");
        System.out.print("Lista de Processos Bloqueados: " + listaDeProcessosBloqueados.toString() + "\n");
        System.out.println("FIM");

    }


    public void atualizarVariaveis(String instrução, BlocoDeControleDeProcessos bcp){
        String terceiraChar = String.valueOf(instrução.charAt(2));
        Integer inteiro = Integer.parseInt(terceiraChar);

        if(instrução.contains("X")){
          bcp.setX(inteiro);
        }

        if(instrução.contains("Y")){
            bcp.setY(inteiro);
        }

    }


    public TabelaDeProcessos criarTabelaDeProcessos(){
        TabelaDeProcessos tabela = new TabelaDeProcessos();
        this.preencherTabela(tabela);
        return tabela;
    }


    public void preencherTabela(TabelaDeProcessos tabela){
        String caminhoDoarquivo = "";
        for(int i = 1; i <= 10; i++){
            if(i == 10){ 
                caminhoDoarquivo = "./10.txt";
            } else{
                caminhoDoarquivo = "./0" + i + ".txt";
            }

        BlocoDeControleDeProcessos bcp = new BlocoDeControleDeProcessos(caminhoDoarquivo);
        tabela.adicionarNaTabela(bcp);
        }

    }


    public Integer definirQuantum(){

        Path arquivo1 = Paths.get("./quantum.txt");
        try{
            List<String> quantumStr = Files.readAllLines(arquivo1);
            return Integer.parseInt(quantumStr.get(0));

         } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler o arquivo quantum.txt");
        }
        
    }

}
