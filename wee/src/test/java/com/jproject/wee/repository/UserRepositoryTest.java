package com.jproject.wee.repository;

import com.jproject.wee.entity.User;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
//@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void 데이터_입력_조회_Test(){
        //given && when
        IntStream.rangeClosed(1,100).forEach(i -> {
            User user = User.builder()
                    //.id(1L)
                    .userId("J"+i)
                    .password("123456")
                    .age(30L)
                    .gender("M")
                    .phoneNo("010-1234-5678")
                    .mail("user@user.com")
                    .address("korea")
                    .build();
            userRepository.save(user);
        });
        List<User> userList = userRepository.findAll();
        userList.forEach(System.out::println);

        //then
        Assertions.assertThat("J1")
                .isEqualTo(userList.stream().filter(x -> x.getUserId().equals("J1")).findFirst().get().getUserId());
    }

    @Test
    public void 페이징_테스트(){
        //when
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0,20, sort);
        Page<User> userPage = userRepository.findAll(pageable);
        userPage.stream().forEach(System.out::println);

        //then
        Assertions.assertThat("J100")
                .isEqualTo(userPage.stream().findFirst().get().getUserId());
    }


}
