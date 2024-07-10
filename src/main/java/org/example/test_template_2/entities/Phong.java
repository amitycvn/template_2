package org.example.test_template_2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "phong")
public class Phong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_co_so")
    private Integer idCoSo;

    @Column(name = "id_lau")
    private Integer idLau;

    @Column(name = "id_loai_phong")
    private Integer idLoaiPhong;

    @Size(max = 255)
    @NotBlank(message = "ghi chu ko duoc de trong")
    @Column(name = "ghi_chu")
    private String ghiChu;

    @Size(max = 255)
    @NotBlank(message = "so luong phong ko duoc de trong")
    @Column(name = "so_luong_phong")
    private String soLuongPhong;

    @Size(max = 255)
    @Column(name = "ten_phong")
    @NotBlank(message = "ten phong ko duoc de trong")
    private String tenPhong;

    @Size(max = 255)
    @Column(name = "trang_thai")
    private String trangThai;

}