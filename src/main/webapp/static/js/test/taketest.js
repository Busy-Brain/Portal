var testId="";
function loadTest(){
	
	 testId=GetURLParameter('ID');
	$
	.ajax({
		type : "GET",
		contentType : "text/JSON; charset=utf-8",
		url : "http://localhost:7777/qbank/test/details?ID="+testId,
		complete : function() {

		},
		success : function(data) {
			var json;

			json = JSON.parse(data);
			console.log(json);
			var testdiv=$('<div class="jumbotron"></div>');
			testdiv.append('<h1>'+json.testName+'</h1>');
			testdiv.append('<p>'+json.testDescription+'</p>');
			testdiv.append('<table class="table"><tbody>');
			
			
			
			testdiv.append('<tr><th>Subject</th><td>'+json.testSubject+'</td></tr>');
			testdiv.append('<tr><th>Created By</th><td>'+json.testCreator+'</td></tr>');
			testdiv.append('<tr><th>Access Level</th><td>'+json.testAccess+'</td></tr>');
              testdiv.append('</tbody></table>');
			testdiv.append('<p class="text-center"><a class="btn btn-primary btn-lg " onclick="begin()">Begin Test</a></p>');
			$('.jumbotron .container ').append(testdiv);

		},
		error : function(jqXHR, textStatus, errorThrown) {
			$('.jumbotron .container ').append('The test you are looking for is unavailable at this moment.');
		}
	});
}
function begin(){
	$
	.ajax({
		type : "GET",
		contentType : "text/JSON; charset=utf-8",
		url : "http://localhost:7777/qbank/test/start?ID="+testId,
		complete : function() {

		},
		success:function(){
			alert('success');
			}
		});
	alert('Starting');
}