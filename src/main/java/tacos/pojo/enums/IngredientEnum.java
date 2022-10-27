package tacos.pojo.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public enum IngredientEnum {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE;

    @Override
    public String toString() {
        return this.name();
    }
}
