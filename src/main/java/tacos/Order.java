package tacos;

import lombok.Data;
import tacos.Taco;

import java.util.ArrayList;
import java.util.List;

/**
 * ASUS
 * 2022/8/23
 * 19:11
 */
@Data
public class Order {
    private int id;
    private String consignee;
    private String deliveryAddress;
    private String remarks;
    private List<Integer> tacoIds=new ArrayList<>();

    public void addTaco(Integer tacoId){
        tacoIds.add(tacoId);
    }
}
