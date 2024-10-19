<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="vn.iotstar.utils.Constant" %>

<%
    // Lấy giá trị cookie
    Cookie[] cookies = request.getCookies();
    String username = "";
    String password = "";
    boolean remember = false;

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (Constant.COOKIE_REMEMBER.equals(cookie.getName())) {
                username = cookie.getValue();  
                remember = true;
            }
            if (Constant.COOKIE_PASSWORD.equals(cookie.getName())) {
            	password = cookie.getValue();    
                remember = true;
            }
        }
    }
%>

<!-- BEGIN CONTENT -->
<div class="col-md-9 col-sm-9">
    <h1>Login</h1>
    <div class="content-form-page">
        <div class="row">
            <!-- Hiển thị thông báo lỗi nếu có -->
            <c:if test="${alert != null}">
                <h3 class="alert alert-danger">${alert}</h3>
            </c:if>
            <div class="col-md-7 col-sm-7">
                <form action="${pageContext.request.contextPath}/login" method="post" class="form-horizontal form-without-legend" role="form">
                    <div class="form-group">
                        <label for="username" class="col-lg-4 control-label">User name <span class="require">*</span></label>
                        <div class="col-lg-8">
                            <!-- Hiển thị giá trị cookie nếu có -->
                            <input type="text" class="form-control" name="username" id="username" required value="<%= username %>">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="col-lg-4 control-label">Password <span class="require">*</span></label>
                        <div class="col-lg-8">
                            <!-- Hiển thị giá trị cookie nếu có -->
                            <input type="password" class="form-control" name="password" id="password" required value="<%= password %>">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-offset-4 col-lg-8">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="remember" id="remember" <%= remember ? "checked" : "" %>> Remember me
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-8 col-md-offset-4 padding-left-0">
                            <a href="/baitap/views/ForgetPass.jsp">Forget Password?</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-10 padding-right-30">
                            <hr>
                            <div class="login-socio">
                                <p class="text-muted">or login using:</p>
                                <ul class="social-icons">
                                    <li><a href="#" data-original-title="facebook" class="facebook" title="facebook"></a></li>
                                    <li><a href="#" data-original-title="Twitter" class="twitter" title="Twitter"></a></li>
                                    <li><a href="#" data-original-title="Google Plus" class="googleplus" title="Google Plus"></a></li>
                                    <li><a href="#" data-original-title="Linkedin" class="linkedin" title="LinkedIn"></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-4 col-sm-4 pull-right">
                <div class="form-info">
                    <h2><em>Important</em> Information</h2>
                    <p>Duis autem vel eum iriure at dolor vulputate velit esse vel molestie at dolore.</p>

                    <button type="button" class="btn btn-default">More details</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- END CONTENT -->
