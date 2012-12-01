$('.status').html('<select class="statusmenu" name="status"><option value="in-office">In Office</option><option value="from-home">Working From Home</option><option value="vacation">Vacation</option></select>');
$('.statusmenu').change(function() {
   var x = $(this).children().filter(':selected').val()
   alert("new value is " + x);
});
