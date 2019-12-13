package com.xfm.blogs.dao;

import com.xfm.blogs.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {

    Page<Type> findAll(Pageable pageable);

    Type findOne(Long id);

    Type save(Type type);

    void delete(Long id);

}
