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
      <script type="text/javascript" 
               src="${pageContext.request.contextPath}/js/editablegrid-2.0.1.js"></script>
      <script>
            window.onload = function() {
                editableGrid = new EditableGrid("DemoGridAttach"); 

                editableGrid.tableLoaded = function() { this.renderGrid("tablecontent", "statustable"); };
                editableGrid.loadJSON("${pageContext.request.contextPath}/load.action?" +
                                      "teamId=" + $(".teammenu").val() +
                                      "&date=" + $("#refDate").val());

                editableGrid.modelChanged = function(rowIndex, columnIndex, oldValue, newValue) {
                    var val = 
                       $('#htmlgrid')
                          .find('tr:nth-child('+rowIndex+') td:nth-child('+columnIndex+')')
                          .attr('id');
                    $.ajax({
                       type: "POST",
                       url: "update.action",
                       data: { date: $('#refDate').val(),
                               dayIndex: columnIndex,
                               cellValue: newValue,
                               personId: editableGrid.getRowId(rowIndex)}});
                }
            } 
        </script>
      <link rel="stylesheet" type="text/css" href="css/style.css" />
  </head>
  <body>
    <stripes:form action="/changeteam.action">
      <stripes:label for="team"/>: <stripes:select class='teammenu' name='team' value="${actionBean.teamId}">
        <c:forEach items="${actionBean.allTeams}" var="team" varStatus="loop">
          <stripes:option value="${team.id}">${team.teamName}</stripes:option>
        </c:forEach>
      </stripes:select>
    </stripes:form>
    <h1>WHERE WILL YOU BE?</h1>
    <stripes:form action="/list.action">
      <div class='date-nav'><stripes:submit name="view" value="Today"/><stripes:submit name="back" value="<" /><fmt:formatDate value="${actionBean.date}" dateStyle="short" /> - <fmt:formatDate value="${actionBean.lastDate}" dateStyle="short" /><stripes:submit name="forward" value=">" /></div>
      <stripes:hidden id="refDate" name="date" />
      <stripes:hidden id="teamId2" name="teamId" value="${actionBean.teamId}" />
    </stripes:form>
    <div id='tablecontent'></div>

    <stripes:form id="changeForm" action="/changeteam.action">
      <stripes:hidden id="teamId" name="teamId" />
      <stripes:hidden id="teamDate" name="date" />
    </stripes:form>
  </body>
</html>
