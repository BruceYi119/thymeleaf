'use strict';

const initDetail = () => {
	$('#btn-delete').bind('click', () => {
		const bno = $('input[name=bno]').val();

		$.ajax({
			url: '/board',
		    type: "DELETE",
		    data: { bno: bno },
		    success: (res) => {
		        if (res === 'succ') {
		        	location.href='/board/list';
		        } else {
		        	alert('삭제 실패!');
		        }
		    }
		});
	});
};

initDetail();