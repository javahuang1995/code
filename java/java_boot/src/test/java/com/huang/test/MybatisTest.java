package com.huang.test;

import com.github.pagehelper.PageHelper;
import com.huang.mapper.TbItemMapper;
import com.huang.pojo.TbItem;
import com.huang.pojo.TbItemExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    @Autowired
    private TbItemMapper tbItemMapper;
    private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);


    @Test
    public void test1() {
        // 分页处理，显示第一页的10条数据
        PageHelper.startPage(1, 10);
        TbItemExample example = new TbItemExample();
        List<TbItem> list = tbItemMapper.selectByExample(example);
        // 取商品列表
        for (TbItem item : list) {
            logger.info(item.getTitle());
        }
    }

}
