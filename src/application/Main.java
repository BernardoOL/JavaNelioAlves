package application;


import java.io.*;

public class Main {
    public static void main(String[] args) {
        String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};

        String path = "C:\\temp\\out.txt";//Colocar o caminho do seu arquivo

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){//Tire o ", true" caso queira recriar o arquivo ao invés de adicionar conteúdo dentro dele

            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

//LER O ARQUIVO
//        String path = "C:\\temp\\in.txt";//Colocar o caminho do seu arquivo
//
//        try (BufferedReader br = new BufferedReader(new FileReader(path))){
//            String line = br.readLine();
//
//            while(line != null){
//                System.out.println(line);
//                line = br.readLine();
//            }
//
//        }catch (IOException e){
//            System.out.println(e.getMessage());
//        }