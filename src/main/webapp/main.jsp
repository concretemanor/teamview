<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<jsp:useBean id="personManager" scope="page"  
           class="concretemanor.tools.teamview.PersonManager"/><
html>
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
    <h1>Team Availability</h1>

    <stripes:form action="">
        <div><stripes:button name="today" value="Today" onclick="javascript:alert('hello world');"/><stripes:button name="prevWeek" value="<" /><stripes:button name="nextWeek" value=">" /> Nov 11-17, 2012 </div>
        <table border="1">
	    <tr class="date-heading">
	        <td></td>
	        <td>Mon 11/12</td>
		<td>Tue 11/13</td>
		<td>Wed 11/14</td>
		<td>Thu 11/15</td>
		<td>Fri 11/16</td>
	    </tr>
	    <c:forEach person="$personManager.allPeople" var="person" varStatus="loop">
	      <tr>
		<td>${person.name}</td>
		<td class='status'>${person.status[0]}</td>
		<td class='status'>${person.status[1]}</td>
		<td class='status'>${person.status[2]}</td>
		<td class='status'>${person.status[3]}</td>
		<td class='status'>${person.status[4]}</td>
	      </tr>
            </c:forEach>
        </table>
    </stripes:form>
  </body>
</html>
