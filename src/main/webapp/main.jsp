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
           <stripes:label for="teams"/>: <stripes:select class='team-menu' name='teams'><stripes:option value="1">Team A</stripes:option><stripes:option value="2">Team B</stripes:option><stripes:option value="3">Team C</stripes:option></stripes:select>
       </stripes:form>
    <h1>WHERE WILL YOU BE?</h1>
    <stripes:form beanclass="concretemanor.tools.teamview.actions.ListActionBean">
        <stripes:hidden id="refdate" name="date" value="${actionBean.date}" />	
<div class='date-nav'><stripes:submit name="view" value="Today"/><stripes:submit name="back" value="<" /><fmt:formatDate value="${actionBean.date}" dateStyle="short" /> - <fmt:formatDate value="${actionBean.lastDate}" dateStyle="short" /><stripes:submit name="forward" value=">" /></div>
        <table>
	    <tr class="date-heading">
	        <th></th>
	        <th>Mon <fmt:formatDate value="${actionBean.monday}" pattern="MM/dd" /></th>
	        <th>Tue <fmt:formatDate value="${actionBean.tuesday}" pattern="MM/dd" /></th>
	        <th>Wed <fmt:formatDate value="${actionBean.wednesday}" pattern="MM/dd" /></th>
	        <th>Thu <fmt:formatDate value="${actionBean.thursday}" pattern="MM/dd" /></th>
	        <th>Fri <fmt:formatDate value="${actionBean.friday}" pattern="MM/dd" /></th>
	    </tr>
	    <c:forEach items="${actionBean.allPeople}" var="person" varStatus="loop">
	      <tr>
		<td class='person-name'>${person.name}</td>
		<td class='status' id="0${person.id}">
		   <stripes:select class="statusmenu" name="status" value='${person.status[0]}'>
		      <stripes:option value="IN_OFFICE">In Office</stripes:option>
		      <stripes:option value="WORKING_FROM_HOME">Working From Home</stripes:option>
		      <stripes:option value="VACATION">Vacation</stripes:option>
		   </stripes:select>
		</td>
		<td class='status' id="1${person.id}">
		   <stripes:select class="statusmenu" name="status"  value='${person.status[1]}'>
		      <stripes:option value="IN_OFFICE">In Office</stripes:option>
		      <stripes:option value="WORKING_FROM_HOME">Working From Home</stripes:option>
		      <stripes:option value="VACATION">Vacation</stripes:option>
		   </stripes:select>
		</td>
		<td class='status' id="2${person.id}">
		   <stripes:select class="statusmenu" name="status"  value='${person.status[2]}'>
		      <stripes:option value="IN_OFFICE">In Office</stripes:option>
		      <stripes:option value="WORKING_FROM_HOME">Working From Home</stripes:option>
		      <stripes:option value="VACATION">Vacation</stripes:option>
		   </stripes:select>
		</td>
		<td class='status' id="3${person.id}">
		   <stripes:select class="statusmenu" name="status"  value='${person.status[3]}'>
		      <stripes:option value="IN_OFFICE">In Office</stripes:option>
		      <stripes:option value="WORKING_FROM_HOME">Working From Home</stripes:option>
		      <stripes:option value="VACATION">Vacation</stripes:option>
		   </stripes:select>
		</td>
		<td class='status' id="4${person.id}">
		   <stripes:select class="statusmenu" name="status"  value='${person.status[4]}'>
		      <stripes:option value="IN_OFFICE">In Office</stripes:option>
		      <stripes:option value="WORKING_FROM_HOME">Working From Home</stripes:option>
		      <stripes:option value="VACATION">Vacation</stripes:option>
		   </stripes:select>
		</td>
	      </tr>
            </c:forEach>
        </table>
    </stripes:form>
    <stripes:form id="cellForm" beanclass="concretemanor.tools.teamview.actions.ListActionBean">
    	<stripes:hidden id="cellId" name="cellId" />
    	<stripes:hidden id="cellValue" name="cellValue" />
	<stripes:hidden id="date" name="date" />
    	<stripes:hidden name="event" value="update" />
    </stripes:form>
  </body>
</html>
