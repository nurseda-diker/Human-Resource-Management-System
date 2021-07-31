package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.TypeOfWork;

public interface TypeOfWorkDao extends JpaRepository<TypeOfWork, Integer>{
	
	TypeOfWork getById(int id);
}
