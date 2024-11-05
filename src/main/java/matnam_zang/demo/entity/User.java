package matnam_zang.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

// user 테이블 : 사용자 정보 저장
@Entity // JPA의 엔티티임을 나타내는 어노테이션
@Data
@Table(name = "user") // 데이터베이스에 매핑될 테이블의 이름을 정의
public class User {
    @Id // 이 필드가 이 엔티티의 기본 키 (primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키의 값이 자동 생성
    private Long userId;

    private String username;
    private String email;
    private String password;
    private LocalDateTime userCreateAt;
    private LocalDateTime userUpdateAt;

    // recipe 테이블과 일대다 관계 (recipe 엔티티에서 user라는 외래키로 참조)
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE) // 이때 OneToMany쪽의 일인쪽의 테이블을 mappedBy
    private List<Recipe> recipes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Review> reviews;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Like> likes;
}