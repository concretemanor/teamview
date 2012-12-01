<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
      <title>Team Availability</title>
      <script type="text/javascript"
              src="${pageContext.request.contextPath}/teamview/jquery-1.8.3.min.js"></script>
      <script>
         $.getScript("${pageContext.request.contextPath}/teamview/teamview.js", function(jqxhr,settings,exception){});
      </script>
  </head>
  <body>
    <h1>Team Availability</h1>

    <stripes:form action="">
        <div><stripes:button name="today" value="Today" onclick="javascript:alert('hello world');"/><stripes:button name="prevWeek" value="<" /><stripes:button name="nextWeek" value=">" /> Nov 11-17, 2012 </div>
        <table border="1">
            <tr>
                <td>John</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
            </tr>
            <tr>
                <td>Mary</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
            </tr>
            <tr>
                <td>Shinta</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
                <td class='status'>Vacation</td>
                <td class='status'>Vacation</td>
            </tr>
            <tr>
                <td>Sanjay</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
            </tr>
            <tr>
                <td>Xiaoping</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
                <td class='status'>Working</td>
            </tr>
<!--
            <tr>
                <td colspan="2">
                    <stripes:submit name="add" value="Add"
                        onclick="invoke(this.form, this.name, 'result');"/>
                    <stripes:submit name="divide" value="Divide"
                        onclick="invoke(this.form, this.name, 'result');"/>
                </td>
            </tr>
-->
        </table>
    </stripes:form>
  </body>
</html>