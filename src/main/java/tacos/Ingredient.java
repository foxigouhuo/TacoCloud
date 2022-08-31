package tacos;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 * ASUS
 * 2022/8/20
 * 18:36
 */
@Data
@NoArgsConstructor
@Entity
public class Ingredient {
    @Id
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;



}
