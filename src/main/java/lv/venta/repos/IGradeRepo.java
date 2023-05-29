package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Grade;
import lv.venta.models.Professor;

public interface IGradeRepo extends CrudRepository<Grade, Long>{

}
