import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] peopleMoney  = reader.readLine().split(";");
        String[] productsCost = reader.readLine().split(";");

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        for (int i = 0; i < peopleMoney.length; i++) {
            String name = peopleMoney[i].split("=")[0];
            double money = Double.parseDouble(peopleMoney[i].split("=")[1]);
            try {
                Person person = new Person(name, money);
                people.putIfAbsent(name, person);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        for (int i = 0; i < productsCost.length; i++) {
            String name = productsCost[i].split("=")[0];
            double cost = Double.parseDouble(productsCost[i].split("=")[1]);
            try {
                Product product = new Product(name, cost);
                products.putIfAbsent(name, product);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String line = reader.readLine();

        while (!line.equals("END")){
            String name = line.split("\\s+")[0];
            String product = line.split("\\s+")[1];

            if(people.containsKey(name) && products.containsKey(product)){
                try {
                    people.get(name).buyProduct(products.get(product));
                    System.out.printf("%s bought %s%n", people.get(name).getName(), products.get(product).getName());
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

            }

            line = reader.readLine();
        }


        for (Map.Entry<String, Person> person : people.entrySet()) {
            System.out.println(person.getValue().toString());
        }

    }

}