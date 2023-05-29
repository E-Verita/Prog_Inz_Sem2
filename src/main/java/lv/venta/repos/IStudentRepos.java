package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Professor;
import lv.venta.models.Student;

public interface IStudentRepos extends CrudRepository<Student, Long>{

}
