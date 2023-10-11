public class Escalonador{
    public static void main(String[] args){
        
    }
Escalonador(){

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
/* lista.getPrimeiroProcesso();*/

//precisa ler o quantum.txt??
while(contador < quantum && instrucao != "SAIDA"){
    if (ProcessosProntos.estaVazia()){
        ProcessosBloqueados.decrementarTempoDeEspera();
    if(contador == 0){
        break; //encerra escalonador
    }
        
    
}







}
}
}
