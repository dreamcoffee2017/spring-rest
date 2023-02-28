package com.example.springrest.customer.dao;

import com.example.springrest.customer.entity.Customer;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ICustomerDao {

    @Select("select * from customer")
    List<Customer> findALl();

    @Select("select * from customer where name = #{name}")
    List<Customer> findByName(String name);

    @Insert("insert into customer(id, name, email) values(#{id}, #{name}, #{email})")
    void insert(Customer entity);

    @Update("update customer set name = #{name}, email = #{email} where id = #{id}")
    void update(Customer entity);

    @Delete("delete from customer where id = #{id}")
    void delete(String id);
}
