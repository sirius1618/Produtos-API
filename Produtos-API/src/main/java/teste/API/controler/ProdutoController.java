package teste.API.controler;

import org.springframework.web.bind.annotation.*;
import teste.API.model.Produto;
import teste.API.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;
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

        // Antes de sauvar eu tenho que setar meu ID
        var id = UUID.randomUUID().toString();
        produto.setId(id);

        // Recebendo esse produto do postman:
        produtoRepository.save(produto);

        return produto;
    }

    // estou dizendo que vai usar esse parametro para pegar meu dados
    @GetMapping("/{id}")

    public Produto obterPorId(@PathVariable("id") String  id) {
        // TODO: como vamos no banco vamos usasr nossa interface (não sei se o nome é interface mesmo) produtoRepository

        // Essas duas linhas buscam o id e se tiver presente retorna o id  e se não retorna null
            // Optional<Produto> produto = produtoRepository.findById(id);
            // return produto.isPresent() ? produto.get() : null;

        // forma mais simplificada de escrever o que esta a cima
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletPorId(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }

    // significa que o cliente envia um JSON no corpo da requisição, e o Spring
        // converte para o objeto Produto.
    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id,
                          @RequestBody Produto produto) {
       produto.setId(id);
       // vamos usar o mesmo metodo porque se ja tivermos um produto com esse id ele
        // apenas sera atualizado:
       produtoRepository.save(produto);
    }


    // Não vamos passar parametros porque queremos buscar apatir da raiz
    @GetMapping
    // Usamos a anotação @RequestParam para popularmos nossa variavel com o valor da
    // variavel com o parametro da nossa requisicao. Podemos colocar varios parametro
    // precisando separar apenas por virgulas.
    public List<Produto> buscar(@RequestParam("nome") String nome){
        return produtoRepository.findByNome(nome);
    }
}
