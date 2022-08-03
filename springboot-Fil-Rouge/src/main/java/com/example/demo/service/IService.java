package com.example.demo.service;

import java.util.List;
import java.util.Optional;

/**
 * The Interface IService.
 *
 * @param <T> the generic type
 */
public interface IService<T> {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<T> findAll();

	/**
	 * Save or update.
	 *
	 * @param o the o
	 * @return the t
	 */
	T saveOrUpdate(T o);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	Optional<T> findById(Integer id);

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	void delete(Integer id);
}
