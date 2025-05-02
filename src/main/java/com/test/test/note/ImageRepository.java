package com.test.test.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface ImageRepository extends JpaRepository<image, Integer> {
    Optional<image> findByName(String name);
}
