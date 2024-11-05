package matnam_zang.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

// ● Recipe 테이블
// 레시피의 기본 정보 저장 (유저가 작성한 레시피)
@Entity
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;

    @ManyToOne
    @JoinColumn(name = "user_id") // recipe 테이블에서 user_id라는 컬럼으로 User 테이블의 pk를 참조함
    private User user;

    @Column(nullable = false) // null 허용 x
    private String title;

    @Column(columnDefinition = "TEXT") // 긴 텍스트 저장을 위해 TEXT 타입으로 정의
    private String recipeDescription;
    private int cookTime;
    private String difficultyLevel;
    private LocalDateTime recipeCreateAt;
    private LocalDateTime recipeUpdateAt;

    @Column(columnDefinition = "int default 0") // 조회수 초기값을 0으로 설정
    private int viewCount;

    @OneToMany(mappedBy = "recipe" , cascade = CascadeType.REMOVE)
    private List<RecipeIngredient> ingredients;

    @OneToMany(mappedBy = "recipe" , cascade = CascadeType.REMOVE)
    private List<Instruction> instructions;

    @OneToMany(mappedBy = "recipe" , cascade = CascadeType.REMOVE)
    private List<RecipeCategory> categories;

    @OneToMany(mappedBy = "recipe" , cascade = CascadeType.REMOVE)
    private List<Review> reviews;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.REMOVE)
    private List<Like> likes;
}