package tacos.data.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tacos.pojo.entity.Order;

@Mapper
@Repository
public interface OrderMapper {

    @Insert("Insert into `order`(id,name,info) values(#{id},#{name},#{info})")
    void saveOrder(Order order);
}
