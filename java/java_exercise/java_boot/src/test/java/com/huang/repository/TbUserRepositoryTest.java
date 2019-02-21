package com.huang.repository;

import com.huang.pojo.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TbUserRepositoryTest
{
    @Autowired
    private TbUserRepository tbUserRepository;

    private static final Logger LOG = LoggerFactory.getLogger(TbUserRepositoryTest.class);

    @Test
    public void test1()
    {
        List<TbUser> restult =  tbUserRepository.findAll();
        TbUser uu = restult.get(0);

        LOG.info(uu.toString());

    }
}