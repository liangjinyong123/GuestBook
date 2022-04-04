package com.zerock.guestbook.repository;

import com.zerock.guestbook.entity.GuestBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class GuestbookRepositoryTests {

    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 300).forEach(i -> {
            GuestBook guestBook = GuestBook.builder()
                    .title("Title..." + i)
                    .content("Content..." + i)
                    .writer("user" + (i % 10))
                    .build();

            System.out.println(guestbookRepository.save(guestBook));
        });
    }

    @Test
    public void updateTest() {
        Optional<GuestBook> result = guestbookRepository.findById(300L); // 존재하는 번호로 테스트

        if (result.isPresent()){
            GuestBook guestBook = result.get();

            guestBook.changeTitle("Changed Title...");
            guestBook.changeContent("Changed content...");

            guestbookRepository.save(guestBook);
        }
    }
}
