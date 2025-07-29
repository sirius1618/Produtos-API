package teste.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.API.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

}
