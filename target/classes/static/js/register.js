function checkmail() {　　
    var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");　　
    var usermail = document.getElementById("email");
    var mail = document.getElementById("mistake");　　
    if (usermail.value == "") {　　　　
        mail.innerHTML = "邮箱不能为空!";
        mail.style.color = "red";　　
        return false;　　
    } else if (!reg.test(usermail.value)) {　　　　
        mail.innerHTML = "邮箱格式不正确!";
        mail.style.color = "red";　　　
        return false;　　
    } else {　　　　　　
        return true;　　
    }
}

function checkpass() {
    var userpass = document.getElementById("password");
    var pass = document.getElementById("mistake");
    if (userpass.value == "") {
        pass.innerHTML = "密码不能为空!";
        pass.style.color = "red";
        return false;
    } else if (userpass.value.length < 6 || userpass.value.length > 15) {
        pass.innerHTML = "密码长度必须在6—15位之间!";
        pass.style.color = "red";
        return false;
    } else {
        return true;
    }
}

function checkrpass() {
    var userpass = document.getElementById("password");
    var Ruserpass = document.getElementById("Rpassword");
    var Rpass = document.getElementById("mistake");
    if (Ruserpass.value != userpass.value) {
        Rpass.innerHTML = "两次密码输入不一致!";
        Rpass.style.color = "red";
        return false;
    } else {
        return true;
    }
}

function checkname() {
    var username = document.getElementById("username");
    var name = document.getElementById("mistake");
    if (username.value == "") {
        name.innerHTML = "用户名不能为空";
        name.style.color = "red";
        return false;
    } else if (username.value.length < 3 || username.value.length > 12) {
        name.innerHTML = "用户名长度必须在3-12位之间!";
        name.style.color = "red";
        return false;
    } else {
        return true;
    }
}

function checkcompanyname() {
    var companyname = document.getElementById("companyname");
    var name = document.getElementById("mistake");
    if (companyname.value == "") {
        name.innerHTML = "公司名称不能为空";
        name.style.color = "red";
        return false;
    } else {
        return true;
    }
}

function checkphone() {
    var reg = new RegExp("^0?(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57])[0-9]{8}$");
    var userphone = document.getElementById("phone");
    var telephone = document.getElementById("mistake");
    if (userphone.value == "") {
        telephone.innerHTML = "手机号不能为空!";
        telephone.style.color = "red";
        return false;
    } else if (!reg.test(userphone.value)) {
        telephone.innerHTML = "手机号格式不正确!"
        telephone.style.color = "red";
        return false;
    } else {
        return true;
    }
}

function checkqq() {
    var reg = new RegExp("[1-9][0-9]{4,14}")
    var userqq = document.getElementById("qq");
    var qq = document.getElementById("mistake");
    if (userqq.value == "") {
        qq.innerHTML = "QQ不能为空!";
        qq.style.color = "red";
        return false;
    } else if (!reg.test(userqq.value)) {
        qq.innerHTML = "QQ格式不正确!";
        qq.style.color = "red";
        return false;
    } else {
        return true;
    }
}
window.onload = function() {
    createCode();
    var formValidate = document.getElementById("registerform");
    formValidate.onsubmit = function() {
        var checkbox = document.getElementById("checkBox");
        var mistakes = document.getElementById("mistake");
        if (checkbox.checked != true) {
            mistakes.innerHTML = "不同意协议不能注册";
            mistakes.style.color = "red";
            return false;
        } else {
            return true;
        }
    }
}
var code; //在全局定义验证码 
function createCode() {
    code = "";
    var codeLength = 4; //验证码的长度 
    var checkCode = document.getElementById("code");
    var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //随机数 
    for (var i = 0; i < codeLength; i++) { //循环操作 
        var index = Math.floor(Math.random() * 36); //取得随机数的索引（0~35） 
        code += random[index]; //根据索引取得随机数加到code上 
    }
    checkCode.value = code; //把code值赋给验证码 
}
//校验验证码 
function validate() {
    var error = document.getElementById("mistake");
    var inputCode = document.getElementById("codes").value.toUpperCase(); //获取输入框内验证码并转化为大写  
    if (inputCode.length <= 0) { //若输入的验证码长度为0 
        error.innerHTML = "请输入验证码！";
        error.style.color = "red";
        return false; //则弹出请输入验证码 
    } else if (inputCode != code) { //若输入的验证码与产生的验证码不一致时 
        error.innerHTML = "验证码输入错误!";
        error.style.color = "red";
        createCode(); //刷新验证码 
        document.getElementById("codes").value = "";
        return false; //清空文本框 
    } else { //输入正确时 
        return true; //弹出 
    }
}