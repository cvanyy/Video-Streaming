package pl.polsl.rtc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import pl.polsl.rtc.dao.StreamRepository;
import pl.polsl.rtc.dao.UserRepository;
import pl.polsl.rtc.entity.Stream;
import pl.polsl.rtc.entity.User;

import java.util.Arrays;

@Configuration
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StreamRepository streamRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("administrator"));
        user.setAuthority("ROLE_ADMIN");
        userRepository.save(user);

        Stream stream = new Stream();
        stream.setName("USA Highway");
        stream.setDescription("The Highway in USA with bridge view");
        stream.setUrl("http://69.51.121.170:80/mjpg/video.mjpg?COUNTER");
        streamRepository.save(stream);

        Stream stream1 = new Stream();
        stream1.setName("Bociany POLSKA");
        stream1.setDescription("Gniazdo bocianów w polsce");
        stream1.setUrl("http://fowo11.ddns3-instar.de:80/cgi-bin/hi3510/mjpegstream.cgi?-chn=11&-usr=gast&-pwd=storchennest");
        streamRepository.save(stream1);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
