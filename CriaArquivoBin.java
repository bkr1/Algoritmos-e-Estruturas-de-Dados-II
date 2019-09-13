package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;

public class Pratica02
{
    public static void main(String[] args) 
    {
        Random rand = new Random();
        File arquivo = new File("pratica01.bin");
        int tamanho = rand.nextInt(50000);
        
        if(tamanho <= 10000)
            while(tamanho <= 10000)
                tamanho = rand.nextInt(50000);
        
        ArrayList<Integer> vetor = new ArrayList<>();
        int chance, vezesRept;
        
        System.out.println("Tamanho do vetor: " + tamanho);
        
        for(int i = 0; i < tamanho; i++)
        {
            vetor.add(rand.nextInt(50));
            chance = rand.nextInt(3);
            
            if(chance == 1)
            {
                vezesRept = rand.nextInt(50);
                for(int j = 0; j < vezesRept; j++)
                {
                    vetor.add(i, vetor.get(i));
                    i++;
                }
            }
        }
        try(OutputStream fw = new FileOutputStream(arquivo))
        {
            for(int i = 0; i < vetor.size(); i++)
            {
                System.out.print(vetor.get(i) + " ");
                fw.write(vetor.get(i));
                fw.flush();
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }   
    }
}
