import javax.persistence.*;

@Entity
@DiscriminatorValue("percentage")
public class PercentageDiscount implements Discount {
    // Fields and methods
}
