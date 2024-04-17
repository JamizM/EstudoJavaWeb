package controller;

import model.Livro;
import org.springframework.stereotype.Service;
import service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;
    @PostMapping("/salvar")
    public void salvar (@RequestBody Livro livro){
        this.livroService.salvar(livro);
    }
    @GetMapping
    public List<Livro> listar (){
        return this.livroService.listar();
    }
}

