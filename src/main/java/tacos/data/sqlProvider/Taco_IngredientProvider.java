package tacos.data.sqlProvider;

import org.apache.ibatis.jdbc.SQL;
import tacos.pojo.entity.Taco;

public class Taco_IngredientProvider {
    public String saveTaco(Taco taco){
        StringBuilder sql= new StringBuilder("Insert into taco_ingredient(taco_id,ingredient_id) values");
        int flag=0;
        for(String id:taco.getList()){
            if(flag==1){
                sql.append(",");
            }
            flag=1;
            sql.append("(").append("'").append(taco.getId()).append("'").append(",").append("'").append(id).append("'").append(")");
        }
        return sql.toString();
    }

}
