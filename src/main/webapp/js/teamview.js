// force a submit after team menu changes value
$('.teammenu').change(function() {
   var element = $(this).children().filter(':selected');
   $('#teamId').val(element.val());
   $('#teamDate').val($('#refDate').val());
   $('#changeForm').submit();
});
