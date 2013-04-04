<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
      <title>Team Availability</title>
          <script type="text/javascript"
              src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
      <script type="text/javascript" 
               src="${pageContext.request.contextPath}/js/editablegrid-2.0.1.js"></script>
      <script type="text/javascript"
               src="${pageContext.request.contextPath}/js/teamview.js"></script>
  </head>
  <body>
      <link rel="stylesheet" type="text/css" href="css/style.css" />
    <h1>WHERE WILL YOU BE?</h1>
    <stripes:form action="/embedlist.action">
      <div class='date-nav'><stripes:submit name="view" value="Today"/><stripes:submit name="back" value="<" /><fmt:formatDate value="${actionBean.date}" dateStyle="short" /> - <fmt:formatDate value="${actionBean.lastDate}" dateStyle="short" /><stripes:submit name="forward" value=">" /></div>
      <stripes:hidden id="refDate" name="date" />
      <stripes:hidden id="teamId2" name="teamId" value="${actionBean.teamId}" />
    </stripes:form>
    <div id='tablecontent'></div>

    <stripes:form id="changeForm" action="/changeteam.action">
      <stripes:hidden id="teamId" name="teamId" />
      <stripes:hidden id="teamDate" name="date" />
    </stripes:form>
    <script>
        var sg = new StatusGrid("tablecontent", jQuery);
        sg.load(${actionBean.teamId}, $("#refDate").val());
    </script>
    
  </body>
</html>
