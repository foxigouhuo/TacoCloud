package tacos;

import lombok.Data;
import tacos.Taco;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * ASUS
 * 2022/8/23
 * 19:11
 */
@Data
@Entity
public class Order {
    @Id
    private int id;
    private String consignee;
    private String deliveryAddress;
    private String remarks;
    @ManyToMany(targetEntity = Taco.class)
    private List<Integer> tacoIds=new ArrayList<>();

    public void addTaco(Integer tacoId){
        tacoIds.add(tacoId);
    }
}
