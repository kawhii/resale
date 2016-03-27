<%@ page contentType="text/html; charset=UTF-8" %>
<%
  String path = request.getContextPath();

  String basePath = path.length()==1?path:(path+"/");
  request.setAttribute("_basePath", basePath);
%>
<base href="${_basePath}"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" href="styles/common/bootstrap.min.css"/>
<link href="styles/common/style.css" rel="stylesheet" type="text/css" media="all"/>
<link rel="stylesheet" href="styles/common/jquery.uls.css"/>
<link rel="stylesheet" type="text/css" href="styles/common/font-awesome.min.css"/>
<%--
<script type="application/javascript" src="js/lib/seajs/sea.js"></script>
<script type="application/javascript" src="js/~/sys/base.js"></script>--%>
<script type="application/javascript" src="js/lib/jquery/jquery.min.js"></script>
