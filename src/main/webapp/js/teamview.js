function StatusGrid(ctx, tableId, $) {
    var editableGrid = new EditableGrid("TeamviewGridAttach");
    var valueMap;

    var setCellRenderer = function() {
	var cellRenderer = new CellRenderer({
	    render: function(cell,value) {
		cell.setAttribute("class",value ? value : "");
		cell.innerHTML = valueMap[value];
	    }});
	
	for (i=1; i<=5; i++) {
	    editableGrid.setCellRenderer(editableGrid.getColumnName(i),cellRenderer);
	}};

    editableGrid.tableLoaded = function() { 
	setCellRenderer();
	this.renderGrid(tableId, "statustable");
    };

    editableGrid.modelChanged = function(rowIndex, columnIndex, oldValue, newValue) {
	var val = 
            $('#htmlgrid')
            .find('tr:nth-child('+rowIndex+') td:nth-child('+columnIndex+')')
            .attr('id');
	$.ajax({
            type: "POST",
            url: ctx + "/a/Update",
            data: { date: $('#refDate').val(),
                    dayIndex: columnIndex,
                    cellValue: newValue,
                    personId: editableGrid.getRowId(rowIndex)}});
    };

    this.load = function(teamId,date) {
	$.ajax({type: "POST",
		url: ctx + "/a/Load",
		dataType: "json",
		data: { "teamId" : teamId,
			"date" : date },
		success: function(data,textStatus,jqXHR) {
		    valueMap = data.metadata[1].values;
		    editableGrid.load(data);
		    editableGrid.tableLoaded();
		}})
    };
}

function nonEmpty(element) {
    return element.val().length != 0;
}

function noMatching(element) {
    var name = $.trim(element.val());
    return document.evaluate("//td[@class='namecolumn' and text()='"+name+"']",
			     document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,
			     null).singleNodeValue == null;
}

function installValidator(textId,validator,whenValid) {
    var textElement = $("#"+textId);
    textElement.on("change past input", function(e) {
	var valid = validator(textElement);
	$("#save-button").prop("disabled",!valid);
	var formElement = $("#form");
	if (valid) {
            formElement.off("submit");
	    if (whenValid != null) {
		whenValid();
	    }
	}
	else {
            formElement.submit(function() {
		return false;
	    });
	}
    });
}
    