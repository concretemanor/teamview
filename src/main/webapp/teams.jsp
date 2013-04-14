<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglibs.jsp" %>
<%@ include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
    <title>Team Availability</title>
    <script type="text/javascript"
            src="${ctx}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/teamview.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
  </head>
  <body>
    <h1>Teams</h1>

    <table class="teamTable">
      <c:forEach items="${actionBean.allTeams}" var="team">
	<tr>
	  <td class="namecolumn">${team.teamName}</td>
	  <td><stripes:link class="buttonLink" href="/a/admin/EditTeam"><stripes:param name="team.id" value="${team.id}" />Edit</stripes:link></td>
	  <td><stripes:link class="buttonLink" href="/a/admin/EditMembers"><stripes:param name="team.id" value="${team.id}" />Members</stripes:link></td>
	  <td><stripes:link class="buttonLink" href="/a/admin/DeleteTeam"><stripes:param name="team.id" value="${team.id}" />Delete</stripes:link></td>
	</tr>
      </c:forEach>
    </table>

   <stripes:form id="form" action="/a/admin/ListTeams">
        <stripes:text id="team-name" name="newTeam.teamName" class="namebox" />
	<stripes:submit id="save-button" disabled="true" class="buttonLink" name="add">Add</stripes:submit>
    </stripes:form>

    <div class="about"><a class="about" href="https://github.com/concretemanor/teamview/wiki">Powered By <fmt:message key="teamview.name"/> <fmt:message key="teamview.version"/></a></div>

    <script>
    $("#team-name").attr("autocomplete","off");
    installValidator("team-name",function (e) {
        return nonEmpty(e) && noMatching(e);
    });
  </script>

  </body>
</html>
