package matnam_zang.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


// 재료 테이블 : 개별 재료 정보 저장 (불변?)
@Entity
@Data
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;

    private String name;

    @OneToMany(mappedBy = "ingredient" , cascade = CascadeType.REMOVE)
    private List<RecipeIngredient> recipes;
}
