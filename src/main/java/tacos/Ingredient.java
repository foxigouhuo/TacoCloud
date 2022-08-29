package tacos;


import lombok.Data;

/**
 * ASUS
 * 2022/8/20
 * 18:36
 */
@Data
public class Ingredient {
    private int id;
    private String name;
    private Type type;

    public Ingredient(int id,String name, Type type) {
        this.id=id;
        this.name = name;
        this.type = type;
    }

    //配料类型
    public static enum Type{WRAP,PROTEIN,VEGGIES,CHEESE,SAUCE};

}
