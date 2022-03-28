package com.zerock.guestbook.repository;

import com.zerock.guestbook.entity.GuestBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestbookRepository extends JpaRepository<GuestBook, Long> {
}
