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
    <h1>Remove Member</h1>

    <p>Really remove ${actionBean.thisMember.name} from ${actionBean.team.teamName}?</p>
    <stripes:form action="/a/admin/EditMembers">
      <stripes:hidden name="team.id" />
      <stripes:hidden id="" name="thisMember.id" />
      <stripes:submit name="remove" value="Remove"/>
      <stripes:submit name="preEdit" value="Cancel" />
    </stripes:form>

    <div class="about"><a class="about" href="https://github.com/concretemanor/teamview/wiki">Powered By <fmt:message key="teamview.name"/> <fmt:message key="teamview.version"/></a></div>
  </body>
</html>
