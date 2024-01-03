package application;


import model.Produto;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Produto> list = new ArrayList<>();

        System.out.println("Enter file path: ");
        String sourceFileStr = sc.nextLine();

        File sourceFile = new File(sourceFileStr);

        String sourceFolderStr = sourceFile.getParent();

        boolean sucecess = new File(sourceFolderStr + "\\out").mkdir();

        System.out.println("Directory created: " + sucecess);

        String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){

            String itemCsv = br.readLine();
            while (itemCsv != null){
                String[] fields = itemCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                list.add(new Produto(name, price, quantity));

                itemCsv = br.readLine();
            }

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){

                for(Produto item : list){
                    bw.write(item.getName() + "," + String.format("%.2f", item.total()));
                    bw.newLine();
                }

                System.out.println(targetFileStr + " CREATED!");

            }catch (IOException e){
                System.out.println("Erro writing file: " + e.getMessage());
            }

        }catch (Exception e){
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}