<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>医院需求</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui/css/layui.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/global.css">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/icheck/minimal/red.css">
                <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/page/myPagination.css?t=4" />
                    
                    </head>
                    <body class="layui-layout-body">
                    <style type="text/css">
                    .btnStyle{
                        margin-left:8px;
                        margin-top:8px
                    }
                    .loadingModel {
                        position: absolute;
                        top: 0;
                        left: 0;
                        background-color: rgba(9, 9, 9, 0.63);
                        width: 100%;
                        height: 100%;
                        z-index: 1000;
                    }
                    
                    
                    .loading-content {
                        width: 50%;
                        text-align: center;
                        background: #ffffff;
                        border-radius: 6px;
                        line-height: 30px;
                        z-index: 10001;
                    }
                    </style>
                    <div id="loadingDiv"></div>
                    <div id="imgModal"></div>
                    <fieldset class="layui-elem-field">
                    <legend>医院需求</legend>
                    <div class="layui-field-box">
                    <div class="layui-form" action="">
                    <div class="layui-form-item" style="text-align:center;">
                    
                    <div class="layui-inline" style="margin-left:100px;">
                    <label>物资名</label>
                    </div>
                    <div class="layui-inline">
                    <div class="layui-input-inline" >
                    <input type="text"  style="width:250px;display:inline"  placeholder="请输入物资名进行查询" id="wzName" class="layui-input">
                    </div>
                    </div>
                    
                    <div class="layui-inline" style="margin-left:100px;">
                    <label>状态</label>
                    </div>
                    <div class="layui-inline">
                    <div class="layui-input-inline" >
                    <select  id="needStatus" style="height:30px;width:250px;display:inline" >
                    <option value="">全部</option>
                    <c:forEach items="${needStatusList}" var="item">
                        <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                            </select>
                            
                            </div>
                            </div>
                            
                            <button type="button" onclick="ajaxList(1);" style="margin-left:50px" class="layui-btn layui-btn-radius" ><i class="layui-icon layui-icon-search"></i>查询</button>
                            
                            </div>
                            </div>
                            
                            <hr>
                            <div class="layui-form-item">
                            
                            <span id="batchUpdateDiv">
                            
                            </span>
                            <span class="l" id="globalBtns">
                            
                            </span>
                            </div>
                            <hr>
                            <table class="layui-table">
                            
                            <thead>
                            <tr  style="text-align:center">
                            <th>物资名</th>
                            <th>需求数量</th>
                            <th>备注</th>
                            <th>发布医院</th>
                            <th>医院地址</th>
                            <th>完成数量</th>
                            <th>状态</th>
                            <th>发布时间</th>
                            <th style="width:200px;">操作</th>
                            
                            </tr>
                            </thead>
                            <tbody id="hospital_need_info_body">
                            
                            </tbody>
                            </table>
                            
                            <div id="hospital_need_info_bar" class="pagination" style="margin-top:20px;">
                            </div>
                            </div>
                            </fieldset>
                            
                            <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
                                <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/page/myPagination.js"></script>
                                    
                                    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.js"></script>
                                        <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layuiutil.js"></script>
                                            
                                            
                                            
                                            <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=4478"></script>
                                                
                                                
                                                
                                                <script type="text/javascript">
                                                
                                                $(function(){
                                                    
                                                    ajaxList(1);
                                                    
                                                    
                                                });
                                                
                                                function ajaxList(page) {
                                                    var wzName = $("#wzName").val();
                                                    var needStatus = $("#needStatus").val();
                                                    
                                                    showLoading('${pageContext.request.contextPath}/static/common/loading.gif');
                                                        $.ajax({
                                                            type : 'get',
                                                            url : "${pageContext.request.contextPath}/company/hospital_need_info/queryList",
                                                                data : {
                                                                    "page":page,
                                                                    "wzName":wzName,
                                                                    "needStatus":needStatus
                                                                    
                                                                },
                                                                success : function(result) {
                                                                    hideLoading();
                                                                    var rows = result.list;//得到数据列
                                                                    var total = result.count;//得到数据总数
                                                                    lastPage=result.totalPage;
                                                                    totalCount=total;
                                                                    var html = '';
                                                                    for (var i = 0; i < rows.length; i++) {
                                                                        html += '<tr>' ;
                                                                        var wzNameVal=setNullToEmpty(rows[i].hospitalNeedInfo.wzName);
                                                                        html+='<td>'+ wzNameVal+'</td>';
                                                                        var wzNumVal=setNullToEmpty(rows[i].hospitalNeedInfo.wzNum);
                                                                        html+='<td>'+ wzNumVal+'</td>';
                                                                        var remarkVal=setNullToEmpty(rows[i].hospitalNeedInfo.remark);
                                                                        html+='<td>'+ remarkVal+'</td>';
                                                                        var hospitalIdVal=setNullToEmpty(rows[i].hospitalIdStr);
                                                                        html+='<td>'+ hospitalIdVal+'</td>';
                                                                        var addressVal=setNullToEmpty(rows[i].hospitalNeedInfo.address);
                                                                        html+='<td>'+ addressVal+'</td>';
                                                                        var completeNumVal=setNullToEmpty(rows[i].hospitalNeedInfo.completeNum);
                                                                        html+='<td>'+ completeNumVal+'</td>';
                                                                        var needStatusVal=setNullToEmpty(rows[i].needStatusStr);
                                                                        if(rows[i].hospitalNeedInfo.needStatus=='1'){
                                                                        needStatusVal ='<span class="layui-badge layui-bg-orange"  style="width:80px;">'+needStatusVal+'</span>'}
                                                                        if(rows[i].hospitalNeedInfo.needStatus=='2'){
                                                                        needStatusVal ='<span class="layui-badge layui-bg-blue"  style="width:80px;">'+needStatusVal+'</span>'}
                                                                        if(rows[i].hospitalNeedInfo.needStatus=='3'){
                                                                        needStatusVal ='<span class="layui-badge layui-bg-green"  style="width:80px;">'+needStatusVal+'</span>'}
                                                                        html+='<td>'+needStatusVal+'</td>';
                                                                        var createTimeVal=setNullToEmpty(rows[i].hospitalNeedInfo.createTime);
                                                                        html+='<td>'+ createTimeVal+'</td>';
                                                                        html+='<td>';
                                                                        if(rows[i].hospitalNeedInfo.needStatus=='2'){
                                                                            html+='<a href="javascript:void(0)" data-url="${pageContext.request.contextPath}/company/order_info/add?needId='+rows[i].hospitalNeedInfo.id+'" page-name="厂商订单" onclick="gotoPage(this)"  class="layui-btn layui-btn-radius btnStyle">认领需求</a>';
                                                                            }
                                                                            html+='</td>';
                                                                            html+='</tr>';
                                                                        }
                                                                        if (rows.length == 0) {
                                                                            html += '<tr><td></td><td></td><td></td><td></td><td>无数据</td><td></td><td></td><td></td><td></td></tr>';
                                                                        }
                                                                        $("#hospital_need_info_body").html(html);
                                                                        
                                                                        
                                                                        new myPagination({
                                                                            id: 'hospital_need_info_bar',
                                                                            curPage:page, //初始页码
                                                                            pageTotal: result.totalPage, //总页数
                                                                            pageAmount: 10,  //每页多少条
                                                                            dataTotal: total, //总共多少条数据
                                                                            pageSize: 5, //可选,分页个数
                                                                            showPageTotalFlag:true, //是否显示数据统计
                                                                            showSkipInputFlag:false, //是否支持跳转
                                                                            getPage: function (page) {
                                                                                ajaxList(page);
                                                                            }
                                                                        })
                                                                        
                                                                    }
                                                                });
                                                            }
                                                            
                                                            
                                                            
                                                            function gotoPage(e){
                                                                
                                                                var url = $(e).attr("data-url");
                                                                window.location.href=url;
                                                            }
                                                            
                                                            </script>
                                                            
                                                            </body>
                                                            </html>
