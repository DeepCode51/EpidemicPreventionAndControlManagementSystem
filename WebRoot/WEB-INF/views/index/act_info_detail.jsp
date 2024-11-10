<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>姐妹战役安心行动</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="姐妹战役安心行动">
  <meta name="description" content="姐妹战役安心行动">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bbs/res/layui/css/layui.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bbs/res/css/global.css">
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/page/myPagination.css?t=4" />
</head>
<body>
<div class="fly-header layui-bg-black">
  <div class="layui-container">
    <a style="float:left;left:-30px;margin-top:10px;" href="${pageContext.request.contextPath}/commonapi/index">
     <h1 style="color:white">姐妹战役安心行动</h1>
    </a>
    <ul class="layui-nav fly-nav layui-hide-xs">
         <li class="layui-nav-item">
        <a href="${pageContext.request.contextPath}/commonapi/index">首页</a>
      </li>
       <li class="layui-nav-item">
        <a href="${pageContext.request.contextPath}/commonapi/index/act_info">抗疫活动</a>
      </li>
       <li class="layui-nav-item">
        <a href="${pageContext.request.contextPath}/commonapi/index/notice_info">系统公告</a>
      </li>
    </ul>
    <ul class="layui-nav fly-nav-user">
<c:if test="${login==null }">
	 <!-- 未登入的状态 -->
      <li class="layui-nav-item">
        <a href="${pageContext.request.contextPath}/commonapi/sys_login">登录</a>
      </li>
      <li class="layui-nav-item">
        <a href="${pageContext.request.contextPath}/commonapi/volunteer_info_regist">注册</a>
      </li>
  </c:if>
  <c:if test="${login!=null }">
  	 <!-- 登入后的状态 -->
	   <li class="layui-nav-item">
        <a class="fly-nav-avatar" href="${pageContext.request.contextPath}/volunteer/index">
          <cite class="layui-hide-xs">${login.name}</cite>
          
          <!--  <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"> -->
        </a>
      </li>
       <li class="layui-nav-item">
        <a href="${pageContext.request.contextPath}/commonapi/sys_logout">退出</a>
      </li>
  </c:if>
    </ul>
  </div>
</div>
<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md12 content detail">
      <div class="fly-panel detail-box">
        <h1>${detail.t.actTitle}</h1>
        <div class="fly-detail-info">
          	<p style="margin-top:20px;"><img src="${detail.t.actImg}" style="width:20%"></p>
        </div>
         
        <div class="detail-body photos">
         	<p style="margin-top:20px;">${detail.t.actContent}</p>
 
	<p style="float:right">--${detail.t.createTime}</p>
        </div>
      </div>

    </div>
  </div>
</div>
<script src="${pageContext.request.contextPath}/static/bbs/res/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/page/myPagination.js"></script>
<script>

</script>
</body>
</html>
