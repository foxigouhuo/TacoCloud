package tacos.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;


import java.util.ArrayList;
import java.util.List;

/**
 * ASUS
 * 2022/8/23
 * 19:11
 */
@Data
@Alias("order")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String id;
    private List<Taco> list=new ArrayList<>();
    private String name;
    private String info;

    public Order(String toString, String name, String o) {
        this.id=toString;
        this.name=name;
        this.info=o;
    }

    public void addTaco(Taco taco){
        list.add(taco);
    }

}
