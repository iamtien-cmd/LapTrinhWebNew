package vn.iotstar.entity;

import java.io.Serializable;
import java.sql.Date;
import jakarta.persistence.*;  // Thêm package JPA
import lombok.*; // Thêm để sử dụng @Data, @AllArgsConstructor, @NoArgsConstructor

@SuppressWarnings("serial")
@Entity
@Table(name = "users")  // Đặt tên bảng trong cơ sở dữ liệu
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Thêm để tự động tăng giá trị
	@Column(name = "id") // Đặt tên cho trường trong bảng
	private int id;
	@Column(name = "full_name", columnDefinition ="NVARCHAR(MAX) NULL") // Tên đầy đủ
    private String fullName;

    @Column(name = "password", columnDefinition ="NVARCHAR(MAX) NULL") // Mật khẩu
    private String passWord;

    @Column(name = "avatar", columnDefinition ="NVARCHAR(MAX) NULL") // Hình đại diện
    private String avatar;

    @Column(name = "role_id", columnDefinition = "Null") // ID của vai trò
    private int roleid;

    @Column(name = "phone" , columnDefinition ="NVARCHAR(255) NULL") // Số điện thoại
    private String phone;

    @Column(name = "create_date", columnDefinition = "Null") // Ngày tạo
    private Date createDate;

   

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "email", nullable = false, unique = true) // Đảm bảo email là duy nhất
    private String email;

    @Column(name = "status") // Tên người dùng
    private Boolean status;

    public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

    // Constructor không tham số và có tham số đã được thêm bởi @NoArgsConstructor và @AllArgsConstructor
}
