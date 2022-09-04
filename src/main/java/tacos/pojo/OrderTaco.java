package tacos.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tacoorder_taco")
public class OrderTaco {

    @Id
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "taco_id")
    private String tacoId;

    public OrderTaco(String orderId, String tacoId) {
        this.orderId=orderId;
        this.tacoId=tacoId;
    }


}
