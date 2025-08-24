package teste.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.API.model.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    // Criamos uma propriedade especifica para buscar pelo nome.
    // Isso é um metodo abstrato, precisamos criar assim pois estamos dentro de uma
    // insterface, onde dentro dela não tem implementação.
    List<Produto> findByNome(String nome);

}

