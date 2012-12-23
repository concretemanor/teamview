// force a submit after team menu changes value
$('.teammenu').change(function() {
    var element = $(this).children().filter(':selected');
    $('#teamId').val(element.val());
    $('#teamDate').val($('#refDate').val());
    $('#changeForm').submit();
});


var editableGrid = new EditableGrid("DemoGridAttach"); 

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
    this.renderGrid("tablecontent", "statustable"); 
};

$.ajax({type: "POST",
	url: "load.action",
	dataType: "json",
	data: { "teamId" : $(".teammenu").val(),
		"date" : $("#refDate").val() },
	success: function(data,textStatus,jqXHR) {
	    valueMap = data.metadata[1].values;
	    editableGrid.load(data);
	    editableGrid.tableLoaded();
	}});

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

