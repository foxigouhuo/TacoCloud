package tacos.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.data.mapper.TacoMapper;
import tacos.pojo.entity.Taco;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TacoService {
    private final TacoMapper tacoMapper;

    @Autowired
    public TacoService(TacoMapper tacoMapper) {
        this.tacoMapper = tacoMapper;
    }

    public List<Taco> findAll(){
        return tacoMapper.findAll();
    }

    public int saveTaco(Taco taco){
        taco.setId(UUID.randomUUID().toString());
        taco.setCreateAt(new Timestamp(new Date().getTime()));
        return tacoMapper.saveTaco(taco);
    }
}
