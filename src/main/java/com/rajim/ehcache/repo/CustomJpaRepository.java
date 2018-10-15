package com.rajim.ehcache.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author rajim on 10/14/18
 */
@NoRepositoryBean
public interface CustomJpaRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}