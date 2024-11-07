package matnam_zang.demo.entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @OneToMany(mappedBy = "ingredient") // cascade = CascadeType.REMOVE (jpa 단에서 cascade 옵션관리 - db쪽에서는 확인 불가)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<RecipeIngredient> recipes;
}
