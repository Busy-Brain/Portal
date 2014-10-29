/**
 * Add Questions Page
 */
var uniqueRowId = 1;
function addOptionalAnswer() {
	uniqueRowId++;
	if ($('.incorrectAnswer') + $('correctAnswer') >= 5) {
		alert("Maximum number of answers achieved.");
		return false;
	}
	var optionrowDiv = $('<div class="row" />');
	optionrowDiv.attr('id', 'ansRow' + uniqueRowId);
	var label = $('<div class="col-md"><label class="form-label">Optional Answer</label></div>');
	var correctAnsCheck = $('<span class="col-md"><div class="checkbox"><label><input type="checkbox" onclick="toggleAnswerCorrectness('
			+ uniqueRowId + ')" />Is Correct Answer?</label></div></span>');
	var deleteButton = $('<span class="col-md"><a class="btn btn-primary" onclick="deleteAnsRow('
			+ uniqueRowId + ')">Delete Option</a></span>');
	var textArea = $('<div class="col-md"><textarea class="form-control incorrectAnswer"></textarea></div>');
	var tab = $('<t/>');

	optionrowDiv.append(label);
	optionrowDiv.append(correctAnsCheck);
	optionrowDiv.append(deleteButton);
	optionrowDiv.append(textArea);

	$('#AddOptionButton').before(optionrowDiv);
}
function deleteAnsRow(rowID) {
	$('#ansRow' + rowID).remove();
}
function toggleAnswerCorrectness(rowID) {
	if ($('#ansRow' + rowID).find('input:checkbox').is(':checked')) {
		$('#ansRow' + rowID).find('textarea').removeClass('incorrectAnswer');
		$('#ansRow' + rowID).find('textarea').addClass('correctAnswer');

	} else {
		$('#ansRow' + rowID).find('textarea').removeClass('correctAnswer');
		$('#ansRow' + rowID).find('textarea').addClass('incorrectAnswer');
	}

}
function addTag() {
	var newTag = $('#tagText').val();
	$('#tags').append(
			'<a href="#"><span class="badge">' + newTag + '</span></a>');
	$('#tagText').val('');
}
function saveQuestion() {
	var questionDescription = $('#questionDescription').val();
	var xml = "<QUESTION>";
	xml = xml + "<QUESTIONDESCRIPTION>" + questionDescription
			+ "</QUESTIONDESCRIPTION>";
	var difficultylevel = $("#difficultyRating").val();
	xml = xml + "<DIFFICULTYLEVEL>" + difficultylevel + "</DIFFICULTYLEVEL>";
	xml = xml + "<ANSWERS>";
	var correctAnswer = $('.correctAnswer');
	var numberOfCorrectAnswers = correctAnswer.length;

	//
	var incorrectAnswer = $('.incorrectAnswer');
	var numberOfinCorrectAnswers = incorrectAnswer.length;
	if (numberOfinCorrectAnswers > 1) {

		for ( var i = 0; i < numberOfinCorrectAnswers; i++) {
			anstag = 'incorrectAns' + i;

		}
	}
	//

	var tags = $('#tags a span');
	var allTags = "";
	if ((tags.length < 1) || (tags.length > 10)) {
		alert("Please provide some tags count within 10");
		return false;
	}
	for ( var j = 0; j < tags.length; j++) {

		allTags = allTags + ',' + tags[j].textContent;
	}

	$.ajax({
		url : "http://localhost:7777/qbank/savequestion",
		data : {
			question : questionDescription,
			correctans : correctAnswer.val(),
			option1 : incorrectAnswer[0].value,
			option2 : incorrectAnswer[1].value,
			option3 : incorrectAnswer[2].value,
			difficultylevel : difficultylevel,
			allTags : allTags
		},
		contentType : 'application/json',
		dataType : 'json',
		success : function(data) {
			alert('success');
		},
		error : function(data) {
			alert('failure');
		}
	});
}