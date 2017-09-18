/**
 * Created by 友漾健康 on 2017/4/18.
 */


$(".tcdPageCode").createPage({/*分页*/
    pageCount:5,
    current:1,
    backFn:function(p){
        /*  alert(p);*/
        //单击回调方法，p是当前页码
    }
});



$("body").on("click",".deleteBtn",function(){//点击删除按钮
    $(".amc_popup").fadeIn(0);
    $(".amc_popup_content").fadeIn(0);
});


$("body").on("click",".adSureBtn",function(){//点击弹出框中的确定按钮
    //开始请求后台
    $(".amc_popup").fadeOut(0);
    $(".amc_popup_content").fadeOut(0);
});


$("body").on("click",".adCancelBtn",function(){//点击弹出框中的取消按钮

    $(".amc_popup").fadeOut(0);
    $(".amc_popup_content").fadeOut(0);
});











