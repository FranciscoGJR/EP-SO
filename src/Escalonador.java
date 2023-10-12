public class Escalonador{
    public static void main(String[] args){
        
    }
Escalonador(){
/*Valores logs*/
int valor_total = 0;
int iteracoes = 0;
int instrucoesES = 0;
//	
int quantum = 3;
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
BlocoDeControleDeProcessos blocotemp = lista.getPrimeiroProcesso();


//precisa ler o quantum.txt??
if (ProcessosProntos.estaVazia()){
	ProcessosBloqueados.decrementarTempoDeEspera();
	if(contador == 0){
		break; //encerra escalonador
	}
}
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
}//escalonador
