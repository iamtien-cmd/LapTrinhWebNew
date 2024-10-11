package vn.iotstar.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.User;
import vn.iotstar.services.UserService;
import vn.iotstar.services.IUserService;
import vn.iotstar.utils.Constant;


@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = {"/admin/users","/admin/user/add", "/admin/user/update","/admin/user/edit",
		"/admin/user/delete"})
public class UserController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6139594455874131581L;
	public IUserService usService = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		if (url.contains("users")) {
			List<User> list = usService.findAll();
			req.setAttribute("listuser", list);
			req.getRequestDispatcher("/views/admin/user-list.jsp").forward(req, resp);

		} else if (url.contains("/admin/user/update")) {
			int id = Integer.parseInt(req.getParameter("id"));
			User us = usService.findById(id);
			req.setAttribute("us", us);
			req.getRequestDispatcher("/views/admin/user-edit.jsp").forward(req, resp);

		} else if (url.contains("/admin/user/delete")) {
			String id = req.getParameter("id");
			try {
				if (id != null) {
					usService.delete(Integer.parseInt(id));
				}
				resp.sendRedirect(req.getContextPath() + "/admin/users");
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if(url.contains("/admin/user/update"))
	{
			 int id = 0;
			String idString = req.getParameter("id");
			if (idString != null && !idString.isEmpty()) {
			    id = Integer.parseInt(idString);
			    // Tiếp tục với xử lý id
			} 
		String email = req.getParameter("email");
		String full_name = req.getParameter("fullname");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String roleIdString = req.getParameter("roleid");
		 int role_id =0;
		if (roleIdString != null && !roleIdString.isEmpty()) {
		    role_id = Integer.parseInt(roleIdString);
		    // Tiếp tục xử lý với role_id
		} 
		boolean status = Boolean.parseBoolean(req.getParameter("status"));
		
		// Lấy chuỗi create_date từ request
		String createDateString = req.getParameter("createdate"); 
		System.out.println(createDateString);
		java.sql.Date sqlDate = null; // Khởi tạo giá trị mặc định cho sqlDate

		if (createDateString != null && !createDateString.isEmpty()) { // Kiểm tra chuỗi không null hoặc rỗng
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    java.util.Date utilDate = null;
		    try {
		        utilDate = dateFormat.parse(createDateString); 
		        sqlDate = new java.sql.Date(utilDate.getTime()); 
		    } catch (ParseException e) {
		        // Xử lý lỗi nếu chuỗi không hợp lệ
		        e.printStackTrace(); // In ra lỗi cho mục đích gỡ lỗi
		        // Có thể gửi thông báo lỗi về phía client hoặc thiết lập sqlDate là giá trị mặc định
		    }
		} else {
		    // Xử lý khi createDateString là null hoặc rỗng
		    // Gán sqlDate là null hoặc giá trị mặc định khác nếu cần
		}

		// Khởi tạo đối tượng User và thiết lập các thuộc tính
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setFullName(full_name);
		user.setPassWord(password); // Cân nhắc mã hóa mật khẩu trước khi lưu
		user.setPhone(phone);
		user.setRoleid(role_id);
		user.setStatus(status); // Đã chuyển thành boolean và xử lý đúng
		user.setCreateDate(sqlDate);  // Gán giá trị ngày đã chuyển đổi
		
		String fileold = null;
		// luu hinh cu
		User usold = usService.findById(id);
		if (usold != null) {
		    fileold = usold.getAvatar();
		}
		
		// xu ly images
		String fname = "";
		String uploadPath = Constant.UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		try {
			Part part = req.getPart("avatar");
				if (part.getSize() > 0) {
					if (fileold != null && !fileold.substring(0, 5).equals("https")) {
					    deleteFile(uploadPath + "\\" + fileold);
					}
				String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
				// doi ten
				int index = filename.lastIndexOf(".");
				String ext = filename.substring(index + 1);
				fname = System.currentTimeMillis() + "." + ext;
				// up load file
				part.write(uploadPath + "/" + fname);
				// ghi ten file vao data
				user.setAvatar(fname);
			} else {
				user.setAvatar(fileold);
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		usService.update(user);
		resp.sendRedirect(req.getContextPath() + "/admin/users");

	}
	}

	public static void deleteFile(String filePath) throws IOException {
		Path path = Paths.get(filePath);
		Files.delete(path);
	}
}
