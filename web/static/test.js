var test = document.getElementById("test");
test.onclick= function () {
    $.ajax({
        url : '/register',
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