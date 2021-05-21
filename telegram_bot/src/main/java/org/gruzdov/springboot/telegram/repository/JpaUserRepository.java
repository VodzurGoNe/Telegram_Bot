package org.gruzdov.springboot.telegram.repository;

import org.gruzdov.springboot.telegram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface JpaUserRepository extends JpaRepository<User, Long> {
    Optional<User> getByChatId(Long chatId);
}
