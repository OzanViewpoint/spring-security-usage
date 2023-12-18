package com.ozan.springsecurityusage;

import com.ozan.springsecurityusage.auth.properties.UaaProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityUsageApplicationTests {

    @Autowired
    UaaProperties uaaProperties;

    @Test
    void contextLoads() {
        System.out.println(uaaProperties.getSecret());
    }

}
