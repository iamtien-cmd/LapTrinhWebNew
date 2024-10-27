package vn.iotstar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.iotstar.entity.Category;
import vn.iotstar.repository.ICategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	ICategoryRepository categoryRepository;

	@Override
	public Optional<Category> findByName(String name) {
		return categoryRepository.findByName(name);
	}

	@Override
	public Page<Category> findByNameContainning(String name, Pageable pageable) {
		return categoryRepository.findByNameContaining(name, pageable);
	}

	@Override
	public <S extends Category> S save(S entity) {
		return categoryRepository.save(entity);
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}

	@Override
	public long count() {
		return categoryRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}

	

	public CategoryServiceImpl(ICategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> longs) {
		// TODO Auto-generated method stub
		
	}

	
	
}
