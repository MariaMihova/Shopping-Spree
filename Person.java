import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
   private String name;
   private double money;
   private List<Product> products;

   public Person (String name, double money){
       this.setName(name);
       this.setMoney(money);
       this.products = new ArrayList<>();
   }

   private void setName(String name){
       if(name == null || name.trim().isEmpty()){
           throw new IllegalArgumentException("Name cannot be empty");
       }
       this.name = name;
   }

   public String getName(){
       return this.name;
   }

   private void setMoney(double money){
       if(money < 0){
           throw new IllegalArgumentException("Money cannot be negative");
       }
       this.money = money;
   }

   public double getMoney(){
       return this.money;
   }


   //buyProduct (Product) : void
    public void buyProduct(Product product){
        if(this.getMoney() >= product.getCost()){
            this.setMoney(this.getMoney() - product.getCost());
            this.products.add(product);
        }else {
            String message = String.format("%s can't afford %s", this.getName(), product.getName());
            throw new IllegalArgumentException(message);
        }
    }

  /*  @Override
    public int compareTo(Person person) {
        String  first = this.name;
        String second = person.getName();
        for (int i = 0; i < first.length() &&
                i < second.length(); i ++){
            char currentFirst = first.charAt(i);
            char currentSecond = second.charAt(i);
            if(currentFirst != currentSecond){
                return currentFirst - currentSecond;
            }
        }
        if (first.length() < second.length()) {
            return 1;
        } else if(second.length() < first.length()) {
            return -1;
        }

        int ageOne = this.age;
        int ageTwo = person.getAge();
        if(ageOne < ageTwo){
            return 1;
        }else if(ageTwo < ageOne){
            return 1;
        }


        return 0;
    }*/

    @Override
    public String toString(){
        StringBuilder fill = new StringBuilder();
        fill.append(this.getName()).append(" - ");
        if(this.products.isEmpty()){
            fill.append("Nothing bought");
        }else {
            fill.append(this.products.stream()
            .map(Product::getName)
            .collect(Collectors.joining(", ")));
        }
        return fill.toString();
    }
}
