package tacos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ASUS
 * 2022/8/20
 * 18:36
 */
@Data
public class Taco {
    private int id;
    private String name;
    private List<String> ingredients;

}
