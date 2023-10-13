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
            System.out.println("== CHEGUEI AQUI ==");
            
            if (listaDeProcessoProntos.estaVazia()){
                listaDeProcessosBloqueados.decrementarTempoDeEspera();

                if(listaDeProcessosBloqueados.getPrimerioElementoDaLista().getTempoDeEspera() == 0){
                    ElementoDaLista novoProcessoPronto = listaDeProcessosBloqueados.removerPrimeiroElemento();
                    listaDeProcessoProntos.adicionarNoFinal(novoProcessoPronto);
                }
                else
                    continue;
            }

            BlocoDeControleDeProcessos blocoTemporario = listaDeProcessoProntos.getPrimeiroProcesso();
            String instrucaoAtual = blocoTemporario.getInstrucaoAtual();
            
            int contadorQuantum = 0;
            while(contadorQuantum < quantum && instrucaoAtual != "SAIDA"){
            
                if (instrucaoAtual.equals("E/S") ) {
                    ElementoDaLista elementoTemporario = listaDeProcessoProntos.removerPrimeiroElemento();
                    listaDeProcessosBloqueados.adicionarNoFinal(elementoTemporario);

                    blocoTemporario.incrementarPC();
                    logInstrucoesES ++;
                    break;
                }
                
                contadorQuantum++;
                blocoTemporario.incrementarPC();
                instrucaoAtual = blocoTemporario.getInstrucaoAtual();
            }
                
            if (instrucaoAtual.equals("SAIDA")) {
                
                tabelaDeProcessos.eliminarDaTabela(blocoTemporario);
                //manda pro log
                //remove das lista prontos
                //contadorTrocas ++ 
            }
            
        //System.out.println(tabelaDeProcessos.toString());
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

        Path arquivo1 = Paths.get("./processos/quantum.txt");
        try{
            List<String> quantumStr = Files.readAllLines(arquivo1);
            return Integer.parseInt(quantumStr.get(0));

         } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler o arquivo quantum.txt");
        }
        
    }

}
