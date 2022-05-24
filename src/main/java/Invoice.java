import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Invoice {
    private List<Bill> bills;
    private int totalBill;



    public Invoice() {
    }

    public Invoice(List<Bill> bills, int totalBill) {
        super();
        this.bills = bills;
        this.totalBill = totalBill;
    }

    public void printInvoice() {
        System.out.println("=========Your Invoice=========");
        for (Bill item : bills) {
            Product productDetail = item.getProduct();
            System.out.println(productDetail.getName() + " - Amount: " + item.getNumberOfProduct() + " - Price: " + item.getTotalPriceProduct());
        }
        System.out.println("Total Invoice: " + this.totalBill);
        System.out.println("=========Thank you=========");
    }
}