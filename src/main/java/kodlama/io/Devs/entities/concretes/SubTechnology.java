package kodlama.io.Devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "subTechnology")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SubTechnology {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//ID otomatik arttırma
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	
	@ManyToOne
    @JoinColumn(name="programs_id", nullable=false)
    private Programs programs;

	
}
