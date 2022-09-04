package tacos.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ASUS
 * 2022/8/23
 * 19:11
 */
@Data
@Entity
@Table(name = "tacoorder")
public class Order {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "consignee")
    private String consignee;
    @Column(name = "delivery_address")
    private String deliveryAddress;
    @Column(name = "remarks")
    private String remarks;


}
