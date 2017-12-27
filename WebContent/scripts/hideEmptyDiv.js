// this .js not needed atm

$('.blogBackgroundColor').filter(function() {
        return $.trim($(this).text()) === ''
}).hide()