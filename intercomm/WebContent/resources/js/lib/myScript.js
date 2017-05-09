$(document).ready(function() {
	tabinfo('menulist','dashboard_line');
});
function tabinfo(txt, id) {
	$("."+txt+" span").click(function() {
		if($(this).attr("name")=="pdpTabs")
			$("span[name='pdpTabs']").removeClass("active");
		$(this).addClass("active");
	});
  
	$("."+txt+" span").each(function(index) {
		$(this).click(function() {
			var defaultindex=index;
			$("#"+id+" .tab").each(function(selectindex) {
				if(defaultindex==selectindex) {
					$("#"+id+" .tab").hide();
					$(this).show();
				}
			});
		});
	});
}