import javax.persistence.*;

@Entity
@DiscriminatorValue("fixed")
public class FixedDiscount implements Discount {
    // Fields and methods
}
