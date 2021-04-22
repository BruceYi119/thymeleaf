'use strict';

const editOption = {
	lang: 'ko-KR',									// default: 'en-US'
	placeholder: 'thymeleaf board!',
	tabsize: 2,
	height: 300,
	minHeight: 100,
	maxHeight: 500,
	focus: true,									// set focus to editable area after initializing summe
	fontNames: ['돋움', '궁서', '맑은 고딕', '함초롬바탕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', 'Merriweather'],
	toolbar: [
		// [groupName, [list of button]]
		['Font Style', ['fontname']],
		['style', ['bold', 'italic', 'underline', 'clear']],
		['font', ['strikethrough']],
		['fontsize', ['fontsize']],
		['color', ['color']],
		['para', ['paragraph']],
		['height', ['height']],
		['Insert', ['picture']],
		['Insert', ['link']],
		['Misc', ['fullscreen']]
	]
	//fontNamesIgnoreCheck: ['Merriweather']
};

const initEdit = (option = editOption, target = null) => {
	if (target === null)
		$('#edit').summernote(option);
	else
		$(`#${target}`).summernote(option);
};