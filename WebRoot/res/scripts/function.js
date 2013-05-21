$(function(){

	//(教务提醒)-鼠标滑过tab切换
	$('.notice_nav li a').hover(function(){
		$('.actived').removeClass('actived');
		$(this).addClass('actived');
		var aIndex =$(this).parent().index();
		$('.list_box').hide().eq(aIndex).show();
		
		return false;
	});
	
	//(招生信息)-鼠标滑过tab切换
	$('.intro_nav li a').hover(function(){
		$('.onClick').removeClass('onClick');
		$(this).addClass('onClick');
		var aIndex =$(this).parent().index();
		$('.intro_txt').hide().eq(aIndex).show();
	});
	
	//装备管理数据鼠标效果
	$('.data li').hover(function(){
		$(this).children('.status').addClass('hover_status');
	},function(){
		$(this).children('.status').removeClass('hover_status');
	});
	
	//装备管理数据点击效果
	$('.data li').toggle(function(){
		$(this).addClass('click');
		$(this).children('.status').addClass('click_status');
	},function(){
		$(this).removeClass('click');
		$(this).children('.status').removeClass('click_status');
	});
	
	//装备管理数据操作:编辑
	$('.editData').click(function(event){
		event.stopPropagation();//阻止冒泡
	});
	
	//装备管理数据操作:删除
	$('.delData').click(function(event){
		event.stopPropagation();//阻止冒泡
	});
});