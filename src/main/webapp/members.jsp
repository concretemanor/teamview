<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglibs.jsp" %>
<%@ include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
    <title>Team Availability</title>
    <script type="text/javascript"
            src="${ctx}/js/jquery-1.9.1.js"></script>
    <script type="text/javascript"
            src="${ctx}/js/jquery-ui-1.10.2.custom.js"></script>
    <script type="text/javascript" src="${ctx}/js/teamview.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/css/jquery-ui-1.10.2.custom.css" />
  </head>
  <body>
    <h1>Team Members</h1>

    <table class="memberTable">
      <c:forEach items="${actionBean.members}" var="person">
	<tr>
	  <td class="namecolumn">${person.name}</td>
	  <td><stripes:link class="buttonLink" href="/a/admin/EditMembers"><stripes:param name="team.id" value="${actionBean.team.id}" /><stripes:param name="thisMember.id" value="${person.id}" /><stripes:param name="preRemove" value="" />Remove</stripes:link></td>
	</tr>
      </c:forEach>
    </table>

    <stripes:form id="form" action="/a/admin/EditMembers">
        <stripes:text maxlength="255" id="this-member-name" name="thisMember.name" class="namebox"/>
	<stripes:hidden id="this-member-id" name="thisMember.id" />
	<stripes:hidden name="team.id" />
	<stripes:submit id="save-button" disabled="true" class="buttonLink" name="add">Add</stripes:submit>
    </stripes:form>

    <stripes:link class="buttonLink" href="/a/admin/ListTeams">Back To Teams</stripes:link>

    <div class="about"><a class="about" href="https://github.com/concretemanor/teamview/wiki">Powered By <fmt:message key="teamview.name"/> <fmt:message key="teamview.version"/></a></div>

    <script>
function autocomplete() {
    $.ajax({type: "GET",
            url: "${ctx}/a/admin/LoadNonMembers",
            dataType: "json",
            data: { "team.id" : ${actionBean.team.id},
                    prefix : $("#this-member-name").val(),
		    maxRows : 15 },
            success: function(data,textStatus,jqXHR) {
	        $("#this-member-name").autocomplete({source: data,
                                                     select: function(event,ui) {
						       	     $("#this-member-name").val(ui.item.label);
							     return false;
						         }
						    });
	    }
	   });
}

      // stripes:text tag does not recognize autocomplete attribute so have to
      // do this instead
      $("#this-member-name").attr("autocomplete","off");
      installValidator("this-member-name", function (element) {
              return nonEmpty(element) && noMatching(element);
          },
	  autocomplete);
    </script>
  </body>
</html>
