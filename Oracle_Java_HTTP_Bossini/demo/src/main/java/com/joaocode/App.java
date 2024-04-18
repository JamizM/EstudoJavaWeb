package com.joaocode;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.io.FileInputStream; //leitor de arquivo
import java.util.Properties;


public class App {
    public static void main(String[] args) throws Exception {
        //!clicar em "run" em cima da "main" para ver rodar
        //jogamos um thows exception pois como mexemos com requisicoes http, podemos ter erros ocorrendo = recursos externos
        
        Properties properties = new Properties();
        properties.load(new FileInputStream("Oracle_Java_HTTP_Bossini/demo/src/main/java/com/joaocode/settings.properties"));

        PessoaService service = new PessoaService(properties.getProperty("URL")); //? instanciamos um PessoaService passando a ele a URL obtida do properties
        service.listar();

        // int op;
        // String menu = "1-Cadastrar\n2-Atualizar\n-3-Listar\n4-Remover\n0-Sair";
        // do{
        //     op = parseInt(showInputDialog(menu));
        //     switch(op){
        //         case 1:{        
        //             break;
        //         }
        //         case 2:{
        //             break;
        //         }
        //         case 3:{
        //             break;
        //         }
        //         case 4:{
        //             break;
        //         }
        //         case 0:{
        //             showMessageDialog(null, "Até mais");
        //             break;
        //         }
        //         default:{
        //             showMessageDialog(null, "Opção inválida");
        //             break;
        //         }
        //     }
        // }while (op != 0);
    }
}
