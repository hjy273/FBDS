/**
 * Created by liuyong on 2017/1/13.
 * 用于对体测数据页面进行修改
 */
$(".tcdPageCode").createPage({/*分页*/
    pageCount:5,
    current:1,
    backFn:function(p){
        /*  alert(p);*/
        //单击回调方法，p是当前页码
    }
});
$(".form_datetime").datetimepicker({/*时间*/
    format: "yyyy-mm-dd",
    autoclose: true,
    todayBtn: true,
    todayHighlight: true,
    showMeridian: true,
    pickerPosition: "bottom-left",
    language: 'zh-CN',//中文，需要引用zh-CN.js包
    startView: 2,//月视图
    minView: 2//日期时间选择器所能够提供的最精确的时间选择视图
});


$(".form_datetime1").datetimepicker({/*搜索体测时间*/
    format: "yyyy-mm-dd",
    autoclose: true,
    todayBtn: true,
    todayHighlight: true,
    showMeridian: true,
    pickerPosition: "bottom-left",
    language: 'zh-CN',//中文，需要引用zh-CN.js包
    startView: 2,//月视图
    minView: 2//日期时间选择器所能够提供的最精确的时间选择视图
});

$(document).ready(function(){/*点击查看体测数据记录按钮*/
    $(".lookOverBtn").on("click",function(){
        $(".testDataShowList").addClass("testDataShowListHover");
        $(".dataShowList").addClass("dataShowListHover");
    });
});

$(document).ready(function(){/*点击箭头返回上一级菜单*/
    $(".returnPre").on("click",function(){
        $(".testDataShowList").removeClass("testDataShowListHover");
        $(".dataShowList").removeClass("dataShowListHover")
    });
});

$(document).ready(function(){/*点击查看进入体测数据详情展示*/
    $(".lookDetailsBtn").on("click",function(){
        $(".detailsDataShow").addClass("detailsDataShowHover");
        $(".testDataShowList").removeClass("testDataShowListHover");
        loadDetailsData();
    });
});

$(document).ready(function(){/*页面加载事件*/
    $("html").fadeIn(300)
});

$(document).ready(function(){/*重置按钮*/
    $(".resetBtn").on("click",function(){
        $("#searchName").val("");
        $("#searchPhone").val("");
        $("#searchDate").val("");
    })
});


$(document).keydown(function(event){/*键盘事件进行查询*/
    if(event.keyCode==13){
        getInputVal();
    }
});
$(document).ready(function(){/*键盘事件进行查询*/
    $(".searchBtn").on("click",function(){
        getInputVal();
    });
});

function getInputVal(){/*获取输入框的值并进行查询*/
    var myArr={
        userName:$("#searchName").val(),
        userPhone:$("#searchPhone").val(),
        userDate:$("#searchDate").val()
    };
    console.log(myArr.userName)
}



    function loadDetailsData(){/*身体成分分析数据获取和加载动效*/
        var totalWidth=$(window).width()*0.65*0.678*0.96;
        var userBodyNumber={
            userWidth:160,
            userSkeletalMuscle:89,
            userBodyFat:60
        };
        $(".userWeight").css({/*体重*/
            width:((userBodyNumber.userWidth-40)/165)*totalWidth,
            transition:"width .5s ease-out 0.3s"
        });
        $(".userSkeletalMuscle").css({/*骨骼肌指数*/
            width:((userBodyNumber.userSkeletalMuscle-60)/110)*totalWidth,
            transition:"width .5s ease-out 0.3s"
        });
        if(userBodyNumber.userBodyFat<=100){/*体脂肪宽度*/
            $(".userBodyFat").css({
                width:((userBodyNumber.userBodyFat-20)/220)*totalWidth,
                transition:"width .5s ease-out 0.3s"
            })
        }else if(userBodyNumber.userBodyFat>100){
            $(".userBodyFat").css({
                width:((80)/220)*totalWidth+(((userBodyNumber.userBodyFat-100)/660)*totalWidth),
                transition:"width .5s ease-out 0.3s"
            })
        }
    }



$(".deleteBtn").on("click",function(){/*删除按钮*/
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

function changeUrl3(){
    window.location.href="newBodyTestData.html"
}