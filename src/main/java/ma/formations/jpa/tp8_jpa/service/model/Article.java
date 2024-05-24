package ma.formations.jpa.tp8_jpa.service.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Double quantite;
    private Double price;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }
}