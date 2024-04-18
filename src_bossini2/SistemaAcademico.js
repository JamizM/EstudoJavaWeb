//importa os módulos http e express
const http = require('http');
const express = require('express');

//constrói um objeto express
const app = express();

//importa o body-parser
const bodyParser = require('body-parser');//permite o processamento de dados do corpo das requisições, usado para analisar o corpo das requisições HTTP e converter os dados em um formato adequado para manipulação no servidor.
app.use(bodyParser.json());


let id = 1;
let alunos = [
    {
        id: 1,
        nome: "João",
        fone: "11223344",
        email: "joao@email.com"
    },
    {
        id: 2,
        nome: "Maria",
        fone: "55221133",
        email: "maria@email.com"
    }
];

app.post ("/alunos", (req, res, next) => {
    const aluno = {
        id: id +=1, //id ira aumentar mais 1 quando novo aluno fotr inserido
        nome: req.body.nome,
        fone: req.body.fone,
        email: req.body.email
    }
    alunos.push(aluno)
    res.status(201).json(aluno);
});

app.get("/alunos", (req, res, next) => {
    res.status(200).json(alunos);
})

app.put("/alunos", (req, res, next) => {
    alunos.forEach((aluno) => {
        if (aluno.id === req.body.id){
            aluno.fone = req.body.fone
        }
    })
    res.status(204).end();
})

app.delete("/alunos", (req, res, next) => {
    const alunoId = parseInt(req.body.id); //ira pegar o id
    const index = alunos.findIndex(aluno => aluno.id === alunoId);
    if (index !== -1) {
        alunos.splice(index, 1); //splice - remove elemento do array
        res.status(204).end();
    } else {
        res.status(404).json({ message: "Aluno nao encontado" });
    }
}); //!remocao ira acontecer com o id do aluno

//configura a porta do servidor e o coloca em execução.
const porta = 3000;
app.set('port', porta);
const server = http.createServer(app);
server.listen(3000) //sendo feito na porta 3000