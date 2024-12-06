package pt.iade.ei.thinktoilet.models.views;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vw_rating")
public class Rating {
    @Id
    @Column(name = "toil_id")
    @JsonIgnore
    private int toiletId;

    @Column(name = "avg_clean")
    private double avgClean;

    @Column(name = "avg_structure")
    private double avgStructure;

    @Column(name = "avg_accessibility")
    private double avgAccessibility;

    @Column(name = "ratio_paper")
    private double avgPaper;
}
