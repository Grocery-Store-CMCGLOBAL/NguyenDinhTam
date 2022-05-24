import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bill {
    private Product product;
    private int numberOfProduct;
    private int totalPriceProduct;
}