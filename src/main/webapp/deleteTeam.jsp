<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglibs.jsp" %>
<%@ include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
    <title>Team Availability</title>
    <script type="text/javascript"
            src="${ctx}/js/jquery-1.8.3.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
  </head>
  <body>
    <h1>Delete Team</h1>

    <p>Really delete Team ${actionBean.team.teamName}?</p>
    <stripes:form action="${ctx}/a/admin/DeleteTeam">
      <stripes:hidden name="team.id" />
      <stripes:submit class="buttonLink" name="save" value="Delete"/>
      <stripes:link class="buttonLink" href="${ctx}/a/admin/ListTeams">Cancel</stripes:link>
    </stripes:form>

    <div class="about"><a class="about" href="https://github.com/concretemanor/teamview/wiki">Powered By <fmt:message key="teamview.name"/> <fmt:message key="teamview.version"/></a></div>
  </body>
</html>
