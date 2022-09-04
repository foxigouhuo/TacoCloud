package tacos.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ASUS
 * 2022/8/20
 * 18:36
 */
@Data
@Entity
public class Taco {
    @Id
    private String id;
    private String name;


}
