package com.villvay;


import com.villvay.model.User;
import com.villvay.model.UserDTO;
import com.villvay.repository.UserDao;
import com.villvay.service.AuthUserDetailsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)

public class SpringBootHelloWorldApplicationTest {

    @Autowired
    private AuthUserDetailsService authUserDetailsService;

    @Mock
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        userDao = Mockito.mock(UserDao.class);
    }

    @Test
    public void saveTest(){
        UserDTO user = new UserDTO("Dinuka","villvay-123");
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        when(userDao.save(user1)).thenReturn(user1);
        assertEquals(user,authUserDetailsService.save(user));

    }

}
