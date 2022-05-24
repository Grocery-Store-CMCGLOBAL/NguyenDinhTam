import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    private static List<Product> listProductOfStore = new ArrayList<>();
    private static Invoice invoice = new Invoice();

    public static void main(String[] args) {
        initialData();
        showMenu();
        List<Bill> bills = new ArrayList();
        invoice.setBills(bills);
        invoice.setTotalBill(0);
        int option = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            switch(option) {
                case 1:
                    productPayment();
                    showMenu();
                    break;
                case 2:
                    printInvoice(invoice);
                    showMenu();
                    invoice = new Invoice();
                    bills = new ArrayList();
                    invoice.setBills(bills);
                    invoice.setTotalBill(0);
                    break;
                case 3:
                    System.out.println("Bye Bye");
                    break;
                default:
                    System.out.println("Invalid input parameters");
                    showMenu();
            }
        }while(option != 3);

    }



    //method to initialize a product list for the store
    private static List<Product> initialData(){

// products sold by piece code||name||type||price||description||isPromotion||typePromotion||descriptionPromotion
        Product chips = new Product("001", "chips", "piece", 35, "sold by piece", true, 1, "Buy one, get one free", "bag");
        Product toothpasteTube = new Product("002", "toothpaste tube", "piece", 45, "sold by piece", true, 2, "Buy two, get one free", "bag");
        Product cigarettePacks = new Product("003", "cigarette packs", "piece", 10, "sold by piece", false, 0, "No Promotion", "bag");

// products sold in bulk
        Product rice = new Product("004", "rice", "bulk", 45, "sold in bulk", true, 1, "Buy one, get one free", "kilograms");
        Product apple = new Product("005", "apple", "bulk", 20, "sold in bulk", true, 2, "Buy two, get one free", "kilograms");
        Product orange = new Product("006", "orange", "bulk", 25, "sold in bulk", false, 0, "No Promotion", "kilograms");

        listProductOfStore.add(chips);
        listProductOfStore.add(toothpasteTube);
        listProductOfStore.add(cigarettePacks);
        listProductOfStore.add(rice);
        listProductOfStore.add(apple);
        listProductOfStore.add(orange);

        return listProductOfStore;
    }

    //method to show the menu for seller
    private static void showMenu(){

        System.out.println("=========Select the feature below=========");
        System.out.println("== ==");
        System.out.println("== [1] Product payment ==");
        System.out.println("== [2] Print Receipt ==");
        System.out.println("== [3] Shutdown ==");
        System.out.println("== ==");
        System.out.println("==========================================");
        System.out.println("Please enter your selection:");
        System.out.println("");

    }

    //logic product payment
    private static void productPayment() {
        Product product = new Product();
        String code = getProductCode();
        boolean checkProduct = false;
        do {
            for(Product item : listProductOfStore) {
                if(code.equals(item.getCode())) {
                    checkProduct = true;
                    product = item;
                    break;
                }
            }
            if(!checkProduct) {
                System.out.println("product code not exist. Please enter the correct product code.");
                code = getProductCode();
            }
        }while (!checkProduct);

        showInfoProduct(product);

        int numberOfProduct = 0;
        int numberOfProductPromotion = 0;
        if(product.getType().equals("piece")) {
            //sold by piece => input number of pieces
            numberOfProduct = getNumberOfPieces();
        }else {
            //sold in bulk
            numberOfProduct = getNumberOfKilograms();
        }
        Bill bill = new Bill();
        bill.setProduct(product);
        if(product.isPromotion()){
            if(product.getTypePromotion() == 1) {
                //buy one, free one
                numberOfProductPromotion = numberOfProduct;

            }else {
                //buy two, free one
                numberOfProductPromotion = numberOfProduct/2;
            }
        }
        bill.setNumberOfProduct(numberOfProduct + numberOfProductPromotion);
        bill.setTotalPriceProduct(numberOfProduct*product.getPrice());
        invoice.getBills().add(bill);
        invoice.setTotalBill(invoice.getTotalBill() + numberOfProduct*product.getPrice());
        System.out.println("Payment " + product.getName() + " successfully");
    }

    //method to get product code
    private static String getProductCode() {
        System.out.println("Enter product code:");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        return code;
    }

    //method to get number of pieces
    private static int getNumberOfPieces() {
        System.out.println("Enter Number Of Pieces:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }

    //method to get number of pieces
    private static int getNumberOfKilograms() {
        System.out.println("Enter Number Of Kilograms:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }

    private static void showInfoProduct(Product product) {
        System.out.println("- Your Product: " + product.getName() + " - Type: " + product.getDescription());
        System.out.println("- It has price: " + product.getPrice() + " pesos/" + product.getUnit());
        if(product.isPromotion()) {
            System.out.println("- This product is on sale: " + product.getDescriptionPromotion());
        }
    }

    //print Invoice
    private static void printInvoice(Invoice invoice) {
        invoice.printInvoice();
    }

}