package kodlama.io.Devs.entities.concretes;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "programs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Programs {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//ID otomatik arttırma
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy="programs")
    private Set<SubTechnology> items;
	
}
