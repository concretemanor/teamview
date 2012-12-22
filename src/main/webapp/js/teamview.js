// force a form submit after a status menu changes value
// $('.statusmenu').change(function() {
//    var element = $(this).children().filter(':selected');
//    $('#cellId').val($(this).parent().attr('id'));
//    $('#cellValue').val(element.val());
//    $('#cellDate').val($('#refdate').val());
//    $('#cellTeamId').val($('.teammenu').val());
//    $('#event').val('changeStatus');
//    $('#changeForm').submit();
// });

// force a submit after team menu changes value
$('.teammenu').change(function() {
   var element = $(this).children().filter(':selected');
   $('#teamId').val(element.val());
   $('#teamDate').val($('#refdate').val());
   $('#event').val('changeTeam');
   $('#changeForm').submit();
});
