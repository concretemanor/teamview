$('.statusmenu').change(function() {
   var element = $(this).children().filter(':selected');
   $('#cellId').val($(this).parent().attr('id'));
   $('#cellValue').val(element.val());
   $('#date').val($('#refdate').val());
   $('#cellForm').submit();
});
