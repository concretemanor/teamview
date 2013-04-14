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
            src="${ctx}/js/teamview.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
  </head>
  <body>
    <h1>Edit Team</h1>
    <stripes:errors />
    <stripes:form id="form" action="/a/admin/EditTeam">
      <stripes:label for="team.teamName" />:<stripes:text id="team-name" name="team.teamName" maxlength="255" />
      <stripes:hidden name="team.id" />
      <stripes:submit class="buttonLink" id="save-button" name="save" value="Save"/>
      <stripes:link class="buttonLink" href="/a/admin/ListTeams">Cancel</stripes:link>
    </stripes:form>

    <div class="about"><a class="about" href="https://github.com/concretemanor/teamview/wiki">Powered By <fmt:message key="teamview.name"/> <fmt:message key="teamview.version"/></a></div>
    <script>
    $("#team-name").attr("autocomplete","off");
    installValidator("team-name",nonEmpty);
  </script>
  </body>
</html>
