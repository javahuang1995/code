package com.huang.repository;

import com.huang.pojo.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TbUserRepository extends JpaRepository<TbUser, Long>
{
}