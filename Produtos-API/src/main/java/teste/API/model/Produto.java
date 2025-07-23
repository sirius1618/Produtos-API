package teste.API.model;

public class Produto {
    private String id;
    private String nome;
    private String descricao;
    private Double peco;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPeco() {
        return peco;
    }

    public void setPeco(Double peco) {
        this.peco = peco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", peco='" + peco + '\'' +
                '}';
    }
}
