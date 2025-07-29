package teste.API.controler;

import org.springframework.web.bind.annotation.*;
import teste.API.model.Produto;
import teste.API.repository.ProdutoRepository;

import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto recebido" + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);

        return produto;
    }

    @GetMapping("{id}")
    public Produto obtterProdutoId(String Id) {

    }
}
