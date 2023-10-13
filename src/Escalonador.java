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

    private Integer quantum;
    private TabelaDeProcessos tabelaDeProcessos;
    private ListaDeProcessosProntos listaDeProcessoProntos;
    private ListaDeProcessosBloqueados listaDeProcessosBloqueados;

    Escalonador(){
        quantum = this.definirQuantum();
        listaDeProcessoProntos = new ListaDeProcessosProntos();
        listaDeProcessosBloqueados = new ListaDeProcessosBloqueados();
        tabelaDeProcessos = criarTabelaDeProcessos();
        listaDeProcessoProntos.carregarProcessos(tabelaDeProcessos.getTabela());
    }


    public void Escalonamento(){
        while(!tabelaDeProcessos.getTabela().isEmpty()){
            
            if (listaDeProcessoProntos.estaVazia()){
                listaDeProcessosBloqueados.decrementarTempoDeEspera();

                if(listaDeProcessosBloqueados.getPrimerioElementoDaLista().getTempoDeEspera() == 0){
                    ElementoDaLista novoProcessoPronto = listaDeProcessosBloqueados.removerPrimeiroElemento();
                    listaDeProcessoProntos.adicionarNoFinal(novoProcessoPronto);
                }
                else
                    break;
            }

            BlocoDeControleDeProcessos blocoTemporario = listaDeProcessoProntos.getPrimeiroProcesso();
            String instrucaoAtual = blocoTemporario.getInstrucaoAtual();

            int contadorQuantum = 0;
            while(contadorQuantum < quantum && instrucaoAtual != "SAIDA"){
            
                if (instrucaoAtual == "E/S") {
                    ElementoDaLista elementoTemporario = listaDeProcessoProntos.removerPrimeiroElemento();
                    listaDeProcessosBloqueados.adicionarNoFinal(elementoTemporario);

                    logInstrucoesES ++;
                    break;
                }
                
                contadorQuantum++;
                blocoTemporario.incrementarPC();
                instrucaoAtual = blocoTemporario.getPrograma().get(blocoTemporario.getPC());
            }

            if (instrucaoAtual == "SAIDA") {
                tabelaDeProcessos.eliminarDaTabela(blocoTemporario);
                //manda pro log
                //remove das lista prontos
                //contadorTrocas ++ 
            }

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
        String diretorioAtual = System.getProperty("user.dir");
        Path arquivo1 = Paths.get(diretorioAtual, "quantum.txt");
        try{
            List<String> quantumStr = Files.readAllLines(arquivo1);
            Integer quantum = Integer.parseInt(quantumStr.get(0));
            System.out.println(quantum);

         } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler o arquivo quantum.txt");
        }
        
        return 0;
    }

}

    /*
     
//le aqrquivo

//cria tabela e listas
TabelaDeProcessos tabela = new TabelaDeProcessos();
ListaDeProcessosProntos ProcessosProntos = new ListaDeProcessosProntos();  
ListaDeProcessosBloqueados ProcessosBloqueados = new ListaDeProcessosBloqueados();  

    //percorre arquivos criando bloco de processos e adicionando na lista prontos
    String nomearq = "";
    for(int i = 1; i <= 10; i++){
        if(i == 10){ 
            nomearq = "./10.txt";
        } else{
            nomearq = "./0" + i + ".txt";
        }

        BlocoDeControleDeProcessos bcp = new BlocoDeControleDeProcessos(nomearq);
        tabela.adicionarNaTabela(bcp);
        ProcessosProntos.adicionarNoFinal(bcp);
    }

while(tabela != null){
    
    
//precisa ler o quantum.txt??
if (ProcessosProntos.estaVazia()){
	ProcessosBloqueados.decrementarTempoDeEspera();
	if(contador == 0){
        break; //encerra escalonador
	}
}

BlocoDeControleDeProcessos blocotemp = lista.getPrimeiroProcesso();

while(contador < quantum && instrucao != "SAIDA"){
	//exec linha atual
	  
	  
	if (comando == E/S) {
		//tira da lista prontos;
		ProcessosBloqueados.adicionarNoFinal(blocotemp);
		instrucoesES ++;
		break;//sai desse laço ainda fica dentro do outro, exe
		}
	

		}//laco1

//coloca processo no final da fila prontos
if (comando == "SAIDA") {
//manda pro log
//remove das lista prontos
tabela.eliminarDaTabela(blocotemp);
//contadorTrocas ++ 
}

//contador bloqueados
ProcessosBloqueados.decrementarTempoDeEspera();
if(contador bloqueado == 0) {
//remove lista bloqueado
ProcessosProntos.adicionarNoFinal(blocotemp);
}

valor_total=+contador;
iterações++;
//reseta contador


	}//laco2
/*LOGS
''log media de trocas = numero de vezes que foi interrompido e última vez que rodou
''log media de instrucoes = valor total de instrucoes / iteracoes por teste
''Quantidade de instrucoes E/S = contador de toda vez que um teste vai pra lista de bloqueados
*/
