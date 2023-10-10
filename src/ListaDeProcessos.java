import java.util.List;

public class ListaDeProcessos {

    public List<ElementoDaLista> lista;

    ListaDeProcessos(){
        
    }

    public boolean estaVazia(){
        if(lista != null && lista.isEmpty()) return true;
        return false;
    }

    public boolean adicionarNoFinal(){
        return false;
    }

    public List<ElementoDaLista> getLista() {
        return lista;
    }

    public void setLista(List<ElementoDaLista> lista) {
        this.lista = lista;
    }

}