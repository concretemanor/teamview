<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
      <title>Team Availability</title>
      <script type="text/javascript"
              src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
      <script>
         $.getScript("${pageContext.request.contextPath}/js/teamview.js", function(jqxhr,settings,exception){});
      </script>
      <link rel="stylesheet" type="text/css" href="css/style.css" />
  </head>
  <body>
       <stripes:form beanclass="concretemanor.tools.teamview.actions.ListActionBean">
           <stripes:label for="team"/>: <stripes:select class='teammenu' name='team' value="${actionBean.teamId}">
           <c:forEach items="${actionBean.allTeams}" var="team" varStatus="loop">
           	  <stripes:option value="${team.id}">${team.teamName}</stripes:option>
           </c:forEach>
           </stripes:select>
       </stripes:form>
    <h1>WHERE WILL YOU BE?</h1>
    <stripes:form beanclass="concretemanor.tools.teamview.actions.ListActionBean">
        <stripes:hidden id="refdate" name="date" value="${actionBean.date}" />	
<div class='date-nav'><stripes:submit name="view" value="Today"/><stripes:submit name="back" value="<" /><fmt:formatDate value="${actionBean.date}" dateStyle="short" /> - <fmt:formatDate value="${actionBean.lastDate}" dateStyle="short" /><stripes:submit name="forward" value=">" /></div>
        <stripes:hidden name="teamId" value="${actionBean.teamId}" />
        <table cellpadding="2" cellspacing="2">
	    <tr class="date-heading">
	        <th></th>
	        <th>Mon <fmt:formatDate value="${actionBean.monday}" pattern="MM/dd" /></th>
	        <th>Tue <fmt:formatDate value="${actionBean.tuesday}" pattern="MM/dd" /></th>
	        <th>Wed <fmt:formatDate value="${actionBean.wednesday}" pattern="MM/dd" /></th>
	        <th>Thu <fmt:formatDate value="${actionBean.thursday}" pattern="MM/dd" /></th>
	        <th>Fri <fmt:formatDate value="${actionBean.friday}" pattern="MM/dd" /></th>
	    </tr>
	    <c:forEach items="${actionBean.weekStatuses}" var="weekStatus" varStatus="weekLoop">
	      <tr>
		<td class='person-name'>${weekStatus.person.name}</td>
		<c:forEach items="${weekStatus.statuses}" var="status" varStatus="statusLoop">
		   <td class='status' id="${statusLoop.count}${weekStatus.person.id}">
		     <stripes:select class="statusmenu" name="status" value='${status}'>
		       <stripes:option value="IN_OFFICE">In</stripes:option>
		       <stripes:option value="WORKING_REMOTELY">Remote</stripes:option>
		       <stripes:option value="IN_TRAINING">Training</stripes:option>
		       <stripes:option value="VACATION">Off</stripes:option>
		     </stripes:select>
		   </td>
                </c:forEach>
	      </tr>
            </c:forEach>
        </table>
    </stripes:form>
    <stripes:form id="changeForm" beanclass="concretemanor.tools.teamview.actions.ListActionBean">
    	<stripes:hidden id="cellId" name="cellId" />
    	<stripes:hidden id="cellValue" name="cellValue" />
	<stripes:hidden id="cellDate" name="date" />
    	<stripes:hidden id="event" name="event" />
	<stripes:hidden id="teamId" name="teamId" />
        <stripes:hidden id="teamDate" name="date" />
    </stripes:form>
  </body>
</html>
