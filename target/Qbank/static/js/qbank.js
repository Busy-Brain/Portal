/**
 * Common JavaScript
 */
function getTopNavigationLinks() {
	$
			.ajax({
				type : "GET",
				contentType : "text/JSON; charset=utf-8",
				url : "http://localhost:7777/qbank/getTopNavigation",
				complete: function(){
					
				},
				success : function(data) {

					var json, left;

					json = JSON.parse(data);
					left = "<ul class=\"nav navbar-nav\">";
					for ( var i = 0; i < json.links.length; i++) {
						
						
						if (typeof json.links[i].Link.childLinks == 'undefined') {
							left = left + "<li><a href=\"/qbank/"
									+ json.links[i].Link.linkURL + "\">"
									+ json.links[i].Link.linkTitle
									+ "</a></li>";
						} else {
							left = left
									+ "<li class=\"dropdown\"><a href=\"#\"class=\"dropdown-toggle\""
									+ "data-toggle=\"dropdown\">"
									+ json.links[i].Link.linkTitle
									+ "<b class=\"caret\"></b></a>"
									+ "<ul class=\"dropdown-menu\">";
							
							for ( var j = 0; j < json.links[i].Link.childLinks.length; j++) {
								left = left
										+ "<li><a href=\"/qbank/"
										+ json.links[i].Link.childLinks[j].Link.linkURL
										+ "\">"
										+ json.links[i].Link.childLinks[j].Link.linkTitle
										+ "</a></li>";
							}
							left = left + "</ul></li>";
							
						}
					}
					left = left + "</ul>";
					
					var right = '<ul class="nav navbar-nav navbar-right"><li class=""><a href="http://localhost:7777/qbank/j_spring_security_logout">Logout</a></li></ul>';
					$('.navbar-collapse').html(left + right);

				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert('Error: ' + textStatus + ' ' + errorThrown);
				}
			});

}
function GetURLParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
     }
}