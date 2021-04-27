package com.example.demo.DOA;

import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.user;
import com.sun.el.stream.Optional;

@Repository
@Transactional
public interface RepoCourse extends JpaRepository<user,Integer>  {

}
