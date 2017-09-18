/**
 * 仿淘宝搜索条
 * author yue
 */
(function($){
	//扩展新方法

	$.fn.complete = function(params){
		var currentIndex = -1;//li元素当前索引
		var matchArray = [];//匹配项数组
		//params默认值
		//创建输入框
		this.each(function(){
			var searchContainer = $('<div></div>')
				.addClass('autocomplete-container')
				.css({'width':params.width+'px','height':params.height+20+'px'});
			/*var input = $('<input type="text">')
			 .attr({'placeholder':params.placeholder,'name':params.name})
			 .addClass('autocomplete-input')
			 .css({'width':params.width,'height':params.height});*/
			var input=$(".autocomplete-input");
			var proposals = $('<div id="amc_add_box"></div>')
				.addClass('proposal-box')
				.css({'width':input.width()+18,'top':input.height()+20});
			var proposalList = $('<ul></ul>').addClass('proposal-list');
			var button;
			if(params.showButton){
				//input.css('border-radius','3px 0 0 3px');
				button = $('<div></div>')
					.addClass('autocomplete-button')
					.html(params.buttonText)
					.css({'width':'60px','line-height':params.height+2+'px'})
					.click(function(){
						proposalList.empty();
						if(input.val())
							params.submitIn(input.val());
					});
				searchContainer.css('width',input.width()+button.width()+40);
			}
			proposals.append(proposalList);
			searchContainer.append(input);
			searchContainer.append(proposals);
			searchContainer.append(button);
			$(this).append(searchContainer);
			//添加监听方法
			input.keydown(function(e){
				switch(e.which){
					case 38://Up
						e.preventDefault();
						if((currentIndex - 1) >= 0){
							$('ul.proposal-list li').removeClass('selected');
							currentIndex --;
							var text = $("ul.proposal-list li:eq("+currentIndex+")").addClass('selected').html();
							input.val(text);
						}
						break;
					case 40://Down
						e.preventDefault();
						if((currentIndex+1)<matchArray.length){
							$('ul.proposal-list li').removeClass('selected');
							currentIndex ++;
							var text = $("ul.proposal-list li:eq("+currentIndex+")").addClass('selected').html();
							input.val(text);
						}
						break;
					case 13://Enter
						currentIndex = -1;
						proposalList.empty();
						if(input.val())
							params.submitIn(input.val());
						break;
					case 27:	//Esc
						currentIndex = -1;
						proposalList.empty();
						//input.val('');
						break;
				}
			});
			input.on("input",function(){
				proposalList.empty();
				var val = input.val();
				if(val){
					matchArray = params.searchIn(val);
					if(matchArray && matchArray.length>0){
						for(var test in matchArray){
							var element = $('<li></li>')
								.html(matchArray[test])
								.addClass('proposal')
								.click(function(){
									input.val($(this).html());
									proposalList.empty();
									params.submitIn(val);
								})
								.mouseenter(function() {
									$(this).addClass('selected');
								})
								.mouseleave(function() {
									$(this).removeClass('selected');
								});
							proposalList.append(element);
						}
					}
				}
			});
			input.blur(function(e){
				currentIndex = -1;
				proposalList.empty();
			});
		});
		return this;
	};
})(jQuery);