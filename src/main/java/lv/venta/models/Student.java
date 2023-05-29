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
@ToString
public class Student extends Person{
	
	@ToString.Exclude //neiekļaut Toštring, lai neaiziet infinite loop
	@OneToMany(mappedBy="student")
	private Collection<Grade> grades;
	
	public Student(String name, String surname) {
		super(name, surname);
	}

}
