// HACK.  I would prefer to do this with CSS but I can't rely on Firefox's implementation of
// getComputedStyle
var colorMap = {'IN_OFFICE': ["black", "white"],
		'WORKING_FROM_HOME': ["black", "yellow"],
		'VACATION': ["white","red"]};

// give a status menu's SELECT element the same background color as the selected option
$('.statusmenu').each(function(index) {
   var element = $(this).children().filter(':selected').get(0);
   var colors = colorMap[element.value];
   $(this).css('color',colors[0]);
   $(this).css('backgroundColor',colors[1]);
});

// force a form submit after a status menu changes value
$('.statusmenu').change(function() {
   var element = $(this).children().filter(':selected');
   $('#cellId').val($(this).parent().attr('id'));
   $('#cellValue').val(element.val());
   $('#cellDate').val($('#refdate').val());
   $('#cellTeamId').val($('.teammenu').val());
   $('#event').val('changeStatus');
   $('#changeForm').submit();
});

// force a submit after team menu changes value
$('.teammenu').change(function() {
   var element = $(this).children().filter(':selected');
   $('#teamId').val(element.val());
   $('#teamDate').val($('#refdate').val());
   $('#event').val('changeTeam');
   $('#changeForm').submit();
});
