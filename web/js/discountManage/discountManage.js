$(".deleteDataBtn").on("click",function(){/*删除按钮*/
    $(".amc_popup").fadeIn(300);
    $(".amc_popup_content").fadeIn(0);
    document.documentElement.style.overflow='hidden';
    $(".amc_popup_content .amc_tips > span").html("确认要进行此操作！");
});
$(".amc_cancel_btn").on("click",function(){/*取消按钮*/
        $(".amc_popup").fadeOut(300);
    $(".amc_popup_content").fadeOut(0);
    document.documentElement.style.overflow='auto';
    $(".amc_popup_content .amc_tips > span").html("");
});


 $(function () { $("[data-toggle='tooltip']").tooltip(); });

  $(".tcdPageCode").createPage({/*分页*/
    pageCount:5,
    current:1,
    backFn:function(p){
        /*  alert(p);*/
        //单击回调方法，p是当前页码
    }
});

  /* 点击重置按钮 */
$("#resetRemoveBtn").on("click",function(){  
    $(':input').val("");  
    $("select.selectpicker").each(function(){  
        $(this).selectpicker('val',$(this).find('option:first').val());   
                       //重置bootstrap-select显示  5        
        $(this).find("option").attr("selected", false);                    
                        //重置原生select的值  6         
        $(this).find("option:first").attr("selected", true);     
    });  
 });
