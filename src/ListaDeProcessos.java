import java.util.ArrayList;
import java.util.List;

public class ListaDeProcessos {

    public List<ElementoDaLista> lista;


    ListaDeProcessos(){
        this.lista = new ArrayList<>();
    }


    public boolean estaVazia(){
        if(lista != null && lista.isEmpty()) return true;
        return false;
    }


    public boolean adicionarNoFinal(ElementoDaLista elemento){
        return lista.add(elemento);
    }


    public ElementoDaLista removerPrimeiroElemento(){
        return lista.remove(0);
    }



    public List<ElementoDaLista> getLista() {
        return lista;
    }


    public void setLista(List<ElementoDaLista> lista) {
        this.lista = lista;
    }


    public BlocoDeControleDeProcessos getPrimeiroProcesso() {
        
        ElementoDaLista elemento = this.lista.get(0);
        return elemento.getBpc();
    }

    public ElementoDaLista getPrimerioElementoDaLista(){
        return this.getLista().get(0);
    }

    public String toString(){
        return lista.toString();
    }

}