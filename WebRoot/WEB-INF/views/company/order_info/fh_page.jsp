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
        <title>发货-厂商订单</title>
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
            <legend>发货-厂商订单</legend>
            <div class="layui-field-box">
            <div >
            
            
            <div class="layui-form-item layui-form-text" id="carIdParentContent">
            <label class="layui-form-label">分配汽车</label>
            <div class="layui-input-block">
            <select  id="carId" style="height:30px;width:500px;display:inline" >
            <c:forEach items="${carInfoList}" var="item">
                <c:if test="${item.id==data.carId}">
                    <option value="${item.id}" selected>${item.name}</option>
                        </c:if>
                        <c:if test="${item.id!=data.carId}">
                            <option value="${item.id}">${item.name}</option>
                                </c:if>
                                </c:forEach>
                                </select>
                                
                                </div>
                                </div>
                                
                                <div class="layui-form-item layui-form-text" id="contactNameParentContent">
                                <label class="layui-form-label">联系人姓名</label>
                                <div class="layui-input-block">
                                <input type="text"  style="width:500px;display:inline" value="${data.contactName}" placeholder="请输入联系人姓名" id="contactName" class="layui-input">
                                    </div>
                                    </div>
                                    
                                    <div class="layui-form-item layui-form-text" id="contactCelParentContent">
                                    <label class="layui-form-label">联系人电话</label>
                                    <div class="layui-input-block">
                                    <input type="text"  style="width:500px;display:inline" value="${data.contactCel}" placeholder="请输入联系人电话" id="contactCel" class="layui-input">
                                        </div>
                                        </div>
                                        
                                        <div class="layui-form-item layui-form-text" id="outTimeParentContent">
                                        <label class="layui-form-label">发货时间</label>
                                        <div class="layui-input-block">
                                        <input type="text" class="layui-input Wdate"  readonly="readonly"  style="width:500px;display:inline" value="${data.outTime}"  onFocus="WdatePicker({startDate: '%y-%M-%d 00:00:00' ,dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate: true })"  placeholder="请输入发货时间" id="outTime">
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
                                                
                                                <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/My97DatePicker/4.8/WdatePicker.js"></script>
                                                    
                                                    
                                                    
                                                    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.js"></script>
                                                        <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=4434"></script>
                                                            
                                                            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/selectSearch/jquery.searchableSelect.css?d=129339" />
                                                                <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/selectSearch/jquery.searchableSelect.js?d=1293393"></script>
                                                                    
                                                                    
                                                                    <script type="text/javascript">
                                                                    
                                                                    
                                                                    
                                                                    $(function(){
                                                                        
                                                                        $('#carId').next().remove();
                                                                        $('#carId').searchableSelect();
                                                                        
                                                                        
                                                                    })
                                                                    
                                                                    
                                                                    
                                                                    function submitData(){
                                                                        var carId= $('#carId').val();
                                                                        var contactName= $('#contactName').val();
                                                                        var contactCel= $('#contactCel').val();
                                                                        var outTime= $('#outTime').val();
                                                                        
                                                                        $.ajax({
                                                                            type: 'post',
                                                                            url: '${pageContext.request.contextPath}/company/order_info/fh_submit',
                                                                                data:{
                                                                                    "id":'${data.id}',
                                                                                        "needId":"${data.needId}",			"carId":carId,
                                                                                            "contactName":contactName,
                                                                                            "contactCel":contactCel,
                                                                                            "outTime":outTime
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
