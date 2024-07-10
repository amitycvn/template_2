package org.example.test_template_2.repositories;

import org.example.test_template_2.entities.LoaiPhong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoaiPhongRepository extends JpaRepository<LoaiPhong, Integer> {
}