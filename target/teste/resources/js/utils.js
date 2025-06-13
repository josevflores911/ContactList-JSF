$(document).ready(function() {
    $('.cpfCnpjCell').each(function() {
        var val = $(this).text().trim();
        if(val.length === 11) {
            val = val.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");
        } else if (val.length === 14) {
            val = val.replace(/(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/, "$1.$2.$3/$4-$5");
        }
        $(this).text(val);
    });
});