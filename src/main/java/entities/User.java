
package entities;

import jakarta.persistence.*;
import lombok.Data; // Sử dụng Lombok để tự động tạo getter và setter

import javax.management.relation.Role;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data // Lombok sẽ tự động tạo getter, setter, và các phương thức cần thiết
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; // ID người dùng

    @Column(unique = true, nullable = false)
    private String username; // Tên người dùng

    @Column(nullable = false)
    private String password; // Mật khẩu

    @Column(unique = true, nullable = false)
    private String email; // Địa chỉ email

    @Enumerated(EnumType.STRING)
    private Role role; // Vai trò người dùng

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt; // Ngày tạo

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // Ngày cập nhật

    // Constructor
    public User() {
        this.createdAt = LocalDateTime.now(); // Khởi tạo thời gian tạo
    }

    // Phương thức để cập nhật ngày cập nhật
    @PreUpdate
    public void updateTimestamp() {
        this.updatedAt = LocalDateTime.now(); // Cập nhật thời gian khi có thay đổi
    }
}
