const http = require('http');
const express = require('express');
const app = express();
const bodyParser = require ('body-parser');
app.use (bodyParser.json());
const porta = 8080;

const clientes = [
    {
    id: 1,
    nome: 'Joao',
    email: 'joao@email.com'
    },
    {
    id: 2,
    nome: 'Cristina',
    email: 'cristina@email.com'
    }
];

let contador = 3; // logo após as instruções require

app.set('port', porta);
app.get("/teste", (req, res, next) => {
    res.send("ola")
});

app.get('/clientes', (req, res, next) => {
    res.json(clientes);
});

app.post('/clientes', (req, res, next) => {
    const cliente = req.body;
    clientes.push({id: contador += 1, nome: cliente.nome, email: cliente.email});
    console.log(clientes);
    res.end();
});

const server = http.createServer(app);
server.listen(8080);