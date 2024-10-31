
package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfiguration {

    // passwordEncoder(interface trong Spring Security) được dùng để mã hóa mật khẩu
    // BcryptPasswordEncoder(class của PasswordEncoder) dùng để so sánh mật khẩu đã mã hóa với mk của người dùng

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
