package tacos.data.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tacos.data.sqlProvider.TacoProvider;
import tacos.pojo.entity.Taco;

import java.util.List;

@Mapper
@Repository
public interface TacoMapper {
    @InsertProvider(type = TacoProvider.class,method = "findAll")
    List<Taco> findAll();

    @Insert("Insert into taco(id,createAt,info) values(#{id},#{createAt},#{info})")
    int saveTaco(Taco taco);
}
