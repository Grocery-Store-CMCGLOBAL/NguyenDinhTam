import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String code;
    private String name;
    private String type;
    private int price;
    private String description;
    private boolean isPromotion;
    private int typePromotion;
    private String descriptionPromotion;
    private String unit;

    public Product() {

    }

    public Product(String code, String name, String type, int price, String description, boolean isPromotion,
                   int typePromotion, String descriptionPromotion, String unit) {
        super();
        this.code = code;
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
        this.isPromotion = isPromotion;
        this.typePromotion = typePromotion;
        this.descriptionPromotion = descriptionPromotion;
        this.unit = unit;
    }

}