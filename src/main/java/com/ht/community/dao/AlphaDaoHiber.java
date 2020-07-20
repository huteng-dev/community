package com.ht.community.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AlphaDaoHiber implements AlphDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
