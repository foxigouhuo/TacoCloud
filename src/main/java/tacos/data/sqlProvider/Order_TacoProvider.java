package tacos.data.sqlProvider;

import tacos.pojo.entity.Order;
import tacos.pojo.entity.Taco;

public class Order_TacoProvider {
    public String saveOrder(Order order){
        StringBuilder sql= new StringBuilder("Insert into order_taco values");
        int flag=0;
        for(Taco taco:order.getList()){
            if(flag==1){
                sql.append(",");
            }
            flag=1;
            sql.append("(").append("'").append(order.getId()).append("'").append(",").append("'").append(taco.getId()).append("'").append(")");
        }
        return sql.toString();
    }
}
