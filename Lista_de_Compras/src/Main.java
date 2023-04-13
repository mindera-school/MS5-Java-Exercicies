import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> categoryList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> productList = new ArrayList<>();
        String backMenu = "0";
        String category;

        while (backMenu.equals("0")) {
            System.out.println("1 ---- Create a new category");
            System.out.println("2 ---- Show existent category");
            System.out.println("3 ---- Create a new product");
            System.out.println("4 ---- Show Product's");
            System.out.println("5 ---- Show Product's by category");
            System.out.println("6 ---- Show Total Cost of product's by category");
            System.out.println("7 ---- Quit");
            System.out.println();


            System.out.println("What Option");
            String option = scanner.next();
            switch (option) {
                case "1":
                    String newCategory;
                    System.out.println("Write the new Category");
                    newCategory = scanner.next();
                    newCategory(categoryList, newCategory);
                    System.out.println();
                    break;
                case "2":
                    showCategory(categoryList);
                    System.out.println();
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case "3":
                    addProduct(productList, categoryList);
                    break;
                case "4":
                    showProduct(productList);
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case "5":
                    showCategory(categoryList);
                    System.out.println();
                    System.out.println("What category product's do you want to see???");
                    category = scanner.next();
                    orgProdByCat(productList, category);
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case "6":
                    showCategory(categoryList);
                    System.out.println();
                    System.out.println("What category total do you want to see???");
                    category = scanner.next();
                    totalByCat(productList, category);
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case "7" :
                    do {
                        System.out.println("Are you sure of that???");
                        System.out.println();
                        System.out.println("1 -- YES");
                        System.out.println("0 -- NO");
                        backMenu = scanner.next();
                    } while (!backMenu.equals("1") && !backMenu.equals("0"));
                default:
            }
        }

    }

    public static void newCategory(ArrayList<String> categoryList, String newCategory) {
        Scanner scanner = new Scanner(System.in);

        if (newCategory.isBlank()) {
            System.out.println("ERROR --- This category is empty, noob");
        } else {
            boolean existCat = false;
            for(String s : categoryList) {
                if(s.equals(newCategory)){
                    System.out.println("Already existent category");
                    existCat = true;
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                }
            }
            if(!existCat){
                categoryList.add(newCategory);
            }
        }
    }

    public static void showCategory(ArrayList<String> categoryList){
        System.out.println();
        System.out.println("[");
        for (String s : categoryList) {
            System.out.println(s + ",");
        }
        System.out.println("]");
        System.out.println();
    }

    public static void addProduct(ArrayList<Product> productList, ArrayList<String> categoryList){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the name of the Product??");
        String name = scanner.nextLine();
        System.out.println("What category do you wanna add???");
        String category = scanner.nextLine();
        newCategory(categoryList,category);
        System.out.println("How many do you wanna add???");
        int quantity = scanner.nextInt();
        System.out.println("How much that's cost???");
        double price = scanner.nextFloat();
        price = Double.parseDouble(String.format("%.2f", price));

        Product newProduct = new Product(name, category, quantity, price);
        productList.add(newProduct);
    }

    public static void showProduct(ArrayList<Product> productList){
        for (Product p : productList){
            System.out.println("||===============||");
            System.out.println("||    Product    ||");
            System.out.println("||===============||");
            System.out.println("||      Name     ||---> " + p.name);
            System.out.println("||---------------||");
            System.out.println("||    Category   ||---> " + p.category);
            System.out.println("||---------------||");
            System.out.println("||    Quantity   ||---> " + p.quantity);
            System.out.println("||---------------||");
            System.out.println("||      Price    ||---> " + p.price + "$");
            System.out.println("||===============||");
        }
    }

    public static void orgProdByCat(ArrayList<Product> productList, String category){
        for (Product p : productList){
            if (p.category.equals(category)){
                System.out.println("||===============||");
                System.out.println("||    Product    ||");
                System.out.println("||===============||");
                System.out.println("||      Name     ||---> " + p.name);
                System.out.println("||---------------||");
                System.out.println("||    Category   ||---> " + p.category);
                System.out.println("||---------------||");
                System.out.println("||    Quantity   ||---> " + p.quantity);
                System.out.println("||---------------||");
                System.out.println("||      Price    ||---> " + p.price + "$");
                System.out.println("||===============||");
            }
        }
    }

    public static void totalByCat(ArrayList<Product> productList, String category){
        double total = 0;

        for(Product p : productList){
            if(p.category.equals(category)){
                total += p.price * p.quantity;
            }
        }

        System.out.println();
        System.out.println("Total of " + category + " : " + total);
    }
}