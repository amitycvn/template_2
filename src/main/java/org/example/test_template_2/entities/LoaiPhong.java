package org.example.test_template_2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "loai_phong")
public class LoaiPhong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "don_gia_qua_dem", precision = 38, scale = 2)
    private BigDecimal donGiaQuaDem;

    @Column(name = "don_gia_theo_gio", precision = 38, scale = 2)
    private BigDecimal donGiaTheoGio;

    @Size(max = 255)
    @Nationalized
    @Column(name = "ho_ten_nguoi_dai_dien")
    private String hoTenNguoiDaiDien;

    @Column(name = "tien_qua_gio", precision = 38, scale = 2)
    private BigDecimal tienQuaGio;

    @Size(max = 255)
    @Column(name = "ghi_chu")
    private String ghiChu;

    @Size(max = 255)
    @Column(name = "so_nguoi")
    private String soNguoi;

    @Size(max = 255)
    @Column(name = "ten_loai_phong")
    private String tenLoaiPhong;

    @Size(max = 255)
    @Column(name = "trang_thai")
    private String trangThai;

    @Override
    public String toString() {
        return tenLoaiPhong;
    }
}