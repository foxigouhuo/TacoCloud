package tacos.data.mapper;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import tacos.data.sqlProvider.Order_TacoProvider;
import tacos.pojo.entity.Order;

@Mapper
public interface Order_TacoMapper {

    @InsertProvider(type = Order_TacoProvider.class,method = "saveOrder")
    void saveOrder(Order order);
}
