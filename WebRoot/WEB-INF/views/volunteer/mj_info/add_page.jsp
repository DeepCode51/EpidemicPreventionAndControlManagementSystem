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
        <title>新增募捐-募捐信息</title>
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
            <legend>新增募捐-募捐信息</legend>
            <div class="layui-field-box">
            <div >
            
            
            <div class="layui-form-item layui-form-text" id="realNameParentContent">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
            <input type="text"  style="width:500px;display:inline"  placeholder="请输入姓名" id="realName" class="layui-input">
            </div>
            </div>
            
            <div class="layui-form-item layui-form-text" id="jkTimeParentContent">
            <label class="layui-form-label">捐款时间</label>
            <div class="layui-input-block">
            <input type="text" class="layui-input Wdate"  readonly="readonly"  style="width:500px;display:inline"   onFocus="WdatePicker({startDate: '%y-%M-%d' })"  placeholder="请输入捐款时间" id="jkTime">
                </div>
                </div>
                
                <div class="layui-form-item layui-form-text" id="jkAmountParentContent">
                <label class="layui-form-label">捐款金额</label>
                <div class="layui-input-block">
                <input type="text"  style="width:500px;display:inline"  placeholder="请输入捐款金额（请输入数字）" id="jkAmount" class="layui-input">
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
                            <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=1101"></script>
                                
                                
                                
                                <script type="text/javascript">
                                
                                
                                
                                $(function(){
                                    
                                    
                                    
                                })
                                
                                
                                
                                function submitData(){
                                    var realName= $('#realName').val();
                                    var jkTime= $('#jkTime').val();
                                    var jkAmount= $('#jkAmount').val();
                                    
                                    if(jkAmount!=''){
                                        if(isNum(jkAmount)==false){
                                            alert("捐款金额必须填入数字");
                                            return;
                                        }
                                    }
                                    $.ajax({
                                        type: 'post',
                                        url: '${pageContext.request.contextPath}/volunteer/mj_info/add_submit',
                                            data:{
                                                "realName":realName,
                                                "jkTime":jkTime,
                                                "jkAmount":jkAmount
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
