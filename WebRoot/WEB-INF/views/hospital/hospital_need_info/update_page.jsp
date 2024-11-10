<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />
    
    <script type="text/javascript">
    var uri='${uri}';
        </script>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>修改-医院需求</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui/css/layui.css">
            
            <style type="text/css">
            
            .loadingModel {
                position: absolute;
                top: 0;
                left: 0;
                display: none;
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
            </head>
            <div id="loadingDiv"></div>
            <div id="imgModal"></div>
            <div class="layui-container" style="overflow:hidden;height:2000px">
            <div class="layui-row">
            <div class="layui-col-lg12">
            <fieldset class="layui-elem-field">
            <legend>修改-医院需求</legend>
            <div class="layui-field-box">
            <div >
            
            
            <div class="layui-form-item layui-form-text" id="wzTypeParentContent">
            <label class="layui-form-label">物资类型</label>
            <div class="layui-input-block">
            <select  id="wzType" style="height:30px;width:500px;display:inline" >
            <c:forEach items="${wzTypeList}" var="item">
                <c:if test="${item.id==data.wzType}">
                    <option value="${item.id}" selected>${item.name}</option>
                        </c:if>
                        <c:if test="${item.id!=data.wzType}">
                            <option value="${item.id}">${item.name}</option>
                                </c:if>
                                </c:forEach>
                                </select>
                                
                                </div>
                                </div>
                                
                                <div class="layui-form-item layui-form-text" id="wzNameParentContent">
                                <label class="layui-form-label">物资名</label>
                                <div class="layui-input-block">
                                <input type="text"  style="width:500px;display:inline" value="${data.wzName}" placeholder="请输入物资名" id="wzName" class="layui-input">
                                    </div>
                                    </div>
                                    
                                    <div class="layui-form-item layui-form-text" id="wzNumParentContent">
                                    <label class="layui-form-label">需求数量</label>
                                    <div class="layui-input-block">
                                    <input type="text"  style="width:500px;display:inline" value="${data.wzNum}" placeholder="请输入需求数量（请输入数字）" id="wzNum" class="layui-input">
                                        </div>
                                        </div>
                                        
                                        <div class="layui-form-item layui-form-text" id="remarkParentContent">
                                        <label class="layui-form-label">备注</label>
                                        <div class="layui-input-block">
                                        <input type="text"  style="width:500px;display:inline" value="${data.remark}" placeholder="请输入备注" id="remark" class="layui-input">
                                            </div>
                                            </div>
                                            
                                                
                                                <div class="layui-form-item">
                                                <div class="layui-input-block">
                                                <button class="layui-btn" onclick="submitData();" >立即提交</button>
                                                <button  class="layui-btn layui-btn-primary"  onclick="javascript:history.back(-1);" >返回</button>
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
                                                        <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=1223"></script>
                                                            
                                                            
                                                            
                                                            <script type="text/javascript">
                                                            
                                                            
                                                            
                                                            $(function(){
                                                                
                                                                $("#wzType").change(function(){
                                                                    wzTypeChangeEffectOtherCols();
                                                                });
                                                                wzTypeChangeEffectOtherCols();
                                                                
                                                                
                                                            })
                                                            
                                                            
                                                            
                                                            function wzTypeChangeEffectOtherCols(){
                                                                var val =$("#wzType").val();
                                                                if(val=='4'){
                                                                    $("#wzNameParentContent").css("display","block");
                                                                    }else{
                                                                        $("#wzNameParentContent").css("display","none");
                                                                    }
                                                                }
                                                                function submitData(){
                                                                    var wzType= $('#wzType').val();
                                                                    var wzName= $('#wzName').val();
                                                                    var wzNum= $('#wzNum').val();
                                                                    var remark= $('#remark').val();
                                                                    
                                                                    if(wzNum!=''){
                                                                        if(isIntNum(wzNum)==false){
                                                                            alert("需求数量必须填入整数");
                                                                            return;
                                                                        }
                                                                    }
                                                                    $.ajax({
                                                                        type: 'post',
                                                                        url: '${pageContext.request.contextPath}/hospital/hospital_need_info/update_submit',
                                                                            data:{
                                                                                "id":'${data.id}',
                                                                                    "wzType":wzType,
                                                                                    "wzName":wzName,
                                                                                    "wzNum":wzNum,
                                                                                    "remark":remark
                                                                                },
                                                                                success: function(result) {
                                                                                    if(result.code == 0){
                                                                                        alert(result.msg);
                                                                                        }else{
                                                                                            alert(result.msg);
                                                                                            self.location=document.referrer;
                                                                                        }
                                                                                    }
                                                                                });
                                                                            }
                                                                            
                                                                            
                                                                            
                                                                            </script>
                                                                            </body>
                                                                            </html>
