function getAvailableTests() {
	$
			.ajax({
				type : "GET",
				contentType : "text/JSON; charset=utf-8",
				url : "http://localhost:7777/qbank/test/available/",
				complete : function() {

				},
				success : function(data) {

					var json;

					json = JSON.parse(data);
					
					var rowStart=1;
					var NoOfCols=3;
					
					var html = "<div class='row'>";
					for ( var i = 0; i < json.tests.length; i++) {
						
					if((i)%3==0){
						
						html=html+'</div><div class="row">';
					}

						html = html
								+ '<div class="col-md-4" onclick="loadTest('+json.tests[i].id+')"><div class="well" ><div class="media"><img class="media-object"	src="https://builder.divshot.com/img/placeholder-64x64.gif" /><h4 class="media-heading">'
								+ json.tests[i].testname + '</h4><h6>'
								+ json.tests[i].description
								+ '</h6></div></div></div>';
						
					}
					html=html+'</div>'
					$('.jumbotron .container ').append(html);

				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert('Error: ' + textStatus + ' ' + errorThrown);
				}
			});
}

function loadTest(testId){
	location.href='http://localhost:7777/qbank/static/pages/testdetails.html?ID='+testId;
}