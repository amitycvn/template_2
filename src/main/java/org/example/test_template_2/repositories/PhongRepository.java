package org.example.test_template_2.repositories;

import org.example.test_template_2.entities.Phong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhongRepository extends JpaRepository<Phong, Integer> {
}