package tacos.data.sqlProvider;

import org.apache.ibatis.jdbc.SQL;

public class TacoProvider {

    public String findAll(){
        return new SQL(){
            {
                SELECT("*");
                FROM("taco");
            }
        }.toString();
    }
}
