<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%@include file="/pages/common/head.jsp"%>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }


    </style>


    <script type="text/javascript">
        $(function () {

            $("#username").blur(function (){
                var value = this.value;
                $.getJSON("userServlet","action=existUsername&username="+value, function (msg){
                    if(msg.key){
                        $(".errorMsg").text("用户名已存在！");
                    }
                    else {
                        $(".errorMsg").text("");
                    }
                })
            })

            $("#sub_btn").click(function () {

                let usernameVal = $("#username").val();
                var usernamePatt = /^\w{5,12}$/;
                if(!usernamePatt.test(usernameVal)){
                    $(".errorMsg").text("用户名不合法！");
                    return false;
                }

                let passwordVal = $("#password").val();
                var passwordPatt = /^\w{5,12}$/;
                if(!passwordPatt.test(passwordVal)){
                    $(".errorMsg").text("密码不合法！");
                    return false;
                }

                let repwdVal = $("#repwd").val();
                if(repwdVal != passwordVal){
                    $(".errorMsg").text("确认密码与密码不一致！");
                    return false;
                }

                let emailVal = $("#email").val();
                var emailPatt = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;

                if(!emailPatt.test(emailVal)){
                    $(".errorMsg").text("邮箱格式不合法！");
                    return false;
                }

                let codeVal = $("#code").val();
                codeVal = $.trim(codeVal);
                if(codeVal == ""){
                    $(".errorMsg").text("验证码不能为空！");
                    return false;
                }
                $(".errorMsg").val("");
            });

            $("#code_img").click(function () {
                this.src="${basePath}Kaptcha.jpg?d=" + new Date();
            })
        })
    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">${requestScope.msg}</span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="username" id="username" value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
                               autocomplete="off" tabindex="1" name="email" id="email" value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 100px;"name="code" id="code"/>
                        <img alt="" id="code_img" src="Kaptcha.jpg" style="float: right; margin-right: 40px" width="110" height="38">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>