package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        File arquivoOriginal = new File("mensagem.txt");
        
        System.out.println("Informe a frase a ser criptografada: ");
        String mensagem = scan.nextLine();
        
        try(FileWriter escritor = new FileWriter(arquivoOriginal))
        {
            escritor.write(mensagem);
            escritor.flush();
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        
        try
        {
            FileReader reader = new FileReader(arquivoOriginal);
            BufferedReader leitor = new BufferedReader(reader);
            String linha = "";
            
            while(leitor.ready())
            {
                linha = leitor.readLine();
                if(linha == null)
                    break;
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        char[] mensagemCriptografada = new char[mensagem.length()];
        String chave;
        File arquivoCriptografado = new File("arquivoCrip.txt");
        
        System.out.println("\nInforme a chave: ");
        chave = scan.nextLine();
        
        int dif;
        
        int j = 0;
        for(int i = 0; i < mensagemCriptografada.length; i++)
        {
            dif = (int)chave.charAt(j) + (int)mensagem.charAt(i);
            
            if(dif > 127)
                mensagemCriptografada[i] = (char)(dif - 127);
            else
                mensagemCriptografada[i] = (char)dif;
            if (j == chave.length() - 1)
                j = 0;
            
            j++;
        }
        
        try(FileWriter escritor = new FileWriter(arquivoCriptografado))
        {
            escritor.write(String.valueOf(mensagemCriptografada));
            escritor.flush();
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        
        try
        {
            FileReader reader = new FileReader(arquivoCriptografado);
            BufferedReader leitor = new BufferedReader(reader);
            String linha = "";
            
            while(leitor.ready())
            {
                linha = leitor.readLine();
                if (linha == null)
                    break;
            }
            
            System.out.println("Mensagem criptografada: " + linha);
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
