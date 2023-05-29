package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="course_table")
@Entity
@Getter
@Setter  //pielāgosies anotācijām
@NoArgsConstructor
@ToString
public class Course {
	
	@Setter(value=AccessLevel.NONE)
	@Column(name="Idc")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idc;
	
	@Column(name="Title")
	@Pattern(regexp="[A-ZĀČĒĪĶĻŅŠŪŽ]{1}[a-zāčēīķļņšūž\\ ]+", message="Pirmajam burtam jābūt lielajam")
	@NotNull
	@Size(min = 3, max = 30)
	private String title;
	
	@Min(value=1)
	@Max(value=20)
	@Column(name="creditPoints")
	private int creditPoints;
	
	//Izveidot saites
	@OneToOne
	@JoinColumn(name="Idp") // otrā pusē 	@OneToOne(mappedBy = "professor")
	private Professor professor;
	
	@OneToOne(mappedBy="course")
	@ToString.Exclude
	private Collection<Grade> grades;

	
	//Izveidot argumenta konstruktoru
	public Course(
			@Pattern(regexp = "[A-ZĀČĒĪĶĻŅŠŪŽ]{1}[a-zāčēīķļņšūž\\ ]+", message = "Pirmajam burtam jābūt lielajam") @NotNull @Size(min = 3, max = 30) String title,
			@Min(1) @Max(20) int creditPoints, Professor professor) {
		super();
		this.title = title;
		this.creditPoints = creditPoints;
		this.professor = professor;
	}
	

	
	
	
	
}
