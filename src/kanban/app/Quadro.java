package kanban.app;

import java.util.ArrayList;

public class Quadro {
    private int id;
    private String nome;
    private ArrayList<Lista> listas;

    public Quadro(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.listas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Lista> getListas() {
        return listas;
    }
}
