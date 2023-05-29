package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="professor_table")
@Entity
@Getter
@Setter  //pielāgosies anotācijām
@NoArgsConstructor
@ToString
public class Professor {
	
	@Setter(value=AccessLevel.NONE)
	@Column(name="Idp")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idp;
	
	@Column(name="Name")
	@Pattern(regexp="[A-ZĀČĒĪĶĻŅŠŪŽ]{1}[a-zāčēīķļņšūž\\ ]+", message="Pirmajam burtam jābūt lielajam")
	@NotNull
	@Size(min = 3, max = 15)
	private String name;
	
	@NotNull
	@Size(min = 3, max = 15)
	@Pattern(regexp="[A-ZĀČĒĪĶĻŅŠŪŽ]{1}[a-zāčēīķļņšūž\\ ]+", message="Pirmajam burtam jābūt lielajam")
	@Column(name="Surname")
	private String surname;
	
	@NotBlank
	@Column(name="Degree")
	private Degree degree;
	
	
	public Professor(String name, String surname, Degree degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	

	
}
