/*
    Autor: Lucas Novais da Silva
    Curso: Engenharia de Computacao 
    Matricula: 18.1.8046
*/

package com.src.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CriaFrasesTxt 
{
    public static void main(String[] args)
    {
        ArrayList<String> listaFrases = new ArrayList<>();
        listaFrases.add("");
        Scanner scan = new Scanner(System.in);
        
        int i = 0;
        
        File arquivo = new File("C:\\Users\\HP\\Desktop\\Lucas\\Aulas\\Quarto Período\\A.E.Ds II\\Files\\Frases.txt");
        
        System.out.println("----- ESCRITOR DE FRASES -----\n\n" + 
                "ATENCAO: Para finalizar, digite a palavra 'ENVIAR'!");
        
        try(FileWriter fw = new FileWriter(arquivo))
        {
            BufferedWriter writer = new BufferedWriter(fw);
            
            writer.write("FRASES ESCRITAS: ");
            writer.flush();
            writer.newLine();
            writer.newLine();
            
            while(!listaFrases.get(i).equals("ENVIAR"))
            {
                i++;
                
                System.out.println("\nInforme uma frase: ");
                listaFrases.add(scan.nextLine());
                
                if(!listaFrases.get(i).equals("ENVIAR"))
                {
                    writer.write(listaFrases.get(i));
                    writer.flush();
                    writer.newLine();
                }
            }
        }catch(IOException ex)
        {
            System.out.println("ATENCAO: Problema ao criar/manipular o arquivo!");
            
            ex.printStackTrace();
        }
    }
}
