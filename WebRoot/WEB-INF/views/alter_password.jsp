<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<c:set var="uri" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
var uri='${uri}';
</script>
  <title>修改密码</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui/css/layui.css">
</head>
<div class="layui-container">  
    <div class="layui-row">
        <div class="layui-col-lg12">
            <fieldset class="layui-elem-field">
                <legend>修改密码</legend>
                <div class="layui-field-box">
                    <div class="layui-form" action="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">旧密码</label>
                            <div class="layui-input-block">
                            <input type="password"  placeholder="请输入旧密码" id="password1" name="password1" class="layui-input">
                            </div>
                        </div>
						
						 <div class="layui-form-item">
                            <label class="layui-form-label">新密码</label>
                            <div class="layui-input-block">
                            <input type="password"  placeholder="请输入新密码" id="password2" name="password2" class="layui-input">
                            </div>
                        </div>
						
						 <div class="layui-form-item">
                            <label class="layui-form-label">新密码</label>
                            <div class="layui-input-block">
                            <input type="password"  placeholder="请再次输入新密码" id="password3" name="password3" class="layui-input">
                            </div>
                        </div>

<div class="layui-form-item">
                            <div class="layui-input-block">
                            <button class="layui-btn" onClick="alterPassword();" >立即提交</button>
                            </div>
                        </div>
                      
                    </div>
                </div>
            </fieldset>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=#随机码#"></script>
<script type="text/javascript">
function alterPassword(){
var password1 = $("#password1").val();
var password2 = $("#password2").val();
var password3 = $("#password3").val();
	$.ajax({
	    type: 'post',
	    dataType : "json",
	    url: '${pageContext.request.contextPath}/commonapi/alterPassword/submit',
	    data:{
	    	"password1":password1,
	    	"password2":password2,
	    	"password3":password3
	    },
	    success: function(result) {
	    	if(result.code == 0){
	    		alert(result.msg);
			}else{
				alert(result.msg);
			}
	    }
	}); 
}
</script>
</body>
</html>