$(function(){
    // Activate mobile nav toggle button
    $(".button-collapse").sideNav({edge: 'right'});
});
function copyToClipboard(element) {
    var $temp = $("<input>");
    $("body").append($temp);
    $temp.val($(element).text()).select();
    document.execCommand("copy");
    $temp.remove();
}

