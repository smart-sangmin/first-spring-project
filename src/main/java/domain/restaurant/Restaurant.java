package domain.restaurant;

import domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Restaurant extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private String category;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String address;

    private Boolean isDeleted;

    // 만약 영업시간이 있었으면?

    @Builder
    public Restaurant(String name, String foodType, String address) {
        this.name = name;
        this.category = foodType;
        this.address = address;
        this.isDeleted = false;
    }

    public void update(String category) {
        this.category = category;
    }

    public void delete() {
        this.isDeleted = true;
    }
}
