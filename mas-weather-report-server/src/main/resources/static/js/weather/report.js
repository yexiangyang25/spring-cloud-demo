$(function () {
    $("#selectCityId").change(function () {
        var cityId = $("#selectCityId").val();
        var url = '/weatherReport/city/' + cityId;
        window.location.href = url;
    });
});