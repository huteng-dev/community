package com.ht.community;


import com.ht.community.dao.DiscussPostMapper;
import com.ht.community.dao.UserMapper;
import com.ht.community.entity.DiscussPost;
import com.ht.community.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {

    @Autowired(required=false)
    private UserMapper userMapper;

    @Autowired(required=false)
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);
    }

    @Test
    public void testselectPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149,0,10);
        for(DiscussPost post :list){
            System.out.println(post);
        }
        int row = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(row);
    }


}
