package vn.iotstar.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstar.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long>{ // Long là kiểu của interface
	
	Optional<Category>findByName(String name);
	Page<Category> findByNameContaining(String name, Pageable pageable);
	
}
