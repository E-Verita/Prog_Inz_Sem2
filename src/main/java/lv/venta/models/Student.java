package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="student_table")
@Entity
@Getter
@Setter  //pielāgosies anotācijām
@NoArgsConstructor
@ToString
public class Student {
	
	@Setter(value=AccessLevel.NONE)
	@Column(name="Ids")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ids;
	
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
	
	@OneToMany(mappedBy="student")
	private Collection<Grade> grades;
	
	public Student(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

}
