package com.xfm.blogs.service;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.xfm.blogs.NotFoundException;
import com.xfm.blogs.dao.TypeRepository;
import com.xfm.blogs.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Page<Type> findAll(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public Type findOne(Long id) {
        return typeRepository.findOne(id);
    }

    @Override
    public Type save(Type type) {

        return typeRepository.save(type);
    }

    @Override
    public void delete(Long id) throws Exception{
        typeRepository.delete(id);
    }

    @Override
    public Type updateType(Type type) {
        Type t = typeRepository.findOne(type.getId());
        if(t == null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);
        return typeRepository.save(t);
    }

    @Override
    public Type findByName(String name) {
        return typeRepository.findByName(name);
    }
}
