var test = document.getElementById("test");
test.onclick= function () {
    $.ajax({
        url : '/insertBuyerWantedBook',
        type :'GET',
        cache:false,
        dataType:'json',
        data:{
        },
        success:function(data) {
            alert(data.message);
        }
    })
}