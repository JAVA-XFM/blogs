package com.xfm.blogs.service;

import com.xfm.blogs.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {
    Page<Type> findAll(Pageable pageable);

    Type findOne(Long id);

    Type save(Type type);

    void delete(Long id) throws Exception;

}
