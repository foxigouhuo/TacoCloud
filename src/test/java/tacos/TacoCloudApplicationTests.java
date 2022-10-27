package tacos;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tacos.data.mapper.IngredientMapper;
import tacos.data.service.TacoService;
import tacos.pojo.entity.Ingredient;
import tacos.pojo.entity.Order;
import tacos.pojo.entity.Taco;
import tacos.pojo.enums.IngredientEnum;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@SpringBootTest
class TacoCloudApplicationTests {
    @Autowired
    IngredientMapper ingredientMapper;
    @Autowired
    TacoService tacoService;

    @Test
    public void testOrder(){
        Order order=new Order();
        order.addTaco(new Taco(null,null,null));
    }

    @Test
    public void testTacoService() throws Exception{
        tacoService.saveTaco(new Taco(UUID.randomUUID().toString(),new Timestamp(new Date().getTime()),null));
    }

    @Test
    public void testFindAll() throws Exception{
        System.out.println(ingredientMapper.findAll());

    }

    @Test
    public void testMybatis() throws Exception {
        ingredientMapper.add(new Ingredient("FLTO","Flour Tortilla", IngredientEnum.WRAP,""));
        ingredientMapper.add(new Ingredient("COTO","Corn Tortilla", IngredientEnum.WRAP,""));
        ingredientMapper.add(new Ingredient("GRBF","Ground Beef", IngredientEnum.PROTEIN,""));
        ingredientMapper.add(new Ingredient("CARN","Carnitas", IngredientEnum.PROTEIN,""));
        ingredientMapper.add(new Ingredient("TMTO","Diced Tomatoes", IngredientEnum.VEGGIES,""));
        ingredientMapper.add(new Ingredient("LETC","Lettuce", IngredientEnum.VEGGIES,""));
        ingredientMapper.add(new Ingredient("CHED","Cheddar", IngredientEnum.CHEESE,""));
        ingredientMapper.add(new Ingredient("JACK","Monterrey Jack", IngredientEnum.CHEESE,""));
        ingredientMapper.add(new Ingredient("SLSA","Salsa", IngredientEnum.SAUCE,""));
        ingredientMapper.add(new Ingredient("SRCR","Sour Cream", IngredientEnum.SAUCE,""));
        System.out.println(1);
    }

    @Test
    public void testMybatis2() throws Exception{
        System.out.println(ingredientMapper.getIngredient("Sour Cream"));
        System.out.println(2);
    }



}
