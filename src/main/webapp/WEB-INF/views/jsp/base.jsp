<%@ page contentType="text/html; charset=UTF-8" %>
<%
  String path = request.getContextPath();

  String basePath = path.length()==1?path:(path+"/");
  request.setAttribute("_basePath", basePath);
%>
<base href="${_basePath}"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script type="application/javascript" src="js/lib/seajs/sea.js"></script>
<script type="application/javascript" src="js/~/sys/base.js"></script>