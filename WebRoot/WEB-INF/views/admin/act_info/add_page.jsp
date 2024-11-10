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
        <title>新增-活动</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui/css/layui.css">
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/webupload/webuploader.css">
                
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
                <legend>新增-活动</legend>
                <div class="layui-field-box">
                <div >
                
                
                <div class="layui-form-item layui-form-text" id="actImgParentContent">
                <label class="layui-form-label">活动大图</label>
                <div class="layui-input-block">
                <div class="imgUpload" tip="请上传活动大图，数量不超过1"  red-tip=""  upload-num="1" init-val="" upload-type="1" id="actImg"></div>
                
                </div>
                </div>
                
                <div class="layui-form-item layui-form-text" id="actTitleParentContent">
                <label class="layui-form-label">活动标题</label>
                <div class="layui-input-block">
                <input type="text"  style="width:500px;display:inline"  placeholder="请输入活动标题" id="actTitle" class="layui-input">
                </div>
                </div>
                
                <div class="layui-form-item layui-form-text" id="actContentParentContent">
                <label class="layui-form-label">活动内容</label>
                <div class="layui-input-block">
                <div id="actContentDiv1" data-id="actContent"  class="toolbar" style="margin-top:3%;"></div>
                <div id="actContentDiv2"  class="text" style="min-height:300px;z-index:1"></div>
                
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
                    
                    
                    <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/wangeditor-3.0.17/wangEditor.min.js"></script>
                        <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/wangeditor-3.0.17/wangeditor_emotion.js"></script>
                            
                            
                            
                            <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.js"></script>
                                <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=1713"></script>
                                    <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/webupload/webuploader.js"></script>
                                        <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/webupload/upload.js"></script>
                                            
                                            
                                            
                                            <script type="text/javascript">
                                            
                                            
                                            var wangList=[];
                                            
                                            $(function(){
                                                
                                                createFileUpload('${pageContext.request.contextPath}');
                                                    var actContentMap = {};
                                                        var actContentEdit =window.wangEditor;
                                                        editor = new actContentEdit('#actContentDiv1', '#actContentDiv2');
                                                        editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/commonapi/imgUpload/imgUploadForWangEditor'
                                                            editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
                                                            editor.customConfig.uploadImgMaxLength = 5;
                                                            editor.customConfig.uploadImgTimeout = 30000;
                                                            editor.customConfig.uploadFileName = 'files'
                                                            editor.customConfig.emotions = [{ title: '默认',type: 'image',content:wangeditorEmotions}];
                                                                editor.create();
                                                                $('#actContentDiv2').css("z-index","1");
                                                                actContentMap.id='actContent';
                                                                actContentMap.edit=editor;
                                                                wangList.push(actContentMap);
                                                                editor.txt.html('');
                                                                
                                                                
                                                            })
                                                            
                                                            
                                                            
                                                            function getEditVal(name){
                                                                for(var i=0;i<wangList.length;i++){
                                                                    var dataId = wangList[i].id;
                                                                    if(dataId==name){
                                                                        return wangList[i].edit.txt.html();
                                                                    }
                                                                }
                                                                return '';
                                                            }
                                                            function submitData(){
                                                                var actImg=getUploadFileStr('actImg');
                                                                var actTitle= $('#actTitle').val();
                                                                var actContent=getEditVal('actContent');
                                                                
                                                                $.ajax({
                                                                    type: 'post',
                                                                    url: '${pageContext.request.contextPath}/admin/act_info/add_submit',
                                                                        data:{
                                                                            "actImg":actImg,
                                                                            "actTitle":actTitle,
                                                                            "actContent":actContent
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
