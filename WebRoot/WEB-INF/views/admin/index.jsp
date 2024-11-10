<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>姐妹战役安心行动</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
 <div class="layui-logo"><a  href="#" style="color:white">姐妹战役安心行动</a></div>
 

 
    <ul class="layui-nav layui-layout-right">
	
	 
	
      <li class="layui-nav-item">
        <a href="javascript:;">
         ${roleName}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="javascript:void(0)" onclick="alterPassword()">修改密码</a></dd>
        </dl>
      </li>
	  	
      <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/commonapi/sys_logout">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
      
     <li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">用户管理 </a>
            <dl class="layui-nav-child">
                 <dd>  <a onclick="goPage(this)"  data-name="医院管理"    data-href="${pageContext.request.contextPath}/admin/hospital_info">医院管理  </a>  </dd><dd>  <a onclick="goPage(this)"  data-name="厂商管理"    data-href="${pageContext.request.contextPath}/admin/company_info">厂商管理  </a>  </dd><dd>  <a onclick="goPage(this)"  data-name="志愿者管理"    data-href="${pageContext.request.contextPath}/admin/volunteer_info">志愿者管理  </a>  </dd>
            </dl>
 </li><li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">活动管理 </a>
            <dl class="layui-nav-child">
                 <dd>  <a onclick="goPage(this)"  data-name="活动管理"    data-href="${pageContext.request.contextPath}/admin/act_info">活动管理  </a>  </dd>
            </dl>
 </li><li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">公告管理 </a>
            <dl class="layui-nav-child">
                 <dd>  <a onclick="goPage(this)"  data-name="公告管理"    data-href="${pageContext.request.contextPath}/admin/notice_info">公告管理  </a>  </dd>
            </dl>
 </li>
     
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
  <!-- 动态选项卡 -->
  <div id="tabzu" class="layui-tab layui-tab-card layui-tab-brief" lay-filter="tabDemo" lay-allowclose="true">
  <ul class="layui-tab-title"></ul>
  <div class="layui-tab-content" style="height:2000px">
    
  
  </div>
  </div>
 </div>

 
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.all.js"></script>
<script type="text/javascript">
layui.use('element', function() {
});
	
	$(function(){
		
	});
	
	
function checkLastItem(arr, i) {
 	return arr.length == (i + 1);
 }

 //添加选项卡
                                    function addTab(name, url) {
                                        if(layui.jquery(".layui-tab-title li[lay-id='" + name + "']").length > 0) {
                                            //选项卡已经存在
                                            layui.element.tabChange('tabDemo', name);
                                            var iframes = $("iframe[name='iframeDom']");
                                            for(var i=0;i<iframes.length;i++){
                                            	if($(iframes[i]).attr("data-name")==name){
                                            		$(iframes[i]).attr("src",url);
                                            	
                                            	}
                                            }
                                            } else {
                                                //动态控制iframe高度
                                                
                                                contentTxt = '<iframe src="' + url + '" name="iframeDom"  data-name="'+name+'" width="100%" height="2000px"></iframe>';
                                                //新增一个Tab项
                                                layui.element.tabAdd('tabDemo', {
                                                    title: name,
                                                    content: contentTxt,
                                                    id: name
                                                })
                                                //切换刷新
                                                layui.element.tabChange('tabDemo', name);
                                             
                                                
                                            }
                                        }
addTab("医院管理", "${pageContext.request.contextPath}/admin/hospital_info");
function goPage(e){
	var url = $(e).attr("data-href");
	var name = $(e).attr("data-name");
	 addTab(name, url);

	
}

function alterPassword(){
	 addTab("修改密码","${pageContext.request.contextPath}/commonapi/alterPassword");
	
}




</script>


</body>
</html>