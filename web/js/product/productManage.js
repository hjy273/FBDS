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


$("#stareDate").datetimepicker({/*开始时间*/
    format: "yyyy-mm-dd",
    autoclose: true,
    todayBtn: true,
    language: 'zh-CN',//中文，需要引用zh-CN.js包
    startView: 2,//月视图
    minView: 2//日期时间选择器所能够提供的最精确的时间选择视图
}).on('changeDate',function(e){
    var startTime = e.date;
    $('#endDate').datetimepicker('setStartDate',startTime);
    var endTime=$("#endDate").val();
    var oDate1 = new Date($("#stareDate").val());
    var oDate2 = new Date(endTime);
    if (oDate1.getTime() > oDate2.getTime()){
        $("#endDate").val($("#stareDate").val());
    }
});


$("#endDate").datetimepicker({/*结束时间*/
    format: "yyyy-mm-dd",
    autoclose: true,
    todayBtn: true,
    language: 'zh-CN',//中文，需要引用zh-CN.js包
    startView: 2,//月视图
    minView:2//日期时间选择器所能够提供的最精确的时间选择视图
});

 $(".tcdPageCode").createPage({/*分页*/
    pageCount:5,
    current:1,
    backFn:function(p){
        /*  alert(p);*/
        //单击回调方法，p是当前页码
    }
});
