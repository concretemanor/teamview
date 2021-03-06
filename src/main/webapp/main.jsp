<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglibs.jsp" %>
<%@ include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
      <title>Team Availability</title>
      <script type="text/javascript"
              src="${ctx}/js/jquery-1.8.3.min.js"></script>
      <script type="text/javascript" 
               src="${ctx}/js/editablegrid-2.0.1.js"></script>
      <script type="text/javascript"
              src="${ctx}/js/teamview.js"></script>
      </script>
      <link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
  </head>
  <body>
    <stripes:form action="/a/ChangeTeam">
      <stripes:label for="team"/>: <stripes:select class='teammenu' name='team' value="${actionBean.teamId}">
        <c:forEach items="${actionBean.allTeams}" var="team" varStatus="loop">
          <stripes:option value="${team.id}">${team.teamName}</stripes:option>
        </c:forEach>
      </stripes:select>
    </stripes:form>
    <h1 class="mainheading">WHERE WILL YOU BE?</h1>
    <stripes:form action="/a/List">
      <div class='date-nav'><stripes:submit name="view" value="Today"/><stripes:submit name="back" value="<" /><fmt:formatDate value="${actionBean.date}" dateStyle="short" /> - <fmt:formatDate value="${actionBean.lastDate}" dateStyle="short" /><stripes:submit name="forward" value=">" /></div>
      <stripes:hidden id="refDate" name="date" />
      <stripes:hidden id="teamId2" name="teamId" value="${actionBean.teamId}" />
    </stripes:form>
    <div id='tablecontent'></div>

    <stripes:form id="changeForm" action="/a/ChangeTeam">
      <stripes:hidden id="teamId" name="teamId" />
      <stripes:hidden id="teamDate" name="date" />
    </stripes:form>

    <script>
        $('.teammenu').change(function() {
            var element = $(this).children().filter(':selected');
            $('#teamId').val(element.val());
            $('#teamDate').val($('#refDate').val());
            $('#changeForm').submit();
        });
        var sg = new StatusGrid("${ctx}","tablecontent",jQuery);
	sg.load($("#teamId2").val(), $("#refDate").val());
    </script>
    <div class="about"><a class="about" href="https://github.com/concretemanor/teamview/wiki">Powered By <fmt:message key="teamview.name"/> <fmt:message key="teamview.version"/></a></div>
  </body>
</html>
