<!--
@date 2016/3/28
@author Carl
@note

@depend
@modify
版权所有.(c)2008-2016.广州市森锐电子科技有限公司
-->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>上传图片</title>
</head>
<body>
<form action="${s:mvcUrl('IDC#uploadFile').build()}" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <p>
        文件名：<s:bind path="file.name">
            <input type="text" name="${status.expression}" value="${status.value}">
            <font color="red">${status.errorMessage}</font>
        </s:bind>
    </p>


    <input type="submit" value="Submit"/>
</form>
</body>
</html>