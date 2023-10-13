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

    Escalonador(){
        quantum = this.definirQuantum();
        listaDeProcessoProntos = new ListaDeProcessosProntos();
        listaDeProcessosBloqueados = new ListaDeProcessosBloqueados();
        tabelaDeProcessos = criarTabelaDeProcessos();
        listaDeProcessoProntos.carregarProcessos(tabelaDeProcessos.getTabela());
    }


    public void Escalonamento(){
    	  	
    	
        while(!tabelaDeProcessos.getTabela().isEmpty()){
        
        if(!listaDeProcessosBloqueados.getLista().isEmpty()) {
        	if(listaDeProcessosBloqueados.getPrimerioElementoDaLista().getTempoDeEspera() == 0){
        		ElementoDaLista novoProcessoPronto = listaDeProcessosBloqueados.removerPrimeiroElemento();
        		listaDeProcessoProntos.adicionarNoFinal(novoProcessoPronto);
        	}
        }
        
        listaDeProcessosBloqueados.decrementarTempoDeEspera();
        
            if (listaDeProcessoProntos.estaVazia()){
                //System.out.println("Chegou aqui<<");
                listaDeProcessosBloqueados.decrementarTempoDeEspera();
            }
            BlocoDeControleDeProcessos blocoTemporario = listaDeProcessoProntos.getPrimeiroProcesso();
            String instrucaoAtual = blocoTemporario.getInstrucaoAtual();
            System.out.println("PROCESSO: " + blocoTemporario.getNomeDoPrograma());
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
                    break;
                }
                
                contadorQuantum++;
                blocoTemporario.incrementarPC();
                instrucaoAtual = blocoTemporario.getInstrucaoAtual();

            }
            if (instrucaoAtual.equals("SAIDA")) {
                System.out.println("== SAIDA! ==");
                tabelaDeProcessos.eliminarDaTabela(blocoTemporario);
                listaDeProcessoProntos.removerPrimeiroElemento();
                //manda pro log
                //remove das lista prontos
                //contadorTrocas ++ 
            }

            if (ultimaInstrucaoES.equals("E/S")){
                System.out.println("Ultima instrucao foi E/S");
            } else{
                ElementoDaLista elementoTemporario = listaDeProcessoProntos.getPrimerioElementoDaLista();
                listaDeProcessoProntos.removerPrimeiroElemento();
                listaDeProcessoProntos.adicionarNoFinal(elementoTemporario);
            }
            
            
        //System.out.println(tabelaDeProcessos.toString());
        }
        System.out.println("FIm");

    }//escalonamento


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
