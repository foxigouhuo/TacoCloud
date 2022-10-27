package tacos.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ASUS
 * 2022/8/20
 * 18:36
 */
@Data
@Alias("taco")
@NoArgsConstructor
@AllArgsConstructor
public class Taco {
    private String id;
    //用来进行接收前端传回来的数据
    private List<String> list=new ArrayList<>();
    private Date createAt;
    private String info;

    public Taco(String toString, Timestamp timestamp, String s) {
        this.id=toString;
        this.createAt=timestamp;
        info=s;
    }
}
