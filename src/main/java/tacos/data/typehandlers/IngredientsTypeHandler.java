package tacos.data.typehandlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import tacos.pojo.enums.IngredientEnum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@MappedJdbcTypes(JdbcType.VARCHAR)

@MappedTypes(value = IngredientEnum.class)
public class IngredientsTypeHandler extends BaseTypeHandler<IngredientEnum> {

    //设置数据
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, IngredientEnum ingredientEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,ingredientEnum.name());
    }
    //根据名字查找
    @Override
    public IngredientEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return IngredientEnum.valueOf(resultSet.getString(s));
    }
    //根据位置查找
    @Override
    public IngredientEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return IngredientEnum.valueOf(resultSet.getString(i));
    }
    //根据存储模过程来查找
    @Override
    public IngredientEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return IngredientEnum.valueOf(callableStatement.getString(i));
    }
}
